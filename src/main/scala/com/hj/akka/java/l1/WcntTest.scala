package com.hj.akka.java.l1

import scala.actors.{Actor, Future}
import scala.collection.mutable.ListBuffer
import scala.io.Source

/**
  * @author hejin-Yu
  *
  *
  **/
class WcntTest(file:String) extends Actor{
  override def act(): Unit = {

    loop {

      react{

        case "start" => println("WcntTest starting.....")
        case Stop => exit(); println("WcntTest stopped.....")
        case SubmitTask=> {
          val rs:Map[String,Int]= Source.fromFile(file).getLines().flatMap(_.split("\t")).map((_,1))
            .toList.groupBy(_._1)
            .mapValues(_.size)

          sender ! ReMsg(rs)
        }
      }
    }

  }
}

case object SubmitTask
case class ReMsg(rs:Map[String,Int])
case object Stop

object WcntTest{

  def main(args: Array[String]): Unit = {

    val fs =ListBuffer[Actor]()
    val data = ListBuffer[Future[Any]]()
    val rs = ListBuffer[ReMsg]()

    val files =Array("F:\\word.txt","F:\\word2.txt")
    for(file <- files){
      fs += new WcntTest(file)
    }

    fs.foreach(f=> {
      f.start() ! "start"
     val r = f !! SubmitTask

      data += r
    })

    while(data.size >0){

      val f =data.head
      if(f.isSet){
        rs += f().asInstanceOf[ReMsg]
        data -= f
      }

    }



   val result= rs.flatMap(_.rs).groupBy(_._1).mapValues(_.foldLeft(0)(_ + _._2))


    println(result)

  }

}
