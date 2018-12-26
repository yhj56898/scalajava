package com.hj.akka.java.l3.MessageController

import akka.actor.{Actor, ActorSelection, ActorSystem, Props}
import com.typesafe.config.ConfigFactory

import scala.io.StdIn

/**
  * @author hejin-Yu
  * @desc
  **/
class ServerActor(clientHost: String, clientPort: Int) extends Actor {

  var client: ActorSelection = _


  override def preStart(): Unit = {

    client = context.actorSelection(s"akka.tcp://Client@${clientHost}:${clientPort}/user/client")

  }

  override def receive: Receive = {

    case "start" => println("server starting")
    case ClientMsg(msg)=>{
      println(s"接收到来自客户端的请求数据【${msg}】")
    }

    case msg:String =>{
      client ! ServerMsg(msg) //发送一条消息 To 客户端
    }

  }
}
object ServerActor{

  def main(args: Array[String]): Unit = {

    val host ="localhost"
    val port=8080

    val clientHost =host
    val clientPort =8088

    val config = ConfigFactory.parseString(
      s"""
        |akka.actor.provider="akka.remote.RemoteActorRefProvider"
        |akka.remote.netty.tcp.hostname=$host
        |akka.remote.netty.tcp.port=$port
      """.stripMargin)

    val ac =ActorSystem("Server",config)

    val server = ac.actorOf(Props(new ServerActor(clientHost,clientPort)),"server")

    server ! "start"

    while(true){
      val rs =StdIn.readLine()
      server ! rs
    }

  }

}
