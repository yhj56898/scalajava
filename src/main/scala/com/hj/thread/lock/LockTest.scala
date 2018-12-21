package com.hj.thread.lock

/**
  * @author hejin-Yu
  *
  *
  **/
object LockTest {

  def main(args: Array[String]) {

    testPut
    testget

  }

  def testPut:Unit={
    new Thread(new Runnable {
      override def run(): Unit = {

        for(i<- 0 to 19){
          LockInstance.put("msg"+i)
        }

        //加入哨兵
        LockInstance.put("end")
      }
    }).start()
  }

  def testget:Unit={

    new Thread(new Runnable {
      override def run(): Unit = {
        var rs =LockInstance.get(2000) //2秒
        while(rs !="end"){

          println(s"消费到信息为 ${rs}")

          rs = LockInstance.get(2000) //2秒
        }

      }
    }).start()

  }

}
