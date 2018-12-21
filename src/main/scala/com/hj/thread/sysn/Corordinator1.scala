package com.hj.thread.sysn

import java.util.concurrent.LinkedBlockingQueue

/**
  * @author hejin-Yu
  *
  *
  * 基于线程安全的阻塞队列，实现【生产、消费】
  *
  * 队列 LinkedBlockingQueue
  *
  *         add方法在添加元素的时候，若超出了度列的长度会直接抛出异常：
  *
  *         put方法，若向队尾添加元素的时候发现队列已经满了会发生阻塞一直等待空间，以加入元素。
  *         offer方法在添加元素时，如果发现队列已满无法添加的话，会直接返回false。
  **/
class Corordinator1[T] {

  private val data = new LinkedBlockingQueue[T]()

  def put(ele:T):Unit={
    data.put(ele)
  }

  def take:T={

    data.take()

  }
}
