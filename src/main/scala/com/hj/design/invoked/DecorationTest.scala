package com.hj.design.invoked

import com.hj.design.Decoration_model.pack3._

/**
  * @author hejin-Yu
  *
  *
  **/
object DecorationTest {

  def main(args: Array[String]) {

    //一个英雄

    val bd = new BlindMonk();

    val skillE: Hero = new Skill_E(bd)
    val skillW: Hero = new Skill_W(skillE)
    val skillQ: Hero = new Skill_Q(skillW)


    skillQ.learnSkill()
  }

}
