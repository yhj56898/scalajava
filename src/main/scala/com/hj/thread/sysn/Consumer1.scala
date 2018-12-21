package com.hj.thread.sysn

/**
  * @author hejin-Yu
  * @desc
  **/
class Consumer1[T](corordinator1: Corordinator1[T]) {

  def take:T={
    corordinator1.take
  }

}
