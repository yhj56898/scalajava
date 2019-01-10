package com.hj.design.Decoration_model.pack3

/**
  * http://www.runoob.com/design-pattern/decorator-pattern.html
  *
  * 模拟，LoL 英雄学技能
  */
trait Hero {

  def learnSkill()

  def name: String

}

/*
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *
     * 已有的功能实现
     * 初始化状态下，英雄是没有学任何技能的
     *
     * 需要有技能点时，方可点击学习
     *
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */

class BlindMonk extends Hero {

  override def name: String = "李青"

  override def learnSkill(): Unit = {
    println("英雄李青，学习了以上技能")
  }
}
