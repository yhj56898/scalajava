package com.hj.data_struct_alg.arrays

/**
  * @author hejin-Yu
  *
  *
  *  test by myself!
  **/
object TestArray {

  def main(args: Array[String]): Unit ={

    /**
      * build a new Array instance
      */
    val array  = new Arrays[Int]() //default capacity is 10

        /*
             * ~~~~~~~~~~~~~~~~~~~~~~
             * fill elements to the array
             * ~~~~~~~~~~~~~~~~~~~~~~
             */

    for(i<- 0 until 5){
      array.addFirst(i)
    }

    array.addLast(10)
    array.addLast(11)


    val V10=array.popLast()
   // println(s"the last element is 10?${V10==10}")

    println(array)
  }

}
