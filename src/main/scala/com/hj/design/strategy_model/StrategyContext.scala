package com.hj.design.strategy_model

/**
  * @author hejin-Yu
  * @desc
  **/
class StrategyContext(strategy: Strategy) {

  def excute(num1:Int,num2:Int): Int ={
    strategy.doOperation(num1,num2)
  }

}
