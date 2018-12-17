package com.hj.basic.设计模式

import java.util.Properties

/**
  * @author hejin-Yu
  *
  *
  * 方法模板
  *
  *   定义一堆的抽象方法
  *
  *   对外暴露的方法，会把这些 方法实现，串联起来
  *
  **/
object TemplateTest {

  def main(args: Array[String]) {

    /*---------------------进行逻辑回归二分类模型训练---------------------------------*/

    new LogisticRegressionMLJob(null).doExcute

  }

}

trait MLJob{
  //def on_config:Unit
  def on_init:Unit
  def on_start:Unit
  def on_success:Unit
  def on_failed:Unit
  def on_complete
}
trait Job{
  def doExcute:Unit
}

class LogisticRegressionMLJob(
                             pop:Properties
                             ) extends MLJob with Job {
 /* override def on_config: Unit = {
    println("加载配置信息")
  }*/

  override def on_init: Unit = {
    println("提取参数信息")
  }

  override def on_start: Unit = {
    println("running ....")
  }

  override def on_success: Unit = {
    println("执行成功")
  }

  override def on_failed: Unit = {
    println("执行失败....")
  }

  override def on_complete: Unit = {
    println("执行末尾，进行一些销毁操作")
  }

  override def doExcute: Unit = {

    try{
        on_init
        on_start
      on_success
    }catch{
        case e:Exception=> on_failed
    }finally{
      on_complete
    }

  }
}
object MLInvoke{

  def genMod(id:String,pop:Properties
                ):Unit={

    id match {
      case "xxx" =>  new LogisticRegressionMLJob(pop).doExcute
    }

  }

}