package com.hj.quartzL.e3

import java.util.Date

import org.quartz.{Job, JobDetail, JobExecutionContext}

/**
  * @author hejin-Yu
  * @desc
  **/
class HelloQuartz  extends Job{
  override def execute(context: JobExecutionContext): Unit = {
   val jobDetail:JobDetail = context.getJobDetail

    val name =jobDetail.getJobDataMap.getString("name")
    println("say hello to " + name + " at " + new Date())
  }
}
