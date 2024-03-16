// #Sireum

package bless.ddd_mode

import org.sireum._
import art._
import bless._

@sig trait DDD_i_Api {
  def id: Art.BridgeId
  def a_Id : Art.PortId
  def v_Id : Art.PortId
  def ap_Id : Art.PortId
  def vp_Id : Art.PortId
  def as_Id : Art.PortId
  def vs_Id : Art.PortId

  // Logika spec var representing port state for outgoing event port
  @spec var ap: Option[art.Empty] = $

  def put_ap() : Unit = {
    Contract(
      Modifies(ap),
      Ensures(
        ap == Some(Empty())
      )
    )
    Spec {
      ap = Some(Empty())
    }

    Art.putValue(ap_Id, art.Empty())
  }

  // Logika spec var representing port state for outgoing event port
  @spec var vp: Option[art.Empty] = $

  def put_vp() : Unit = {
    Contract(
      Modifies(vp),
      Ensures(
        vp == Some(Empty())
      )
    )
    Spec {
      vp = Some(Empty())
    }

    Art.putValue(vp_Id, art.Empty())
  }

  // Logika spec var representing port state for outgoing event port
  @spec var as: Option[art.Empty] = $

  def put_as() : Unit = {
    Contract(
      Modifies(as),
      Ensures(
        as == Some(Empty())
      )
    )
    Spec {
      as = Some(Empty())
    }

    Art.putValue(as_Id, art.Empty())
  }

  // Logika spec var representing port state for outgoing event port
  @spec var vs: Option[art.Empty] = $

  def put_vs() : Unit = {
    Contract(
      Modifies(vs),
      Ensures(
        vs == Some(Empty())
      )
    )
    Spec {
      vs = Some(Empty())
    }

    Art.putValue(vs_Id, art.Empty())
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

@datatype class DDD_i_Initialization_Api (
  val id: Art.BridgeId,
  val a_Id : Art.PortId,
  val v_Id : Art.PortId,
  val ap_Id : Art.PortId,
  val vp_Id : Art.PortId,
  val as_Id : Art.PortId,
  val vs_Id : Art.PortId) extends DDD_i_Api

@datatype class DDD_i_Operational_Api (
  val id: Art.BridgeId,
  val a_Id : Art.PortId,
  val v_Id : Art.PortId,
  val ap_Id : Art.PortId,
  val vp_Id : Art.PortId,
  val as_Id : Art.PortId,
  val vs_Id : Art.PortId) extends DDD_i_Api {

  // Logika spec var representing port state for incoming event port
  @spec var a: Option[art.Empty] = $

  def get_a() : Option[art.Empty] = {
    Contract(
      Ensures(
        Res == a
      )
    )
    val value : Option[art.Empty] = Art.getValue(a_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port a.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  // Logika spec var representing port state for incoming event port
  @spec var v: Option[art.Empty] = $

  def get_v() : Option[art.Empty] = {
    Contract(
      Ensures(
        Res == v
      )
    )
    val value : Option[art.Empty] = Art.getValue(v_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port v.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }
}
