package com.hj.akka.java.l4


/*---------------------------
定义框架的 通信协议

---基于事件驱动
------------------------------------------*/
trait TaskEvent

/*简单起见，协议内容，就是任务名称*/
case class TaskSubmit(name:String) extends TaskEvent

case class TaskSuccedd(name:String) extends TaskEvent

case class TaskFailed(e:Throwable) extends TaskEvent