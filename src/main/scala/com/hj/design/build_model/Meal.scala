package com.hj.design.build_model

import scala.collection.mutable.ListBuffer

/**
  * @author hejin-Yu
  * @desc
  *
  *      套餐
  **/
class Meal(val name:String) {

  private val items =ListBuffer[Item]()

  def  addItem(item:Item): Unit ={
    items += item
  }

  def price:Float={
    var sum=0.0f
    items.foreach(item=>{
      sum += item.price()
    })
    sum
  }

  def showItesm:Unit={
    items.foreach(item=>{
      println(
        s"""
          |item.name=${item.name()}
          |item.price=${item.price()}
          |item.packing=${item.packing().pack()}
          |
        """.stripMargin)
    })
  }

}
