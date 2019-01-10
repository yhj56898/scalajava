package com.hj.design.factory_model

import com.hj.design.factory_model.factory.Shape

/**
  * @author hejin-Yu
  * @desc
  **/
class Circle extends Shape {
  override def draw: Unit = {
    println("画出了个圆...")
  }
}
class Squre extends Shape{
  override def draw: Unit = {
    println("画出了个方...")
  }
}
class Rectangle extends Shape{
  override def draw: Unit = {
    println("画出了个矩形...")
  }
}
