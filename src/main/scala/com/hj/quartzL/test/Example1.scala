package com.hj.quartzL.test

import java.util.Date
import java.util.concurrent.TimeUnit

import com.hj.quartzL.example1.HelloJob
import org.quartz._
import org.quartz.impl.StdSchedulerFactory
import org.slf4j.LoggerFactory

/**
  * @author hejin-Yu
  **/
object Example1 {
  private val log  =LoggerFactory.getLogger("Example1-quartz")

  def run:Unit={

    log.info("------- Initializing ----------------------")

    val cf = new StdSchedulerFactory
    val scheduler = cf.getScheduler

    log.info("------- Initialization Complete -----------")

    val runTime = DateBuilder.evenMinuteDate(new Date);
    log.info("------- Scheduling Job  -------------------")


    val job:JobDetail = JobBuilder.newJob(classOf[HelloJob])
      .withIdentity("job1","group-1")
      .build()


    val trigger:Trigger = TriggerBuilder.newTrigger()
      .withIdentity("trigger1","group-1")
      .startAt(runTime)
      .build()

    scheduler.scheduleJob(job,trigger)

    log.info(job.getKey + " will run at: " + runTime)

    scheduler.start

    log.info("------- Started Scheduler -----------------")

    log.info("------- Waiting 65 seconds... -------------")
    TimeUnit.SECONDS.sleep(65)


    log.info("------- Shutting Down ---------------------")
    scheduler.shutdown(true)
    log.info("------- Shutdown Complete -----------------")
  }

  def main(args: Array[String]) {
    Example1.run
  }

}
