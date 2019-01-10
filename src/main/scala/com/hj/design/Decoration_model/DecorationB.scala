package com.hj.design.Decoration_model

/**
  * @author hejin-Yu
  * @desc
  **/
class DecorationB(cpn:ComponetInstance) extends Decorator(cpn){
  override def extFun(): Unit = {
    println("使用了B类装饰器进行了功能扩展")
  }
}
