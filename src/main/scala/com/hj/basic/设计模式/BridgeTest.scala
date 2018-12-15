package com.hj.basic.设计模式
/**
  * @author hejin-Yu
  *
  *         桥接模式
  *         --> 需要显示注入一个对象
  *         基于这个对象做些什么
  **/
object BridgeTest {

  def main(args: Array[String]) {

    val pen: Pen = new Pen("铅笔")
    val pen2: Pen = new Pen("红笔")


    val teather = new ExamPaper(pen2)

    val grandPa = new NewsPaper(pen)

    /*---------老师，使用红笔，批改作业--------------------------------------------------------*/
    teather.doSomthing
    /*---------爷爷， 使用铅笔 在报纸上 做备注-------------------------------------*/
    grandPa.doSomthing
  }

}

class Pen(val name: String)

abstract class Paper(pen: Pen)(paperName: String) {

  /*------------------------注入一个Pen
  基于这个pen,做些什么
  ------------------------------------------------*/
  def doSomthing: Unit = {
    println(s"使用${pen.name}在${paperName}上写了什么")
  }
}

class ExamPaper(pen: Pen) extends Paper(pen)("考卷")

class NewsPaper(pen: Pen) extends Paper(pen)("报纸")


