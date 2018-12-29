package com.hj.akka.java.l3.lightbend.p1

import akka.actor.{Actor, ActorSystem, Props}

/**
  * @author hejin-Yu
  * @desc
  *
  *      父actor中 创建子actor
  *
  *       若子actor异常--> 父actor将会收到子actor的异常，且异常的子actor将会立即触发restart
  *
  **/
class SupervisingActor extends Actor{

  val child =context.actorOf(Props[SupervisedActor])

  override def receive: Receive = {

    case "failChild"=>  child ! "fail"
  }
}
class SupervisedActor  extends Actor{
  override def receive: Receive = {

    /*-----------------若有异常-----------*/
    case "fail" =>{
      println("Supervised actor fails now")
      throw new Exception("I failed!")
    }

  }

  override def preStart(): Unit = {
    println("supervised actor started")
  }


  override def postStop(): Unit = {
    println("Supervised actor stopped")
  }

}

/*--------------------

main

1.ActorSystem
2. SupervisingActor创建
3 创建SupervisingActor 发送 failChild

4. 子actor ,will throw Exceptions

5 observing this processing
--------------------------------------------------------*/
object SupervisingActor{

  def main(args: Array[String]): Unit = {

    val ac =ActorSystem("Supervising")

    val supervising = ac.actorOf(Props[SupervisingActor],"supervising")

    supervising ! "failChild"

  }
}
