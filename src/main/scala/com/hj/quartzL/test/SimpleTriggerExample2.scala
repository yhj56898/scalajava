package com.hj.quartzL.test

import java.util.Date

import com.hj.quartzL.JobTrait
import com.hj.quartzL.e2.SimpleJob
import org.quartz._
import org.quartz.impl.StdSchedulerFactory

/**
  * @author hejin-Yu
  *
  *
  **/
object SimpleTriggerExample2 extends JobTrait {

  private val log = getLog("SimpleTriggerExample2")

  def start: Unit = {
    log.info("------- Initializing -------------------")

    val cf: StdSchedulerFactory = new StdSchedulerFactory()

    val schduler: Scheduler = cf.getScheduler
    log.info("------- Initialization Complete --------")

    log.info("------- Scheduling Jobs ----------------")

    val startTime:Date = DateBuilder.nextGivenSecondDate(null,15)

    val jobDetail:JobDetail = JobBuilder.newJob(classOf[SimpleJob])
      .withIdentity("job2","group1").build()

    val trigger =TriggerBuilder.newTrigger()
      .withIdentity("trigger2","group1")
      .startAt(startTime)
        .build().asInstanceOf[SimpleTrigger]


    val ft:Date =schduler.scheduleJob(jobDetail,trigger)

    log.info(jobDetail.getKey + " will run at: " + ft + " and repeat: " + trigger.getRepeatCount + " times, every " + trigger.getRepeatInterval / 1000L + " seconds")

    schduler.start()

   val job_manually = JobBuilder.newJob(classOf[SimpleJob])
     .withIdentity("job8", "group1")
     .storeDurably()
     .build

    schduler.addJob(job_manually,true)

    log.info("'Manually' triggering job8...")
    schduler.triggerJob(JobKey.jobKey("job8", "group1"))


    log.info("------- Rescheduling... --------------------")
    val trigger7 = TriggerBuilder.newTrigger.withIdentity("trigger7", "group1")
      .startAt(startTime)
      .withSchedule(
        SimpleScheduleBuilder.simpleSchedule
        .withIntervalInMinutes(5)
          .withRepeatCount(20)
      ).build.asInstanceOf[SimpleTrigger]

    val ft7 = schduler.rescheduleJob(trigger7.getKey, trigger7)
    log.info("job7 rescheduled to run at: " + ft)


    Thread.sleep(30000L)

    schduler.shutdown(true)
  }

  def main(args: Array[String]) {
    SimpleTriggerExample2.start
  }

}
