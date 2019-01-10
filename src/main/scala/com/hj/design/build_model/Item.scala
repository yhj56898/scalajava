package com.hj.design.build_model

/**
  * http://www.runoob.com/design-pattern/builder-pattern.html
  *
  * 使用场景：
  * 1、需要生成的对象具有复杂的内部结构。
  * 2、需要生成的对象内部属性本身相互依赖。
  *
  * 主要解决：主要解决在软件系统中，有时候面临着"一个复杂对象"的创建工作，其通常由各个部分的子对象用一定的算法构成；
  * 由于需求的变化，这个复杂对象的各个部分经常面临着剧烈的变化，但是将它们组合在一起的算法却相对稳定。
  */
trait Item {

  def name():String
  def packing():Packing
  def price():Float

}

trait Packing{
  def pack():String
}

class Wrapper extends Packing{
  override def pack(): String = {
    "纸质包装"
  }
}

class Bottle extends Packing{
  override def pack(): String = {
    "瓶装"
  }
}
