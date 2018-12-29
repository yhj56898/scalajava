package com.hj.akka.java.l5

/**
  * @author hejin-Yu
  * @desc
  **/
object Thread01 {

  def main(args: Array[String]): Unit = {

    val thread =new Thread("测试下Daemon"){
      setDaemon(true)

      override def run(): Unit = {

        for(i <- 1 to 20) println(i)
      }
    }


    thread.start()
    println("123")

  }

  /*------------------

  上述代码，执行结果是  控制台打印出了 123

  但是没有，意向中的 控制台打印输出  1 to 20 内元素
  ------------------------------------------------*/


  /*-------------------------
  主线程中

    若主线程中，最后只有后台线程，JVM将直接结束
  -----------------------------------------*/

}
