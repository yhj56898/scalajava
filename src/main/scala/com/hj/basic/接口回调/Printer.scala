package com.hj.basic.接口回调

import java.util.concurrent.TimeUnit

/**
  * @author hejin-Yu
  *
  *
  * 对于打印机来讲
  *   打印是需要耗时的
  *
  *   所以，基于接口回调的思路，让外部调用者，获取来自接口传递而来的信息
  *
  **/
object Printer {

  def printSomthing(content:String,call: CallBak[CodeMsg]):Unit={
    try{
      println("打印机...开始打印")

      TimeUnit.SECONDS.sleep(2)//停顿2秒

      println(content)

      TimeUnit.SECONDS.sleep(1)//停顿2秒

      call.call(CodeMsg(1,"打印结束"))

    }catch{
        case e:Exception=> call.call(CodeMsg(0,e.getMessage))
    }finally{

      println("打印机...结束打印")
    }

  }

}
