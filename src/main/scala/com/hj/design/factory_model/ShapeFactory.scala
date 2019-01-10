package com.hj.design.factory_model

import com.hj.design.Constant.ShapeType
import com.hj.design.Constant.ShapeType._
import com.hj.design.factory_model.factory.Shape
/**
  * @author hejin-Yu
  * @desc
  **/
class ShapeFactory {

  def getShape(shapeType:ShapeType): Shape ={

    shapeType match {
      case ShapeType.circle => new Circle
      case ShapeType.squre => new Squre
      case _ => new Rectangle
    }

  }

}
