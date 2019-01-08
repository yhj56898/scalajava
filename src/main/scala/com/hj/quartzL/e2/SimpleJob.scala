package com.hj.quartzL.e2

import java.util.Date

import com.hj.quartzL.JobTrait
import org.quartz.{Job, JobDetail, JobExecutionContext, JobKey}
import org.slf4j.Logger

/**
  * @author hejin-Yu
  * @desc
  **/
class SimpleJob extends Job with JobTrait{

  private val _log = getLog("example2-quartz")

  override def execute(context: JobExecutionContext): Unit = {

    val jobDatail:JobDetail =context.getJobDetail

    val jobKey:JobKey = jobDatail.getKey

    _log.info("SimpleJob says: " + jobKey + " executing at " + new Date)
  }
}
