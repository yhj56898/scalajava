package com.hj.akka.java.l2

import akka.actor.{Actor, ActorSelection, ActorSystem, Props}
import com.typesafe.config.ConfigFactory

/**
  * @author hejin-Yu
  * @desc
  **/
class Worker(val masterHost: String, val masterPort: Int) extends Actor{

  var master : ActorSelection = _
  //建立连接
  override def preStart(): Unit = {
    //在master启动时会打印下面的那个协议, 可以先用这个做一个标志, 连接哪个master
    //继承actor后会有一个context, 可以通过它来连接
    master = context.actorSelection(s"akka.tcp://MasterSystem@$masterHost:$masterPort/user/Master") //需要有/user, Master要和master那边创建的名字保持一致
    master ! "connect"
  }

  override def receive: Receive = {
    case "reply" => {
      println("a reply form master")
    }
  }
}

object Worker {
  def main(args: Array[String]) {
    val host = args(0)
    val port = args(1).toInt
    val masterHost = args(2)
    val masterPort = args(3).toInt
    // 准备配置
    val configStr =
      s"""
         |akka.actor.provider = "akka.remote.RemoteActorRefProvider"
         |akka.remote.netty.tcp.hostname = "$host"
         |akka.remote.netty.tcp.port = "$port"
       """.stripMargin
    val config = ConfigFactory.parseString(configStr)
    //ActorSystem老大，辅助创建和监控下面的Actor，他是单例的
    val actorSystem = ActorSystem("WorkerSystem", config)
    actorSystem.actorOf(Props(new Worker(masterHost, masterPort)), "Worker")
    actorSystem.awaitTermination()
  }

}
