package com.hj.design.Decoration_model;

/**
 * @author hejin-Yu
 * @desc
 */
public class DecorationA extends Decorator {
    public DecorationA(ComponetInstance cpn) {
        super(cpn);
    }

    @Override
    public void extFun() {
        System.out.println("使用了A装饰器，进行了功能扩展");
    }
}
