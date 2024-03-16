// #Sireum

package bless.vvi_mode

import org.sireum._
import bless._

// This file will not be overwritten so is safe to edit
object FrontEnd_fe {

  def initialise(api: FrontEnd_Initialization_Api): Unit = {
//this is inserted:
    FrontEndNative.initialise(api)
    // example api usage

//    api.logInfo("Example info logging")
//    api.logDebug("Example debug logging")
//    api.logError("Example error logging")
//
//    api.put_sense()
  }

  def handle_pace(api: FrontEnd_Operational_Api): Unit = {
//this is inserted
    FrontEndNative.handle_pace(api)
//    api.logInfo("example handle_pace implementation")
//    api.logInfo("  received event")
//    // example api usage
//
//    val apiUsage_pace: Option[art.Empty] = api.get_pace()
    api.logInfo(s"Received on event port pace: ${apiUsage_pace}")
  }

  def activate(api: FrontEnd_Operational_Api): Unit = { }

  def deactivate(api: FrontEnd_Operational_Api): Unit = { }

  def finalise(api: FrontEnd_Operational_Api): Unit = { }

  def recover(api: FrontEnd_Operational_Api): Unit = { }
}

@ext object FrontEndNative {
  def initialise(api: FrontEnd_Initialization_Api): Unit = $
  def handle_pace(api: FrontEnd_Operational_Api): Unit = $
}
