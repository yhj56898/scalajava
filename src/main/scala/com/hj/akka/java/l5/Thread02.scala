package com.hj.akka.java.l5

/**
  * @author hejin-Yu
  *
  *
  **/
object Thread02 {

  def main(args: Array[String]) {

    val thread =new Thread("不设置后台进程"){
      override def run(): Unit = {

        for(i <- 0 until 20) println(i)

      }
    }

    thread.start()
    println("123")

  }

  /*--------------------
  主线程 中，
    若有 用户线程 没有执行完毕，jvm不结束

    若只有后台线程，jvm直接结束
  --------------------------------------------*/
}
