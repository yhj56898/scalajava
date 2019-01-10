package com.hj.design.invoked

import com.hj.design.Decoration_model.pack2.{Circle, RedDecorationShape, Shape}

/**
  * @author hejin-Yu
  *
  *
  **/
object DecorationShapeTest {

  def main(args: Array[String]) {

        /*
             * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
             *
             *
             * 通过装饰器模式，简单的扩展下已有类的功能
             * 复杂的业务逻辑，可以使用 混合架构【搭配 建造者模式+抽象工厂模式】，来解决
             * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
             */


    /**
      * 已有实现类
      */

    val circle:Shape = new Circle

    /**
      * 扩展这个画圆功能，我需要填充红色
      */

    val red_decoration =new RedDecorationShape(circle)


    red_decoration.draw()
        /*
             * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
             *
             * 最后，就话了个圆，且给这个圆，填充了红色
             *
             * 复杂场景下，需要结合 建造者模式，进行对象创建时的 更详尽的信息 扩充
             * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
             */
  }

}
