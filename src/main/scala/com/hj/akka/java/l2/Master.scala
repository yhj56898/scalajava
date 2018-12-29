package com.hj.akka.java.l2

import akka.actor.{Actor, ActorSystem, Props}
import com.typesafe.config.ConfigFactory

import scala.collection.mutable
import scala.concurrent.duration._

/**
  * @author hejin-Yu
  * @desc
  **/
class Master extends Actor {

  val id_workers = new mutable.HashMap[String, WorkInfo]()
  val workers = new mutable.HashSet[WorkInfo]()

  val check_interval = 8000

  override def receive: Receive = {

    case CheckTimeOut => {

      val curTime = System.currentTimeMillis()
      val removeW = workers.filter(w => {
        curTime - w.lastCheckTime > check_interval
      })

      removeW.foreach(w => {
        id_workers -= w.id
        workers -= w
      })

      println(s"Master中注册的存活Worker有【${workers.size}】个")
    }

    case RegisterWorkInfo(id) => {
      if (!id_workers.contains(id)) {
        println(s"接收到worker[${id}]的注册请求")

        val w = WorkInfo(id)
        id_workers += id -> w
        workers += w

        sender ! RegistedSuccess
      }
    }
    case ProceedHeartBeat(id) => {
      if (id_workers.contains(id)) {
        val w = id_workers(id)
        w.lastCheckTime = System.currentTimeMillis()
      }
    }
  }

  override def preStart(): Unit = {

    println("Master starting")

    import context.dispatcher
    context.system.scheduler.schedule(0 millis, check_interval millis, self, CheckTimeOut)
  }
}

object Master {
  def main(args: Array[String]): Unit = {

    val host = "localhost"

    val port = 8080

    val config =ConfigFactory.parseString(
      s"""
        |akka.actor.provider="akka.remote.RemoteActorRefProvider"
        |akka.remote.netty.tcp.hostname=$host
        |akka.remote.netty.tcp.port=$port
      """.stripMargin)

    val MasterSys = ActorSystem("MasterSystem",config)

    MasterSys.actorOf(Props[Master],"Master")


  }
}
