// UNOBridge.scala
package UNO

// UNOBridge calls UNOBoard

import art.Art
import org.sireum._
//import bless.UNO.FirmataUtil.PinMode
import bless.vvi_mode.{FrontEnd_Initialization_Api, FrontEnd_Operational_Api}

object UNOBridge {

  def init(api: FrontEnd_Initialization_Api): Unit = {
    UNOBoard.init()
  }

  def putVS(api: FrontEnd_Operational_Api): Unit = {
    api.logDebug("putVS")
    api.put_sense()
    Art.sendOutput(IS(api.sense_Id), IS())
  }

  def putVP(api: FrontEnd_Operational_Api): Unit = {
    api.logDebug("putVP")
    UNOBoard.vpOut()
  }

  def stop(): Unit = {
    UNOBoard.stop()
  }

}
