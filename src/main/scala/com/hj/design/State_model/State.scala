package com.hj.design.State_model

trait State {

  def doAction:Unit

}

class StartState extends State{
  override def doAction: Unit = {
    println("执行开始状态下的业务逻辑")
  }
}

class StopState extends State{
  override def doAction: Unit = {
    println("执行停止状态下的业务逻辑")
  }
}