package com.hj.design.Decoration_model.pack2;

/**
 * @author hejin-Yu
 * @desc
 *
 * 目的，扩展现有的功能，而扩展出来的装饰器
 * 核心逻辑：
 *  构造器中注入已有实现类，且本抽象类中，定义自己的功能扩展方法
 *
 */
public abstract class DecorationShape implements Shape{

    private Shape shape=null;

    public DecorationShape(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void draw() {
        shape.draw();
        extFun();
    }

        /*
             * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
             * 本抽象类中，定义自己的功能扩展函数
             *
             * 且在本类的接口实现方法中：
             * 1，调用已有实现类的目标方法
             * 2，调用本抽象类的扩展方法
             *
             * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
             */

        public abstract void extFun();
}
