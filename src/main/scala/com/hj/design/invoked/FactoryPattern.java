package com.hj.design.invoked;

import com.hj.design.Constant.ShapeType;
import com.hj.design.factory_model.factory.Shape;
import com.hj.design.factory_model.ShapeFactory;

/**
 * @author hejin-Yu
 * @desc
 */
public class FactoryPattern {
    public static void main(String[] args) {

        /**
         * 基于ShapeFactory,来动态进行生产
         */

        ShapeFactory factory = new ShapeFactory();

        System.out.println("想画圆,由工厂中获取画圆的实例");

        Shape shape = factory.getShape(ShapeType.circle());

        System.out.println("开始画圆");

        shape.draw();
    }
}
