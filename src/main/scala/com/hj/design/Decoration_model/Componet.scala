package com.hj.design.Decoration_model

/**
  * https://www.cnblogs.com/jzb-blog/p/6717349.html
  */
trait Componet {
  def biu: Unit
}

class ComponetInstance extends Componet {
  override def biu: Unit = println("ComponetInstance invoked biu!")
}

/*
     * ~~~~~~~~~~~~~~~~~~~~~~
     * 装饰器的扩展类，需要针对ComponetInstance，做功能性扩展
     * 其实，代理模式，也是可以的
     * ~~~~~~~~~~~~~~~~~~~~~~
     */
abstract class Decorator(cpn: ComponetInstance) extends Componet {
  override def biu: Unit = {
    /*
         * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
         *
         * 通过构造器，注入
         * 然后，在装饰扩展类中，加入，扩展(强化)的功能
         * ，
         * 但是，
         * 考虑到，装饰器，可以有多种多样的个性化因素的存在性，可以，进行抽象化本类处理,
         * 在本抽象类中，进行针对性的功能扩展（强化）
         * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
         */



    cpn.biu
    extFun //调用扩展功能
  }
  def extFun():Unit
}
