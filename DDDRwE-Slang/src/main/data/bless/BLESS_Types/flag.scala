// #Sireum 
   // generated by BLESS v3.2.1 at Tue Nov 14 03:54:35 CST 2023 from ["BLESS_Types", "flag"]

package bless.BLESS_Types

import org.sireum._
import bless._
import org.sireum.S64._
import org.sireum.F64._
import art.Art

// This file will not be overwritten so is safe to edit

// This is a type skeleton as HAMR doesn't know how to translate BLESS_Types::flag

object flag {
  def example(): BLESS_Types.flag =
    { return BLESS_Types.flag(F) }
}

@datatype class flag(
  value : B) {
}

object flag_Payload {
  def example(): flag_Payload = {
    return flag_Payload(BLESS_Types.flag.example())
  }
}

@datatype class flag_Payload(value: BLESS_Types.flag) extends art.DataContent
