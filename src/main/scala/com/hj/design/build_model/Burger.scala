package com.hj.design.build_model

/**
  * @author hejin-Yu
  * @desc
  **/
abstract class Burger extends Item {
  override def packing(): Packing = new Wrapper
}

abstract class ColdDrink extends Item {
  override def packing(): Packing = new Bottle
}
