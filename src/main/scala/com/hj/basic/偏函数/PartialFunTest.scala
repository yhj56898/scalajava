package com.hj.basic.偏函数

/**
  * @author hejin-Yu
  * 偏函数
  *
  **/
object PartialFunTest {

  def main(args: Array[String]) {

    val msg1= out("one")
    val msg2 = out("two")
    val msg3 = out("other...")


    println("msg1",msg1)
    println("msg2",msg2)
    println("msg3",msg3)

  }

  /*------------
  [ 入参--数据类型, 出参---数据类型 ]


  基于模式匹配
  -----------------------------------------------*/

  def out:PartialFunction[String,Msg]={

    case "one" => Msg("this is case  one")
    case "two" => Msg("this is case  two")
    case _ => Msg("this is other case")

  }

  case class Msg(msg:String)
}
