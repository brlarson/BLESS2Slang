package bless.util

import org.sireum._

object BlessConversion_Ext {
  def floatSecondToS64millisecond(s : F64) : S64 = {
    val ms = s * 1000.0
    return S64(ms.native.toInt) 
    }

  def s64millisecondToFloatSecond(ms : S64) : F64 = {
    return ms.toString.toDouble / 1000.0
    }

}
