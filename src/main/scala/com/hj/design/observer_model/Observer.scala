package com.hj.design.observer_model

trait Observer {

  def showmsg()
  def update(msg:String)
}

class FirstObserver extends Observer{
  override def showmsg(): Unit = {
    println("first Object is invoked showmsg!")
  }

  override def update(msg: String): Unit = {
    println("first Object invoked  update: "+msg)
  }
}

class SecondObserver extends Observer{
  override def showmsg(): Unit = println("second Object is invoked showmsg!")

  override def update(msg: String): Unit = println("second Object invoked  update: "+msg)
}

class ThirdObserver extends Observer{
  override def showmsg(): Unit = println("third Object is invoked showmsg!")

  override def update(msg: String): Unit = println("third Object invoked  update: "+msg)
}