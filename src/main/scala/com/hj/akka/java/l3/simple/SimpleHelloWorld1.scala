package com.hj.akka.java.l3.simple

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import com.hj.akka.java.l1.Stop

/**
  * @author hejin-Yu
  * @desc
  **/
object SimpleHelloWorld1  extends App {

  val server  = ActorSystem("helloWorld")

 val taller:ActorRef= server.actorOf(Props[SimpleHelloWorld1])

  taller !SimpleGreet("dance")
  taller !SimplePraise("Winston")
  taller ! SimpleCelebrate("clare",18)
  taller ! Stop


}
class SimpleHelloWorld1 extends Actor{

  override def receive: Receive = {
    case SimpleGreet(name) => println(s"Hello $name")
    case SimplePraise(name) => println(s"$name, you're amazing")
    case SimpleCelebrate(name, age) => println(s"Here's to another $age years, $name")
    case Stop => context.system.shutdown() ;println("ActorSystem stopped")
  }

}

case class SimpleGreet(name: String)
case class SimplePraise(name: String)
case class SimpleCelebrate(name: String, age: Int)
