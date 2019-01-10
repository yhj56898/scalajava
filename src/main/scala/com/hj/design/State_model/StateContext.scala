package com.hj.design.State_model

/**
  * @author hejin-Yu
  * @desc
  **/
class StateContext {

  private var state:State= new StartState

  def setState(state:State):Unit={
    this.state = state
  }

  def doJob:Unit={
    state.doAction
  }

}
