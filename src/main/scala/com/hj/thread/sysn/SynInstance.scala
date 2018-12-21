package com.hj.thread.sysn

/**
  * @author hejin-Yu
  *
  *
  * 多线程、高并发下
  *   需考虑的问题
  *     变量的可见性、原子性
  *
  *
  *     volatile
  *     syncronized
  *     lock
  *     都可以完成这个目标
  **/
object SynInstance {

  private var init:Int =0 //设置初始值

  /*-------------------
  基于Syncronized实现 类 volatile的功能
  -------------------------------------------*/

  def addOp:Unit={

    this.synchronized{
      init += 1
    }

  }

  def minusOp:Unit={
    this.synchronized{
      init -= 1
    }
  }

  def getInitVal:Int={
    init
  }


}
