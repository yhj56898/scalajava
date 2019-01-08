package com.hj.quartzL.e3

import org.quartz.{JobBuilder, TriggerBuilder}
import org.quartz.impl.StdSchedulerFactory
import org.quartz.SimpleScheduleBuilder.simpleSchedule


/**
  * @author hejin-Yu
  *
  * https://www.cnblogs.com/drift-ice/p/3817269.html
  *
  *如果Scheduler直接使用Job，就会存在对同一个Job实例并发访问的问题。而JobDetail & Job 方式，
  * sheduler每次执行，都会根据JobDetail创建一个新的Job实例，这样就可以规避并发访问的问题。
  **/
object QuartzTest {

  def main(args: Array[String]) {

    val scheduler = StdSchedulerFactory.getDefaultScheduler

    val trigger = TriggerBuilder.newTrigger()
      .withIdentity("trigger1", "group1")//
      .startNow()//一旦加入scheduler，立即生效
      .withSchedule(simpleSchedule() //使用SimpleTrigger
      .withIntervalInSeconds(1) //每隔一秒执行一次
      .repeatForever()) //一直执行，奔腾到老不停歇
      .build();

    val job = JobBuilder.newJob(classOf[HelloQuartz])
      .withIdentity("job1", "group1") //定义name/group
      .usingJobData("name","quartz") //定义属性
      .build()


    //加入这个调度
    scheduler.scheduleJob(job, trigger)


    //启动调度器
    scheduler.start

    //运行一段时间后关闭
    Thread.sleep(10000)
    scheduler.shutdown(true)

  }

}
