package com.hj.design.Decoration_model.scene

import org.slf4j.Logger


/**
  * @author hejin-Yu
  * @desc
  **/
abstract class LogDecoration2(log:Logger) {

      /*
           * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
           *
           * 基于接口实现的 装饰模式
           *
           * 若接口方法过多，但是，只需要强化若干个方法之时
           *
           * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
           */

  def infor(msg:String): Unit ={
    val rs =extFun(msg)
    log.info(rs)
  }
  def error(msg:String):Unit={
    val rs =extFun(msg)
    log.error(rs)
  }

  protected def extFun(msg:String):String
}

class JsonObjectLogDecoration(log:Logger) extends LogDecoration2(log){
  override def extFun(msg: String): String = {
     "-----组装了一些jsonObject信息【包名、类名、方法名、参数列表信息等】"
  }
}
