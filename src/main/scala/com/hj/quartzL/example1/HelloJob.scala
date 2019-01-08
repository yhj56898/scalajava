package com.hj.quartzL.example1

import java.util.Date

import org.quartz.{Job, JobExecutionContext}
import org.slf4j.LoggerFactory

/**
  * @author hejin-Yu
  * @desc
  *
  *      官方例子1
  *      经过编译jar后，可以查看到源码
  **/
class HelloJob extends Job{

  private val log =LoggerFactory.getLogger("HelloJob")

  override def execute(context: JobExecutionContext): Unit = {

    log.info("hello world !---"+new Date)
  }
}
