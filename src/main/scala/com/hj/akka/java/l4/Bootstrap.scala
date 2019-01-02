package com.hj.akka.java.l4

/**
  * @author hejin-Yu
  *
  *
  **/
object Bootstrap {

  def main(args: Array[String]) {

    println("Bootstrap starting")

    val loop = new TaskEventLoop("event-processor-loop").start()

    for(i<- 0 to 9){
      loop.post(TaskSubmit(s"任务${i}"))
    }

    loop.stop()

  }

}
