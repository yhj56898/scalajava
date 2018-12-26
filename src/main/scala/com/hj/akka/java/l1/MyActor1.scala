package com.hj.akka.java.l1

import java.util.concurrent.TimeUnit

import scala.actors.Actor
import scala.util.Random

/**
  * @author hejin-Yu
  *
  * 测试下同步
  **/
object MyActor1 {

  def main(args: Array[String]) {

    val ac = new MyActor1().start()
    /*---------------------并发发送5条消息，进行处理 ---------*/
    for(i<- 0 to 4){


    }

  }

}
class MyActor1 extends Actor{
  override def act(): Unit = {

    loop {
      react{
        case "start" => println("MyActor1 starting")
        case StopAc => exit();println("MyActor1 stopped")
        case SubmitTask(id,msg) =>{
          println("服务端开始处理")

          TimeUnit.SECONDS.sleep(Random.nextInt(10))

          sender ! ReplyMsg(id,"服务端处理后返回:"+msg)

          println("服务端结束处理")
        }
      }
    }

  }
}
case object StopAc
case class SubmitTask(id:Int,msg:String)
case class ReplyMsg(id:Int,msg:String)


