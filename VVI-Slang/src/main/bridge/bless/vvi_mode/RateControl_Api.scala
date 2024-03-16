// #Sireum

package bless.vvi_mode

import org.sireum._
import art._
import bless._

@sig trait RateControl_Api {
  def id: Art.BridgeId
  def lrl_Id : Art.PortId
  def vrp_Id : Art.PortId

  // Logika spec var representing port state for outgoing data port
  @spec var lrl: vvi_mode.CardiacDuration = $

  def put_lrl(value : vvi_mode.CardiacDuration) : Unit = {
    Contract(
      Modifies(lrl),
      Ensures(
        lrl == value
      )
    )
    Spec {
      lrl = value
    }

    Art.putValue(lrl_Id, vvi_mode.CardiacDuration_Payload(value))
  }

  // Logika spec var representing port state for outgoing data port
  @spec var vrp: vvi_mode.CardiacDuration = $

  def put_vrp(value : vvi_mode.CardiacDuration) : Unit = {
    Contract(
      Modifies(vrp),
      Ensures(
        vrp == value
      )
    )
    Spec {
      vrp = value
    }

    Art.putValue(vrp_Id, vvi_mode.CardiacDuration_Payload(value))
  }

  def logInfo(msg: String): Unit = {
    Art.logInfo(id, msg)
  }

  def logDebug(msg: String): Unit = {
    Art.logDebug(id, msg)
  }

  def logError(msg: String): Unit = {
    Art.logError(id, msg)
  }
}

@datatype class RateControl_Initialization_Api (
  val id: Art.BridgeId,
  val lrl_Id : Art.PortId,
  val vrp_Id : Art.PortId) extends RateControl_Api

@datatype class RateControl_Operational_Api (
  val id: Art.BridgeId,
  val lrl_Id : Art.PortId,
  val vrp_Id : Art.PortId) extends RateControl_Api {

}
