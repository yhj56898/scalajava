package com.hj.design.Composite_model

import scala.collection.mutable.ListBuffer

/**
  * @author hejin-Yu
  * @desc
  * 意图：将对象组合成树形结构以表示"部分-整体"的层次结构。组合模式使得用户对单个对象和组合对象的使用具有一致性。
  *
  * 何时使用：
  * 1、您想表示对象的部分-整体层次结构（树形结构）。
  * 2、您希望用户忽略组合对象与单个对象的不同，用户将统一地使用组合结构中的所有对象。
  *
  * 使用场景：部分、整体场景，如树形菜单，文件、文件夹的管理。
  * 注意事项：定义时为具体类。
  **/
class Employee(val name:String,val dept:String,val salary: Double) {

  private var subordinates: ListBuffer[Employee] = null

  def init:Unit={

    if(null==subordinates){
      synchronized{
        if(null==subordinates){
          subordinates =ListBuffer[Employee]()
        }

      }
    }
  }

  def  add(employee: Employee):Unit={
    init
    subordinates += employee
  }
  def remove(employee: Employee):Unit={
    if(null ==subordinates || subordinates.isEmpty){
     return
    }
    subordinates -= employee
  }

  def getSubordinates=subordinates.toList

  override def toString: String = {
    s"[name=${name},dept=${dept},salry=${salary}]"
  }

}
