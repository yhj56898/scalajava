package com.hj.basic.设计模式

import scala.collection.mutable.ListBuffer

/**
  * @author hejin-Yu
  *
  *
  **/
object ObserverTest {

  def main(args: Array[String]) {

    val bolg1 =new Blog("wahaha")
    val bolg2 =new Blog("hahawa")
    val bolg3 =new Blog("Doug Cutting")
    val bolg4 =new Blog("Martin Odersky")

    val u1 =new User("河金余",bolg3,bolg4)
    val u2 =new User("隔壁老王",bolg1)
    val u3 =new User("隔壁老王的隔壁老王",bolg2,bolg1)


    GoldPerspective.focusAt(u1).focusAt(u2).focusAt(u3)

    /*----------------博主们，博客有更新了--------------------------------*/
    GoldPerspective.notifies2User(bolg1,bolg3,bolg4)




  }

}

/*用户，及其关注的bolg*/
class User(val name:String,val blogs:Blog*)

class Blog(
          val owner:String
          )

object GoldPerspective {

  private val users  =ListBuffer[User]()

  def focusAt(user: User):this.type ={
    println(s"观察到用户【${user.name}】有个关注事件")
    users += user
    this
  }

  def leaveOut(user: User):Unit={
    println(s"观察到用户【${user.name}】有个取消关注事件")
    users -= user
  }

  def notifies2User(blog: Blog*):Unit={

    for (elem <- blog) {
      users.foreach(u=>{
        if(u.blogs.contains(elem)){
          /*用户关注的*/
          println(s"用户【${u.name}】关注的博主【${elem.owner}】,有更新啦!~~~~")
        }
      })
    }

  }

}
