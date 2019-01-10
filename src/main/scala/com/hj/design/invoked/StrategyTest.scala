package com.hj.design.invoked

import com.hj.design.strategy_model.{OperationAdd, StrategyContext}

/**
  * @author hejin-Yu
  *
  * 解决的是 if else 多分支，条件选择的问题
  *
  * Context ctx =new Context( new Impl(){
  * })
  *
  *
  * 另外一个行为模式，与之很类似，解决的也是 if...else问题
  * Context  ctx = new Context()
  * ctx.setState =new State(){
  *   }
  **/
object StrategyTest {

  def main(args: Array[String]) {

    val (num1,num2)=(10,5)

    val context1 =new StrategyContext(new OperationAdd)

    val add =context1.excute(num1,num2)

    println(s"add =${add}")
  }

}
