package com.hj.design.strategy_model

/**
  * @author hejin-Yu
  * @desc
  **/
class OperationAdd extends Strategy {
  override def doOperation(num1: Int, num2: Int): Int = {
    num1 + num2
  }
}
class OperationMultiply extends Strategy{
  override def doOperation(num1: Int, num2: Int): Int = num1 * num2
}

class OperationSubstract extends Strategy{
  override def doOperation(num1: Int, num2: Int): Int =  num1 - num2
}
