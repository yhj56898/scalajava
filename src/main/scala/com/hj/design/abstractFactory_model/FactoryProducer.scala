package com.hj.design.abstractFactory_model

import com.hj.design.Constant.TypeName
import com.hj.design.Constant.TypeName.TypeName
import com.hj.design.abstractFactory_model.outer.{ColrFactory, ShapeFactory}

/**
  * @author hejin-Yu
  * @desc
  **/
class FactoryProducer {


      /*
           * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
           *
           * 可以画
           * 可以进行颜色填充
           *
           * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
           */


  def getFactroy(typeName:TypeName):AbstractFactory={

    typeName match {
      case TypeName.shapeType =>{
        new ShapeFactory
      }
      case TypeName.colorType=>{
        new ColrFactory
      }
    }

  }
}
