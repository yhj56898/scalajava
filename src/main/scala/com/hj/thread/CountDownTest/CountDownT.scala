package com.hj.thread.CountDownTest

import java.util.concurrent.{CountDownLatch, Executors, TimeUnit}

import scala.collection.mutable.ListBuffer

/**
  * @author hejin-Yu
  *
  *
  *CountDown
  *
  *   基于前置任务，而进行阻塞
  *
  **/
object CountDownT {

  def main(args: Array[String]) {

    /*-----------
    模拟一个 集群服务的启动过程
    --------------------------------------------------------*/

    /*-------------
    并发执行，前置任务
    -----------------------------------------------*/
    val service =ListBuffer[Task]()
    val latch = new CountDownLatch(3)

    val es = Executors.newCachedThreadPool()

    service += new NetWorkService(latch)
    service += new DBService(latch)
    service += new UserService(latch)


    service.foreach(task=>{
      es.submit(task)
    })

    /*----------------------------进入阻塞点
    等待前置任务，执行完毕，方可执行阻塞点后的代码
    -------------------------------------------*/
    latch.await()


    println("完成了以上前置任务后，主服务开始 对外提供服务")


    es.shutdown()

  }

}

abstract class Task(latch:CountDownLatch) extends Runnable{

  def start:Unit

  override def run(): Unit = {
    /*多个任务，运行并发执行*/
    try{
      start
    }catch{
        case e:Exception=> throw new RuntimeException(e)
    }finally{
      latch.countDown()
    }
  }
}

class NetWorkService(latch:CountDownLatch) extends  Task(latch){
  override def start: Unit = {
    println("进入网络连接 通达性 校验与连接")
    TimeUnit.SECONDS.sleep(2)
    println("网络连接，校验通过、连接已成功")
  }
}

class DBService(latch:CountDownLatch) extends Task(latch){
  override def start: Unit = {
    println("进入数据库通达性 与连接")
    TimeUnit.SECONDS.sleep(3)
    println("数据库，校验通过、连接已成功")
  }
}
class UserService(latch:CountDownLatch) extends Task(latch){
  override def start: Unit = {
    println("加载用户信息入缓存")
    TimeUnit.SECONDS.sleep(1)
    println("用户信息已成功加入缓存")
  }
}
