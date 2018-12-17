package com.hj.basic.设计模式

import scala.collection.mutable.ListBuffer

/**
  * @author hejin-Yu
  *
  *命令行模式
  *   基于一个对象，设置一堆的命令
  *
  **/
object CommandTest {

  def main(args: Array[String]) {

    val student:Student =new Student("sasaki isao")

    Invoke.putComd(new TeacherWang(student))
      .putComd(new TeacherLi(student))

      .excute

  }

}

class Student(val name:String)

trait Command {

  def doJob
}

/*-------------李老师 会布置 教室大扫除的任务--------------------------------------------------*/
class TeacherLi(student: Student) extends Command{
  override def doJob: Unit = {
    println(s"Li老师给${student.name}布置了做教室值日的任务")
  }
}
/*-------------网老师 会布置  做家庭作业的 任务--------------------------------------------------*/

class TeacherWang(student: Student) extends Command{
  override def doJob: Unit = {
    println(s"王老师给${student.name}布置了 第六章的课外数学题任务")
  }
}
/*--------------------.......类似的，一堆的其他任务------------------------------------------*/


/*对外暴露的*/
object Invoke{
  private val cmds=ListBuffer[Command]()

  def putComd(cmd:Command):this.type ={
    cmds +=  cmd
    this
  }

  def excute:Unit={
    cmds.foreach(cmd=>{
      cmd.doJob
    })
  }

}
