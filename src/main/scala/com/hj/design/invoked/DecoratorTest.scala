package com.hj.design.invoked

import com.hj.design.Decoration_model.{ComponetInstance, DecorationA}

/**
  * @author hejin-Yu
  * @desc
  **/
object DecoratorTest {

  def main(args: Array[String]): Unit = {


    val decorationA =new DecorationA(new ComponetInstance)

    decorationA.biu

  }

}
