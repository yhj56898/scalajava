package com.hj.design.invoked

import com.hj.design.Singleton_model.SingletonObj

/**
  * @author hejin-Yu
  * @desc
  **/
object SingletonTest {

  def main(args: Array[String]): Unit = {

        /*
             * ~~~~~~~~~~~~~~~~~~~~~~
             * 创建单例对象
             * ~~~~~~~~~~~~~~~~~~~~~~
             */

    val obj = SingletonObj.getInstance();

    obj.showMsg("hello world")
  }

}
