package com.hj.akka.java.l3.simple

import akka.actor.{Actor, ActorSystem, PoisonPill, Props, Terminated}

/**
  * @author hejin-Yu
  *
  *
  **/
object SimpleHelloWord2 {

  def main(args: Array[String]) {

    val ac = ActorSystem("SimpleHelloWord2")

    ac.actorOf(Props[Master_2])


  }

}

class Worker_2 extends Actor {

  override def receive: Receive = {

    case BetterGreet(name) => println(s"hello $name")
    case BetterPraise(name) => {
      println(s"$name,you're amazing")
    }
    case BetterCelebrate(name, age) => {
      println(s"Here's to another $age years, $name")
    }

  }
}

class Master_2 extends Actor {

  private val talker = context.actorOf(Props[Worker_2])

  override def preStart(): Unit = {
    talker ! BetterGreet("Dante")
    talker ! BetterPraise("Winston")
    talker ! BetterCelebrate("Clare", 16)

    //发送一个毒丸，告诉actor已经结束了。因此后面发送的消息将不会被传递
    talker ! PoisonPill
    //talker ! BetterGreet("Dante"), 喂了毒药，消息就不能传递了
  }

  override def receive: Receive = {
    case Terminated(`talker`) => context.system.shutdown()
  }

}

case class BetterGreet(name: String)

case class BetterPraise(name: String)

case class BetterCelebrate(name: String, age: Int)
