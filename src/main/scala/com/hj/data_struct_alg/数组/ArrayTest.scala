package com.hj.data_struct_alg.数组

/**
  * @author hejin-Yu
  *
  *
  *         数组是 最基本的数据结构
  *
  *         栈、队列、链表等其他数据结构，均由数组演变而来
  *
  **/
object ArrayTest {

  def main(args: Array[String]) {

    /*-----------------
    基本的数组操作方式，涉及到数组的角标
    add
    delete
    get
    size
    -----------------------------------------------------------------*/

    /*    val ori =Array[String](null)

        val add = ori :+ "add" //当前数组，末尾追加一个元素-->新的数组

        println(add.mkString("\t"))


        val del =add.drop(0) //删掉下标为0的元素

        val  get = add(0) //得到下标为0的元素

        */

    /*------------
    关于数组的常见问题

    寻找数组中第二小的元素

    找到数组中第一个不重复出现的整数

    合并两个有序数组

    重新排列数组中的正值和负值
    ----------------------------------------------------*/

    val data = Array(1, 4, 8, 3, 9, 12)
    //val rs = getSecondMinElement(data)
    val rs =findFirstNoMoreElement(data)

    println(rs)

  }

  /**
    * 获取数组中第二小的元素
    *
    * @param data
    */
  def getSecondMinElement(data: Array[Int]) = {
    /*全局排序*/
    val sorted = data.sorted(new Ordering[Int] {
      override def compare(x: Int, y: Int): Int = {
        if (x > y) 1 else -1 //默认由小到大
      }
    })
    /*取第二个元素 或者倒数第二个元素*/
    sorted(1)
  }

  /**
    * 找到数组中第一个不重复出现的整数
    */
  /*----------------------
思路：
1.对数组中每个元素，做一个操作，形成元组，数据格式为（element,isMore）

2.
寻找元素中，isMore为true,即可
-----------------------------------------*/
  def findFirstNoMoreElement(data: Array[Int]): Int = {

    val rs = data.map(x => {
      (x, isMore(data, x))
    })
      .find(p => {
        p._2 == 1
      })

    rs match {
      case Some(i) => i._1
      case None => -1
    }
  }

  def isMore(data: Array[Int], target: Int): Int = {
    var rs = 0
    for (i <- 0 until data.size) {
      if (data(i) == target) rs += 1
    }
    rs
  }

  /*
  方法2
   */
  def findFirstNoMoreElement2(data: Array[Int]):Unit={
    /*
    基于HashBag
     */
  }


}
