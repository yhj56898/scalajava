package com.hj.thread.sysn

/**
  * @author hejin-Yu
  *
  *
  *
  **/
object TestProWithConsumer {

  def main(args: Array[String]) {

    val corordinator1:Corordinator1[String] = new Corordinator1[String]()

    val p = new Producer1[String](corordinator1)
    val c = new Consumer1[String](corordinator1)


    testPro(p)
    testConsumer(c)



  }

  def testPro(p:Producer1[String])={
    new Thread(new Runnable {
      override def run(): Unit = {}

      for(i<- 0 to 9){
        p.put("msg"+i)
      }

      /*--------------------------引入哨兵--------------*/

      p.put("end")

    }).start()
  }

  def testConsumer(c:Consumer1[String])={
    new Thread(new Runnable {
      override def run(): Unit = {

        var rs:String = c.take
        while(rs!="end"){

          println("消费到的信息有:"+rs)

          rs = c.take
        }

      }
    }).start()
  }

}


