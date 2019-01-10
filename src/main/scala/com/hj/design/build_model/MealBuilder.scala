package com.hj.design.build_model

/**
  * @author hejin-Yu
  * @desc
  **/
object MealBuilder {

  def prepareVegMeal:Meal={
    val meal = new Meal("蔬菜套餐")

    meal.addItem(new VegBurger)
    meal.addItem(new Pepsl)
    meal
  }


  def prepareNoneVegMeal:Meal={
    val meal = new Meal("非蔬菜套餐")

    meal.addItem(new ChikenBurger)
    meal.addItem(new Coke)
    meal
  }
}
