package com.hj.design.Decoration_model.scene

import org.slf4j.{Logger}



/**
  * @author hejin-Yu
  * @desc
  **/
abstract class LogDecoration(log:Logger) extends Logger {

      /*
           * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
           *
           * 本接口，需要扩展已有的  Logger实现类的功能
           * info
           * eror
           * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
           */

  def extFun(msg:String):String

  override def info(s: String): Unit = {
    val msg = extFun(s)
    log.info(msg)
  }

  override def error(s: String): Unit = {
    val msg = extFun(s)
    log.error(msg)
  }

}
/*
class JsonobjectDecoration(logger: Logger) extends LogDecoration(logger){
  override def extFun(msg: String): String = {
    val obj = new ComposeBasicJsonResult().builder
    obj.toString
  }

  //省略其他默认实现
  override def getName: String = "JsonobjectDecoration"

  override def isTraceEnabled: Boolean = try {
    this.logger.isTraceEnabled
    return true
  } catch {
    case var2: NoSuchMethodError =>
      return false
  }

  override def trace(s: String): Unit = ???

  override def trace(s: String, o: Any): Unit = ???

  override def trace(s: String, o: Any, o1: Any): Unit = ???

  override def trace(s: String, objects: Any*): Unit = ???

  override def trace(s: String, throwable: Throwable): Unit = ???

  override def isTraceEnabled(marker: Marker): Boolean = ???

  override def trace(marker: Marker, s: String): Unit = ???

  override def trace(marker: Marker, s: String, o: Any): Unit = ???

  override def trace(marker: Marker, s: String, o: Any, o1: Any): Unit = ???

  override def trace(marker: Marker, s: String, objects: Any*): Unit = ???

  override def trace(marker: Marker, s: String, throwable: Throwable): Unit = ???

  override def isDebugEnabled: Boolean = ???

  override def debug(s: String): Unit = ???

  override def debug(s: String, o: Any): Unit = ???

  override def debug(s: String, o: Any, o1: Any): Unit = ???

  override def debug(s: String, objects: Any*): Unit = ???

  override def debug(s: String, throwable: Throwable): Unit = ???

  override def isDebugEnabled(marker: Marker): Boolean = ???

  override def debug(marker: Marker, s: String): Unit = ???

  override def debug(marker: Marker, s: String, o: Any): Unit = ???

  override def debug(marker: Marker, s: String, o: Any, o1: Any): Unit = ???

  override def debug(marker: Marker, s: String, objects: Any*): Unit = ???

  override def debug(marker: Marker, s: String, throwable: Throwable): Unit = ???

  override def isInfoEnabled: Boolean = ???

  override def info(s: String, o: Any): Unit = ???

  override def info(s: String, o: Any, o1: Any): Unit = ???

  override def info(s: String, objects: Any*): Unit = ???

  override def info(s: String, throwable: Throwable): Unit = ???

  override def isInfoEnabled(marker: Marker): Boolean = ???

  override def info(marker: Marker, s: String): Unit = ???

  override def info(marker: Marker, s: String, o: Any): Unit = ???

  override def info(marker: Marker, s: String, o: Any, o1: Any): Unit = ???

  override def info(marker: Marker, s: String, objects: Any*): Unit = ???

  override def info(marker: Marker, s: String, throwable: Throwable): Unit = ???

  override def isWarnEnabled: Boolean = ???

  override def warn(s: String): Unit = ???

  override def warn(s: String, o: Any): Unit = ???

  override def warn(s: String, objects: Any*): Unit = ???

  override def warn(s: String, o: Any, o1: Any): Unit = ???

  override def warn(s: String, throwable: Throwable): Unit = ???

  override def isWarnEnabled(marker: Marker): Boolean = ???

  override def warn(marker: Marker, s: String): Unit = ???

  override def warn(marker: Marker, s: String, o: Any): Unit = ???

  override def warn(marker: Marker, s: String, o: Any, o1: Any): Unit = ???

  override def warn(marker: Marker, s: String, objects: Any*): Unit = ???

  override def warn(marker: Marker, s: String, throwable: Throwable): Unit = ???

  override def isErrorEnabled: Boolean = ???

  override def error(s: String, o: Any): Unit = ???

  override def error(s: String, o: Any, o1: Any): Unit = ???

  override def error(s: String, objects: Any*): Unit = ???

  override def error(s: String, throwable: Throwable): Unit = ???

  override def isErrorEnabled(marker: Marker): Boolean = ???

  override def error(marker: Marker, s: String): Unit = ???

  override def error(marker: Marker, s: String, o: Any): Unit = ???

  override def error(marker: Marker, s: String, o: Any, o1: Any): Unit = ???

  override def error(marker: Marker, s: String, objects: Any*): Unit = ???

  override def error(marker: Marker, s: String, throwable: Throwable): Unit = ???
}


  class ComposeBasicJsonResult{

    def builder:JSONObject={
      ////一堆的运行时的信息
      //包名，类名，方法名，参数列表信息
      val obj = new JSONObject()
      //obj.put()
      //obj.put()
      //obj.put()
      //obj.put()
      obj
    }



}
*/
