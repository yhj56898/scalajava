package com.hj.design.Constant

import com.hj.design.Constant.TypeName.TypeName

/**
  * @author hejin-Yu
  *
  *
  **/

trait FactoryType{
  def getTypeName:TypeName
}


object ColorType extends Enumeration with FactoryType{

  type ColorType=Value
  val red,blue,green=Value

  override def getTypeName:TypeName = TypeName.colorType
}

object ShapeType extends Enumeration with FactoryType{

  type ShapeType =Value

  val circle,squre,rectangle =Value

  override def getTypeName: TypeName = TypeName.shapeType
}

object TypeName extends Enumeration{
  type TypeName=Value
  val colorType,shapeType =Value
}
