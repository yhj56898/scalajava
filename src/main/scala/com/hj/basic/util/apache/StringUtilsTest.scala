package com.hj.basic.util.apache

import org.apache.commons.collections.bidimap.TreeBidiMap
import org.apache.commons.lang3.{RandomStringUtils, StringUtils}

/**
  * @author hejin-Yu
  *
  *
  * apache.common.StringUtils
  **/
object StringUtilsTest {

  def main(args: Array[String]) {

    /*------------------------------------判空----------------------------------------------*/

    val str = ""
    val str2 = null
    val str3 = " "
    val fg1 = StringUtils.isBlank(str) //true
    val fg2 = StringUtils.isBlank(str2) //true
    val fg3 = StringUtils.isBlank(str3) //true

    /*-------------上述结果，应当全是true--------------------------------------------------------*/
    //    println(s"${fg1}\t ${fg2}\t ${fg3}")

    val str4 = "123"
    val str5 = "12 3"
    val str6 = "123QD#"

    /*----------------------基于apache.common.StringUtils 判断输入，是否是数字---------------*/

    val isNumeric: Boolean = StringUtils.isNumeric(str5) //false


    /*----------------基于apche.common.RandomStringUtils,产生随机数--------------------------*/

    val allNo = RandomStringUtils.randomNumeric(8) //产生给定长度的全数字
    val zm_no = RandomStringUtils.randomAlphanumeric(8) //字母+ 数字
    val zm_no_Special_char = RandomStringUtils.randomAscii(32) //字母+数字+特殊字符，如# %等


    //    println(allNo)
    //    println(zm_no)
    //    println(zm_no_Special_char)


    /*----------------------双端 Map,基于apache.common.collection.TreeBidiMap -------------------------*/

    val bidiMap = new TreeBidiMap()

    bidiMap.put("k1", "v1")

    val isContainK1 = if (bidiMap.containsKey("k1")) true else false

    /*由 key --> v*/

    val getValByKey = bidiMap.get("k1")
    /*由 v --> key*/

    val getKeyByVal = bidiMap.getKey("v1")

    println(getValByKey)
    println(getKeyByVal)

  }

}
