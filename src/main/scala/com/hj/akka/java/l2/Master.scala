package com.hj.akka.java.l2

import akka.actor.{Actor, ActorSystem, Props}
import com.typesafe.config.ConfigFactory

import scala.concurrent.Await
import scala.concurrent.duration.Duration

/**
  * @author hejin-Yu
  * @desc
  **/
class Master extends Actor{

  println("constructor invoked!")

  /**
    * 消息处理
    * @return
    */
  override def receive: Receive = {

    case "connect" => {
      println("a client connected")
      sender ! "reply"
    }
    case "hello" =>{
      println("hello")
    }
  }

  override def preRestart(reason: Throwable, message: Option[Any]): Unit = {
    println("pre start(） invoked!")
  }
}
object Master{
  def main(args: Array[String]): Unit = {

    val host =args(0)
    val port = args(1)

    val configStr=
      s"""
        |akka.actor.provider = "akka.remote.RemoteActorRefProvider"
        |akka.remote.netty.tcp.hostname = "${host}"
        |akka.remote.netty.tcp.port = "$port"
      """.stripMargin

    val config =ConfigFactory.parseString(configStr)

    val actorSys = ActorSystem("MasterSystem",config)

    val master =actorSys.actorOf(Props[Master](),"Master")

    master !"hello"

    //Await.result[ActorSystem](actorSys,Duration.Inf)

    actorSys.awaitTermination()
  }
}
