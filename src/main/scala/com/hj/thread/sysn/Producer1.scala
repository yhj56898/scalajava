package com.hj.thread.sysn

/**
  * @author hejin-Yu
  * @desc
  **/
class Producer1[T](corordinator1: Corordinator1[T]) {

  def put(ele:T):Unit={
    corordinator1.put(ele)
  }

}
