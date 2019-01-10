package com.hj.design.build_model

/**
  * @author hejin-Yu
  * @desc
  **/
class VegBurger extends Burger {
  override def name(): String = "蔬菜汉堡"

  override def price(): Float = 23.3f
}
class ChikenBurger extends Burger{
  override def name(): String = "鸡肉汉堡"

  override def price(): Float = 56.5f
}

class Pepsl extends ColdDrink{
  override def name(): String = "百事可乐"

  override def price(): Float = 3.0f
}
class Coke extends ColdDrink{
  override def name(): String = "可口可乐"

  override def price(): Float = 3.0f
}
