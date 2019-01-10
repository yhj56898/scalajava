package com.hj.design.abstractFactory_model

/**
  * @author hejin-Yu
  * @desc
  **/
class Red extends Color {
  override def fill: Unit = {
    println("填充色为红")
  }
}
class Green extends Color{
  override def fill: Unit = {
    println("填充色为绿")
  }
}
class Blue extends Color{
  override def fill: Unit = {
    println("填充色为蓝")
  }
}
