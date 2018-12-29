package com.hj.akka.java.l3.lightbend.p1

import akka.actor.{Actor, ActorSystem, Props}

/**
  * @author hejin-Yu
  * @desc
  *
  *     actorOf -->创建一个actor
  *
  *     prestart  --->创建并启动之前触发
  *
  *     context.stop(self)-->
  *
  *        所有的子actor关闭后，最后才关闭父actor
  *
  **/
class StartStopActor1 extends Actor {
  override def receive: Receive = {
    case "stop" => context.stop(self)
  }

  override def preStart(): Unit = {
    println("first started")
    context.actorOf(StartStopActor2.props,"second")
  }

  override def postStop(): Unit = {
    println("first stopped")
  }
}
class StartStopActor2 extends Actor{

  override def receive: Receive = {
    Actor.emptyBehavior
  }

  override def preStart(): Unit = {
    println("second  started")
  }

  override def postStop(): Unit = {
    println("second stopped")
  }

}
object StartStopActor2 {
  def props: Props = Props(new StartStopActor2)
}

object StartStopActor1{

  def main(args: Array[String]): Unit = {

    val ac =ActorSystem("StartStopActor")

    val first  =ac.actorOf(Props[StartStopActor1],"first")

    first !"stop"

  }
}
