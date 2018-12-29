package com.hj.akka.java.l3.lightbend.p1

import akka.actor.{Actor, ActorSystem, Props}

import scala.io.StdIn

/**
  * @author hejin-Yu
  * @desc
  **/
class PrintMyActorRefActor extends Actor{
  override def receive: Receive = {

    case "printit"=>{
      val sencond = context.actorOf(Props.empty,"second-actor")
      println(s"second:${sencond}")
    }

  }
}
object PrintMyActorRefActor{
  def props:Props={
    Props[PrintMyActorRefActor]
  }
}

object  ActorHierarchyExperiments extends App {

  val system = ActorSystem("testSystem")

  val firstRef = system.actorOf(PrintMyActorRefActor.props, "first-actor")
  println(s"First: $firstRef")
  firstRef ! "printit"

  println(">>> Press ENTER to exit <<<")
  try StdIn.readLine()
  finally system.terminate()

}
