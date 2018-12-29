package com.hj.akka.java.l2

import java.util.UUID

import akka.actor.{Actor, ActorSelection, ActorSystem, Props}
import com.typesafe.config.ConfigFactory

import scala.concurrent.duration._

/**
  * @author hejin-Yu
  * @desc
  **/
class Worker(masterHost:String,masterPort:Int) extends Actor{

  val id =UUID.randomUUID().toString
  val sendInterval = 6000

  var master:ActorSelection = _
  override def receive: Receive = {

    case RegistedSuccess=>{
      println("接收到Master发来的注册成功返回")
      import context.dispatcher
      context.system.scheduler.schedule(0 millis,sendInterval millis,self,SendHeartbeat)
    }
    case SendHeartbeat=>{
      println("send heartBeat to Master")
      master ! ProceedHeartBeat(id)
    }

  }

  override def preStart(): Unit = {
    println(s"Worker[${id}] starting")
    master = context.actorSelection(s"akka.tcp://MasterSystem@${masterHost}:${masterPort}/user/Master")
    master ! RegisterWorkInfo(id)
  }
}
object Worker{

  def main(args: Array[String]): Unit = {

    val host="localhost"
    val port=args(0)
    val masterPort=args(1).toInt

    val config = ConfigFactory.parseString(
      s"""
        |akka.actor.provider="akka.remote.RemoteActorRefProvider"
        |akka.remote.netty.tcp.hostname=$host
        |akka.remote.netty.tcp.port=$port
      """.stripMargin)

    val workerSys = ActorSystem("WorkSystem",config)

    workerSys.actorOf(Props(new Worker(host,masterPort)))

  }

}
