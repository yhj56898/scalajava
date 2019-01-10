package com.hj.design.abstractFactory_model.outer

import com.hj.design.Constant.ColorType.ColorType
import com.hj.design.Constant.{ColorType, ShapeType}
import com.hj.design.Constant.ShapeType.ShapeType
import com.hj.design.abstractFactory_model
import com.hj.design.abstractFactory_model._
import com.hj.design.factory_model.factory.Shape
import com.hj.design.factory_model.{Circle, Rectangle, Squre}

/**
  * @author hejin-Yu
  * @desc
  **/
class ShapeFactory extends AbstractFactory{
  override def getShape(shapeType: ShapeType): Shape = {
    shapeType match {
      case ShapeType.circle => new Circle
      case ShapeType.squre => new Squre
      case ShapeType.rectangle => new Rectangle
    }
  }

  override def getColor(colorType: ColorType): Color = null
}
class ColrFactory extends AbstractFactory{
  override def getShape(shapeType: ShapeType): Shape = null

  override def getColor(colorType: ColorType): Color = {
    colorType match {
      case ColorType.red => new Red
      case ColorType.blue => new Blue
      case ColorType.green => new Green
    }
  }
}
