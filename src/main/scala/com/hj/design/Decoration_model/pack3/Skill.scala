package com.hj.design.Decoration_model.pack3

abstract class Skill(hearo: Hero) extends Hero {

  override def name: String = hearo.name

  override def learnSkill(): Unit = {

    val skillName = getSkillName
    println(name+s"学习了技能【${skillName}】")
    hearo.learnSkill()
  }

  def getSkillName:String
}

class Skill_Q(hearo: Hero) extends Skill(hearo) {
  override def getSkillName: String = "天音波/回音击"

}

class Skill_W(hearo: Hero) extends Skill(hearo) {
  override def getSkillName  = {
"金钟罩/铁布衫"

  }
}

class Skill_E(hearo: Hero) extends Skill(hearo) {
  override def getSkillName: String = "天雷破/摧筋断骨"
}
