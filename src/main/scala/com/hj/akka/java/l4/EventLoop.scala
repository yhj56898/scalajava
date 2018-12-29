package com.hj.akka.java.l4

import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.{BlockingDeque, LinkedBlockingDeque, TimeUnit}

import scala.util.control.NonFatal

/**
  * @author hejin-Yu
  * @desc
  **/
abstract class EventLoop[E](name: String) {

  /*------------
  基于队列，实现线程复用
  --------------------------------------------------------*/

  private val events: BlockingDeque[E] = new LinkedBlockingDeque[E]()

  /*来个原子操作*/
  private val stopped:AtomicBoolean = new AtomicBoolean(false)

  private val eventThread: Thread = new Thread(name) {

    //setDaemon(true)

    override def run(): Unit = {

      try{

        while(!stopped.get()){ // 线程未停止，实现Loop

          try{
            val event = events.take()
            onReceive(event)
          }catch {
            case NonFatal(e)=>{
              try{
                onError(e)
              }catch {
                case NonFatal(e)=> println("unexpected exception",e)
              }
            }
          }

        }

      }catch {
        case ie:InterruptedException => //线程中断
        case NonFatal(e)=>{
          try{
            onError(e)
          }catch {
            case NonFatal(e)=> println("unexpected Exception",e)
          }
        }
      }

    }
  }

  /*-----------------

  对外暴露的方法

  start
  stop
    ...
  ---------------------------------------------*/

  def start(): this.type ={
    if(stopped.get()){
      throw new IllegalStateException("eventThread has bean stopped")
    }
    eventThread.start()
    onStart
    this
  }

  def stop(): Unit={
    /*-----------------------实现优雅退出----------------------------------------*/
    gentlerfullyExit()

    if(stopped.compareAndSet(false,true)){

      eventThread.interrupt()
      var onCallStopped:Boolean =false
      try{

        eventThread.join()
        onCallStopped =true
        onStop
      }catch {
        case ie:InterruptedException=>{
          Thread.currentThread().interrupt()
          if(!onCallStopped){//没有执行 onStop
            onStop
          }
        }
      }
    }


  }

  def isActive: Boolean = eventThread.isAlive

  def post(event: E): Unit = {
    events.put(event)
  }

  /**
    * 优雅退出，避免程序没有跑完，就退出
    * @return
    */
  def gentlerfullyExit():Unit={

    var canBeExit =false
    while(!canBeExit){

      if(events.size()==0){
        canBeExit =true
      }
    }
  }

  /*-----------------
  不对外部包，提供访问权限的包内函数
  ------------------------------------------------*/

  protected def onStart: Unit={
    println ("EventLoop starting ....")
  }

  protected def onStop: Unit={
    println ("EventLoop stopped")
  }

  protected def onError(t: Throwable): Unit

  /*基于事件驱动，真正的业务逻辑，交由各个EventLopp的实现类，来实现*/
  protected def onReceive:PartialFunction[E,Unit]

}
