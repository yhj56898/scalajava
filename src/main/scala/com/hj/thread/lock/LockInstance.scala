package com.hj.thread.lock

import java.util.concurrent.TimeUnit
import java.util.concurrent.locks.ReentrantLock

import scala.collection.mutable.ListBuffer

/**
  * @author hejin-Yu
  *
  *
  * 基于锁机制
  *   模拟下生产与消费
  **/
object LockInstance {

  private val lock = new ReentrantLock()
  private val isFull =  lock.newCondition()
  private val isEmpty = lock.newCondition()

  private val data = ListBuffer[String]() //

  def put(ele:String):Unit={
    try{
      lock.lock()
      /* 测试需要，定义集合的容量大小为10 */
      while(data.size >  10){ //循环，阻塞下面的逻辑执行
        isFull.await()
      }

      data += ele

      /*-----------------------唤醒消费-----------------------*/
      isEmpty.signal()

    }catch{
        case e:Exception=> throw new RuntimeException(e)
    }finally{
      lock.unlock()
    }
  }

  /**
    * 模拟队列的 take
    * @param timeOut
    * @return
    */
  def get(timeOut:Long):AnyRef={
    try{
      lock.lock()

      val endTime = System.currentTimeMillis() + TimeUnit.MILLISECONDS.toMillis(timeOut)
      var rs:AnyRef=null

      while(data.size==0){ //陷入循环
        isEmpty.await()
      }

      while(System.currentTimeMillis() < endTime && rs==null){

        rs = data.head
        data.remove(0)

      }

      /*-------------------唤醒 生产----------------------*/
      isFull.signal()

      rs
    }catch{
        case e:Exception=> throw new RuntimeException(e)
    }finally{
      lock.unlock()
    }
  }


}
