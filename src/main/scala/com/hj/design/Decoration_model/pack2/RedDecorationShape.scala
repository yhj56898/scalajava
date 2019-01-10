package com.hj.design.Decoration_model.pack2

/**
  * @author hejin-Yu
  * @desc
  **/
class RedDecorationShape(shape: Shape) extends DecorationShape(shape){
  override def extFun(): Unit = {

    println("给已有的图形，填充了红色")

  }
}
