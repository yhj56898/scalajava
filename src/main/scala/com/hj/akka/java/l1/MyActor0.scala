package com.hj.akka.java.l1

import java.util.concurrent.TimeUnit

import scala.actors.Actor

/**
  * @author hejin-Yu
  *
  *
  **/
class  MyActor0 extends Actor{
  override def act(): Unit = {

    loop{
      react{
        case "start" => println("MyActor0 starting ..... ")
        case Stop =>  exit();println("MyActor0 stopped ..... ")
        case Msg2(id,msg) => {

          TimeUnit.SECONDS.sleep(5)

          sender ! ReMsg2(id,"停顿5秒后，再次返回了消息："+msg)
        }
      }
    }

  }
}

case class Msg2(id:Int,meg:String)
case object Stop
case class ReMsg2(id:Int,msg:String)

object MyActor0{

  def main(args: Array[String]): Unit = {
    val ac = new MyActor0().start()

    ac !"start"

   val msg = ac !? (6000,Msg2(1,"发送了条同步消息"))

   val rs = msg.getOrElse(null)

    println(rs)

    ac ! Stop

  }

}