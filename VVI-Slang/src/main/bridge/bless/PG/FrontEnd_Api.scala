// #Sireum

package bless.PG

import art._
import org.sireum._

@sig trait FrontEnd_Api {
  def id: Art.BridgeId
  def a_Id : Art.PortId
  def v_Id : Art.PortId
  def ap_Id : Art.PortId
  def vp_Id : Art.PortId

  // Logika spec var representing port state for outgoing event port
  @spec var a: Option[art.Empty] = $

  def put_a() : Unit = {
    Contract(
      Modifies(a),
      Ensures(
        a == Some(Empty())
      )
    )
    Spec {
      a = Some(Empty())
    }

    Art.putValue(a_Id, art.Empty())
  }

  // Logika spec var representing port state for outgoing event port
  @spec var v: Option[art.Empty] = $

  def put_v() : Unit = {
    Contract(
      Modifies(v),
      Ensures(
        v == Some(Empty())
      )
    )
    Spec {
      v = Some(Empty())
    }

    Art.putValue(v_Id, art.Empty())
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
  val a_Id : Art.PortId,
  val v_Id : Art.PortId,
  val ap_Id : Art.PortId,
  val vp_Id : Art.PortId) extends FrontEnd_Api

@datatype class FrontEnd_Operational_Api (
  val id: Art.BridgeId,
  val a_Id : Art.PortId,
  val v_Id : Art.PortId,
  val ap_Id : Art.PortId,
  val vp_Id : Art.PortId) extends FrontEnd_Api {

  // Logika spec var representing port state for incoming event port
  @spec var ap: Option[art.Empty] = $

  def get_ap() : Option[art.Empty] = {
    Contract(
      Ensures(
        Res == ap
      )
    )
    val value : Option[art.Empty] = Art.getValue(ap_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port ap.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  // Logika spec var representing port state for incoming event port
  @spec var vp: Option[art.Empty] = $

  def get_vp() : Option[art.Empty] = {
    Contract(
      Ensures(
        Res == vp
      )
    )
    val value : Option[art.Empty] = Art.getValue(vp_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port vp.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }
}
