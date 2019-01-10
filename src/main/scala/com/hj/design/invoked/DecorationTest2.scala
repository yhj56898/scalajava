package com.hj.design.invoked

import com.hj.design.Decoration_model.scene.JsonObjectLogDecoration
import org.slf4j.LoggerFactory

/**
  * @author hejin-Yu
  * @desc
  **/
object DecorationTest2 {

  private val log =LoggerFactory.getLogger("DecorationTest2")

  def main(args: Array[String]): Unit = {

   val jsonLog = new JsonObjectLogDecoration(log)

    jsonLog.infor("打印输出到日志中的信息")
    jsonLog.error("打印输出到日志中的信息,且使用装饰器进行了功能扩展(强化)")
  }
}
