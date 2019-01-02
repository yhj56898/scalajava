package com.hj.akka.java.l4

import java.util.concurrent.TimeUnit


/**
  * @author hejin-Yu
  * @desc
  **/
class TaskEventLoop(name:String) extends EventLoop[TaskEvent](name){
  override protected def onError(t: Throwable): Unit = {
    println(t.getMessage)
  }

  override protected def onReceive: PartialFunction[TaskEvent, Unit] = {
   case TaskSubmit(name)=>{
      println("提交了一个任务",name)

      try{
        TimeUnit.SECONDS.sleep(2)
        if(name=="任务6"){

          throw new RuntimeException("任务6主动抛出了个异常")
        }
        post(TaskSuccedd(name))
      }catch {
        case e:Exception=>{
          post( TaskFailed(e))
        }
      }
    }
    case TaskSuccedd(name)=>{
      println(s"任务[${name}] 已经处理完毕")
    }
    case TaskFailed(t)=>{
      println(s"运行时异常",t.getMessage)
    }

    //case TaskSubmit(taskName) => println(taskName)
  }
}
