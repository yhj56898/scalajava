package com.hj.design.invoked

import com.hj.design.Constant.{ColorType, ShapeType, TypeName}
import com.hj.design.abstractFactory_model.{AbstractFactory, FactoryProducer}
import com.hj.design.abstractFactory_model.outer.ColrFactory

/**
  * @author hejin-Yu
  **/
object AbstractFactoryTest {

  def main(args: Array[String]) {

    println("抽象工厂模式")

    val producer:FactoryProducer=new FactoryProducer


    println("从抽象工厂中提起 ShapeFactory")
    val shapeFactory =producer.getFactroy(TypeName.shapeType)

    println("get the ColrFactory from the producerFactory")

    val colrFactory:AbstractFactory= producer.getFactroy(TypeName.colorType)


        /*
             * ~~~~~~~~~~~~~~~~~~~~~~
             * 向上响应 具体的 实例
             * ~~~~~~~~~~~~~~~~~~~~~~
             */

    println("画图形")
    println("填充颜色")

    val circle =shapeFactory.getShape(shapeType = ShapeType.circle)
    val colr = colrFactory.getColor(ColorType.red)

    circle.draw
    colr.fill
  }

}
