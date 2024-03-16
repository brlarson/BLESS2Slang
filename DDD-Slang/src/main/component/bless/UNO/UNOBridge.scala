// UNOBridge.scala
package bless.UNO

import art.Art
import bless.PG.{FrontEnd_Initialization_Api, FrontEnd_Operational_Api}
import org.sireum.{IS, _}
//import bless.UNO.FirmataUtil.PinMode

object UNOBridge {

  def init(api: FrontEnd_Initialization_Api): Unit = {
    UNOBoard.init()
  }

  def putVS(api: FrontEnd_Operational_Api): Unit = {
    api.logDebug("putVS")
    api.put_v()
    Art.sendOutput(IS(api.v_Id), IS())
  }

  def putVP(api: FrontEnd_Operational_Api): Unit = {
    api.logDebug("putVP")
    UNOBoard.vpOut()
  }

  def putAS(api: FrontEnd_Operational_Api): Unit = {
    api.logDebug("putAS")
    api.put_a()
    Art.sendOutput(IS(api.a_Id), IS())
  }

  def putAP(api: FrontEnd_Operational_Api): Unit = {
    api.logDebug("putAP")
    UNOBoard.apOut()
  }

  def stop(): Unit = {
    UNOBoard.stop()
  }

}
