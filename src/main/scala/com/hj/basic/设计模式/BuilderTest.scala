package com.hj.basic.设计模式

/**
  * @author hejin-Yu
  *
  *         构建者
  *         ---------简化目标对象的创建
  *
  **/
object BuilderTest {

  def main(args: Array[String]) {
    /*--------------------早餐吃点 包子、豆浆-------------------------------------------------*/

    val breakFast: Meal = MealBuilder
      .food("包子")
      .drink("豆浆")
      .build

    println(breakFast)

  }

}

/*餐点*/
class Meal(food: String, drink: String) {
  override def toString: String = {
    new StringBuilder()
      .append(s"food=${food}\t")
      .append(s"drink=${drink}")
      .toString()
  }
}

object MealBuilder {
  private var _food: String = _
  private var _drink: String = _

  def build: Meal = {
    new Meal(_food, _drink)
  }

  def food(in_food: String): this.type = {
    _food = in_food
    this
  }

  def drink(in_drink: String): this.type = {
    this._drink = in_drink
    this
  }

}
