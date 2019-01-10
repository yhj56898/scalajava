package com.hj.design.Decoration_model.pack2

/**
  * @author hejin-Yu
  * @desc
  *
  * http://www.runoob.com/design-pattern/decorator-pattern.html
  *
  * 装饰器模式，基于菜鸟教程
  **/
trait Shape {

  def draw: Unit

}

/*
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *
     *
     * 已有的实现类
     * 画圆，画矩形
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */

class Circle extends Shape{
  override def draw: Unit = {
    println("画了个圆")
  }
}
class Rectangle extends Shape{
  override def draw: Unit = {
    println("画了个矩形")
  }
}
