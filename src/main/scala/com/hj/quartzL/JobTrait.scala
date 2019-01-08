package com.hj.quartzL

import org.slf4j.{Logger, LoggerFactory}

trait JobTrait {

  def getLog(clsName:String):Logger=LoggerFactory.getLogger(clsName)

}
