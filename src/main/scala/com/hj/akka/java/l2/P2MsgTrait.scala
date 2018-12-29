package com.hj.akka.java.l2

trait P2MsgTrait extends Serializable

/*--------------------
简单定义，一个Master 、多个Worker间的通信协议，解决心跳（报活）问题
------------------------------------------------*/


/*--------------------

worker 启动之时，发送注册信息，交由 Master处理-->  master处理worker注册信息完毕 ---
-------------------------->返回一个注册成功信息，交由worker处理


worker注册成功后，需要不断 ( 定期 )向 Master发送心跳信息，交由Master处理

master,需要不断 （ 定期 ）监测向自己报备的所有 worker的心跳是否超时

--------------------------------------------------------------*/

case class WorkInfo(id:String){

  var lastCheckTime:Long = 0

}

case class RegisterWorkInfo(id:String) extends P2MsgTrait
case object RegistedSuccess extends P2MsgTrait

case object SendHeartbeat extends P2MsgTrait

case class ProceedHeartBeat(id:String) extends P2MsgTrait
case object CheckTimeOut extends P2MsgTrait
