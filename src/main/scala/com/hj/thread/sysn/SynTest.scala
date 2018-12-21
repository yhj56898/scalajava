package com.hj.thread.sysn

/**
  * @author hejin-Yu
  *
  *
  **/
object SynTest {

  def main(args: Array[String]) {

    new Thread(new Runnable {
      override def run(): Unit = {

        for(i <- 0 to 9){
          SynInstance.addOp // 加1操作
        }

      }
    }).start()



    new Thread(new Runnable {
      override def run(): Unit = {

        for(i<- 0 to 9){
          SynInstance.minusOp // 减1操作
        }

      }
    }).start()


    /*----------------------最后验证上述所想，是否经过
    多线程处理后，仍然 归零
    ----------------------------------------------*/
    println(s"at last,the result is ${SynInstance.getInitVal}")
  }

}
