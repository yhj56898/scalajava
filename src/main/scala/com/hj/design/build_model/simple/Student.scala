package com.hj.design.build_model.simple

/**
  * @author hejin-Yu
  * @desc
  **/
class Student(var name:String,var age:Int,var sex:String){

  def this()={
    this("defalut_name",18,"male")
  }

  override def toString: String = {
    s"[name=${name},age=${age},sex=${sex}]"
  }
}

    /*
         * ~~~~~~~~~~~~~~~~~~~~~~
         * 不想使用new,
         * 想通过 建造者模式【工厂模式，更多强调 new;建造者模式，强调 创建对象时的细节】
         * 简化对象创建过程
         * ~~~~~~~~~~~~~~~~~~~~~~
         */


class StudentBuilder{

  private val student:Student=new Student

  def name(name:String):this.type ={
    student.name=name
    this
  }

  def age(age:Int):this.type ={
    student.age=age
    this
  }

  def sex(sex:String):this.type ={
    this.student.sex=sex
    this
  }

  def builder:Student=student

}