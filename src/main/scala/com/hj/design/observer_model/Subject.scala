package com.hj.design.observer_model

import scala.collection.mutable.ListBuffer

/**
  * @author hejin-Yu
  * @desc
  **/
class Subject {

  private val observers = ListBuffer[Observer]()

  def attach(observer: Observer):Unit={
    observer.showmsg()
    observers += observer
  }

  def unAttach(observer: Observer):Unit={
    observers -= observer
  }

  def notifyMsg(msg:String):Unit={
    observers.foreach(observer=>{
      observer.update(msg)
    })
  }

}
