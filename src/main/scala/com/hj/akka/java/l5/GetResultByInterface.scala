package com.hj.akka.java.l5

import java.util.concurrent.TimeUnit

import com.hj.akka.java.l5.ResultT.{Student, Teacher}

/**
  * @author hejin-Yu
  **/
object GetResultByInterface {

  /*--------------接口回调的核心思路

  业务逻辑处理者，需要基于接口，将【计算结果】置入接口内的方法中，透传过去


  业务数据需要者（调用者），只需要，基于匿名实现类，直接接收即可

  --------------------------------------------------------------------*/


  def main(args: Array[String]) {

    val wangT = new Teacher("张")

    val LiS = new Student("李花花")


    val question="1+1"
   val answer= LiS.askQuestion2Teacher(question,wangT)

    println("1+1="+answer)
  }

}

object ResultT {

  /*
  * 定义一个接口
  *       执行一个回调逻辑
  * */
  trait CallBak[T] {
    def doProcess(rs: T): Unit
  }

  class Student(name: String) {
    def askQuestion2Teacher(question: String,teacher:Teacher): String = {

      val result:Array[Int]=Array[Int](0)
      teacher.answerQuestion(question,new CallBak[Int] {
        override def doProcess(rs: Int): Unit = {
          result(0)= rs
        }
      })

      result(0).toString
    }

  }

  class Teacher(name: String) {
    def answerQuestion(question: String, callBak: CallBak[Int]):Unit = {

      question match {
        case "1+1"=> {
          TimeUnit.SECONDS.sleep(3)
          callBak.doProcess(2)
        }
        case "2*3" =>{
          TimeUnit.SECONDS.sleep(3)
          callBak.doProcess(6)
        }
        case _ =>{
          TimeUnit.SECONDS.sleep(3)
          callBak.doProcess(100)
        }
      }

    }
  }

}
