package com.hj.akka.java.l3.MessageController

import akka.actor.{Actor, ActorSelection, ActorSystem, Props}
import com.typesafe.config.ConfigFactory

import scala.io.StdIn

/**
  * @author hejin-Yu
  * @desc
  **/
class ClientActor(serverHost:String,serverPort:Int) extends Actor{

  var server:ActorSelection = _


  override def preStart(): Unit = {

    server =context.actorSelection(s"akka.tcp://Server@${serverHost}:${serverPort}/user/server")

  }

  override def receive: Receive = {
    case "start" => println("client starting...")
    case ServerMsg(msg)=>{
      println(s"接收到来自服务端的一则消息【${msg}】")
    }
    case msg:String=>{ //向服务端

      server ! ClientMsg(msg)
    }
  }
}
object ClientActor{
  def main(args: Array[String]): Unit = {

    val host ="localhost"
    val port=8088

    val ServerHost =host
    val ServerPort = 8080

    val config = ConfigFactory.parseString(
      s"""
         |akka.actor.provider="akka.remote.RemoteActorRefProvider"
         |akka.remote.netty.tcp.hostname=$host
         |akka.remote.netty.tcp.port=$port
      """.stripMargin)

    val ac =ActorSystem("Client",config)

    val client =ac.actorOf(Props(new ClientActor(ServerHost,ServerPort)),"client")

    client ! "start"

    while(true){
      val rs = StdIn.readLine()
      client ! rs
    }

  }
}