package com.hj.akka.java.l5

import java.util.concurrent.{Callable, Executors, Future}

/**
  * @author hejin-Yu
  *
  *
  **/
object ThreadDemo {

  def main(args: Array[String]) {

    val pool =Executors.newFixedThreadPool(5)


    val f:Future[Int] = pool.submit(new Callable[Int] {
      override def call(): Int = {
        Thread.sleep(1000)
        100
      }
    })

      println(f.get())


  }

}
