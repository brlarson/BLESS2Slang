// #Sireum

package bless.Missing

import org.sireum._
import bless._

// This file will not be overwritten so is safe to edit

// This is a type skeleton as HAMR doesn't know how to translate Missing::MISSING_AADL_TYPE

object MISSING_AADL_TYPE {
  def example(): Missing.MISSING_AADL_TYPE = {
    return Missing.MISSING_AADL_TYPE()
  }
}

@datatype class MISSING_AADL_TYPE()

object MISSING_AADL_TYPE_Payload {
  def example(): MISSING_AADL_TYPE_Payload = {
    return MISSING_AADL_TYPE_Payload(Missing.MISSING_AADL_TYPE.example())
  }
}

@datatype class MISSING_AADL_TYPE_Payload(value: Missing.MISSING_AADL_TYPE) extends art.DataContent
