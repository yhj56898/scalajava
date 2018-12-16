package com.hj.basic.设计模式

/**
  * @author hejin-Yu
  *
  *         适配模式，
  *         寻找目标对象
  **/
object Adaptertest {

  def main(args: Array[String]) {

    /*-------------------------------给定一个视屏文件---------------------------------------------*/
    val file="a.mp4"

    invoke.palyVideo(file)

  }

}

trait Mp4 {
  def palyerMp4(file: String): Unit
}

trait AVI {
  def palyerAVI(file: String): Unit
}
trait RMVB {
  def palyerRMVB(file: String): Unit
}

object VideoPalyer extends Mp4 with AVI with RMVB{
  override def palyerMp4(file: String): Unit = {
    println(s"使用MP4播放器，播放了${file}")
  }

  override def palyerAVI(file: String): Unit = {
    println(s"使用AVI播放器，播放了${file}")
  }

  override def palyerRMVB(file: String): Unit = {
    println(s"使用RMVB播放器，播放了${file}")
  }
}
object invoke{

  def palyVideo(file:String):Unit={

      val inFile=file.toLowerCase
      if(inFile.endsWith("mp4")){
        VideoPalyer.palyerMp4(file)
      }else if(inFile.endsWith("avi")){
        VideoPalyer.palyerAVI(file)
      }else{
        VideoPalyer.palyerRMVB(file)
      }

  }
}

