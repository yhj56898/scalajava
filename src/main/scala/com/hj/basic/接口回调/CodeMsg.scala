package com.hj.basic.接口回调

/**
  * @author hejin-Yu
  *
  *
  **/
case class CodeMsg(code:Int,msg:String)

trait CallBak[T]{

  def call(t:T):Unit

}
