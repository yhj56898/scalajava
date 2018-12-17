package com.hj.basic.设计模式

/**
  * @author hejin-Yu
  *
  * 责任链模式
  *
  **/
object RepositoryTest {

  def main(args: Array[String]) {
/*-----------------------define a job that waiting for doing-------------------------------*/
    val something="请婚假1个月"
    val dataLev:Int =3

    println(s"张三走了一个OA申请，原因是【${something}】")
    /**
      * 往上执行
      * down --> top
      */
    InvokeRepository.hand2Top(something,dataLev)

    /**
      * 往下执行
      */
    //InvokeRepository.hand2Down(something,dataLev)

  }

}

/*--------------------定义一个领导----------------------------------*/
abstract class Leader(val CurName:String){
  var In_leader:Leader
  /*--------------------业务级别------------------*/
  def canHandler(busiLev:Int):Boolean

  def doJob(something:String):Unit

  def Handler(busiLev:Int,something:String):Unit={
    if(canHandler(busiLev)) {
      doJob(something)
    } else{
      println(s"【${CurName}】表示:超出了自己的能力范围，交给自己的上级【${In_leader.CurName}】进行处理")
      In_leader.Handler(busiLev,something)
    }
  }
}
/*总经理 0~3*/
class ZJL(name:String,leader: Leader) extends Leader(name){

  override var In_leader: Leader = leader

  override def canHandler(busiLev: Int): Boolean = {
    if(busiLev<=3) true else false
  }

  override def doJob(something:String): Unit = {
    println(s"总经理【${name}】,给【${something}】做了批复")
  }

}

/*部门经理 4~ 6*/
class JL(name:String,leader: Leader) extends Leader(name){
  override var In_leader: Leader = leader

  override def canHandler(busiLev: Int): Boolean = {
    if(busiLev<=6 && busiLev>3) true else false
  }
  override def doJob(something:String): Unit = {
    println(s"经理=${name},给${something}做了批复")
  }
}

/*部门组长 7~*/
class Zz(name:String,leader: Leader) extends Leader(name){

  override var In_leader: Leader = leader

  override def canHandler(busiLev: Int): Boolean = {
    if(busiLev >=7) true else false
  }

  override def doJob(something:String): Unit = {
    println(s"组长=${name},给${something}做了批复")
  }
}

/*------------------暴露出的外部实例-------------------------------------------*/
object InvokeRepository{

  private val _zjl:ZJL =new ZJL("TeLunPu",null)
  private val _jl:JL =new JL("侯赛因",_zjl)
  private val _zz:Zz =new Zz("80后的白发书记",_jl)

  def hand2Top(something:String,dataLev:Int):Unit={
    _zz.Handler(dataLev,something)
  }

  def hand2Down(something:String,dataLev:Int):Unit={
    _zjl.Handler(dataLev,something)
  }

}
