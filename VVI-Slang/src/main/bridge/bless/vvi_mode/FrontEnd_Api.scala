// #Sireum

package bless.vvi_mode

import org.sireum._
import art._
import bless._

@sig trait FrontEnd_Api {
  def id: Art.BridgeId
  def sense_Id : Art.PortId
  def pace_Id : Art.PortId

  // Logika spec var representing port state for outgoing event port
  @spec var sense: Option[art.Empty] = $

  def put_sense() : Unit = {
    Contract(
      Modifies(sense),
      Ensures(
        sense == Some(Empty())
      )
    )
    Spec {
      sense = Some(Empty())
    }

    Art.putValue(sense_Id, art.Empty())
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

@datatype class FrontEnd_Initialization_Api (
  val id: Art.BridgeId,
  val sense_Id : Art.PortId,
  val pace_Id : Art.PortId) extends FrontEnd_Api

@datatype class FrontEnd_Operational_Api (
  val id: Art.BridgeId,
  val sense_Id : Art.PortId,
  val pace_Id : Art.PortId) extends FrontEnd_Api {

  // Logika spec var representing port state for incoming event port
  @spec var pace: Option[art.Empty] = $

  def get_pace() : Option[art.Empty] = {
    Contract(
      Ensures(
        Res == pace
      )
    )
    val value : Option[art.Empty] = Art.getValue(pace_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port pace.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }
}
