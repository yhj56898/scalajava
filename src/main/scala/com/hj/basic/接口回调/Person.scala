package com.hj.basic.接口回调

/**
  * @author hejin-Yu
  * @desc
  **/
class Person(name: String) {

  def findJob: Unit = {

    val str = "个人求职简历"

    println(s"${name}需要一份一线城市的工作,准备打印自己的个人简历")

    /*----------------------处理这个接口-----------------------------------------------*/

    val rs_from_trait = Array[CodeMsg](null)

    Printer.printSomthing(str, new CallBak[CodeMsg] {
      override def call(t: CodeMsg): Unit = {

        rs_from_trait(0) = t //接收来自接口的信息

      }
    })

    /*----------------------输出这个消息-----------------------------------------------*/
    println(rs_from_trait(0))

    if (rs_from_trait(0).code == 1) {

      println("简历打完了,折腾去吧")
    }
  }


}

object Person {

  def main(args: Array[String]): Unit = {

    val p = new Person("hejin-yu")

    p.findJob

  }
}