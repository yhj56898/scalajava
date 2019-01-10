package com.hj.design.invoked

import com.hj.design.build_model.simple.{Student, StudentBuilder}

/**
  * @author hejin-Yu
  *
  *
  **/
object BuilderTest2 {

  def main(args: Array[String]) {

    val  student:Student = new StudentBuilder()
      .age(23)
      .name("张思思")
      .builder

    println(student)

  }

}
