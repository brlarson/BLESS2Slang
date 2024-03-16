// #Sireum

package bless.vvi_mode

import org.sireum._
import art._
import bless._

@sig trait VVI_i_Api {
  def id: Art.BridgeId
  def lrl_Id : Art.PortId
  def vrp_Id : Art.PortId
  def s_Id : Art.PortId
  def p_Id : Art.PortId
  def n_Id : Art.PortId
  def h_Id : Art.PortId

  // Logika spec var representing port state for outgoing event port
  @spec var p: Option[art.Empty] = $

  def put_p() : Unit = {
    Contract(
      Modifies(p),
      Ensures(
        p == Some(Empty())
      )
    )
    Spec {
      p = Some(Empty())
    }

    Art.putValue(p_Id, art.Empty())
  }

  // Logika spec var representing port state for outgoing event port
  @spec var n: Option[art.Empty] = $

  def put_n() : Unit = {
    Contract(
      Modifies(n),
      Ensures(
        n == Some(Empty())
      )
    )
    Spec {
      n = Some(Empty())
    }

    Art.putValue(n_Id, art.Empty())
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

@datatype class VVI_i_Initialization_Api (
  val id: Art.BridgeId,
  val lrl_Id : Art.PortId,
  val vrp_Id : Art.PortId,
  val s_Id : Art.PortId,
  val p_Id : Art.PortId,
  val n_Id : Art.PortId,
  val h_Id : Art.PortId) extends VVI_i_Api

@datatype class VVI_i_Operational_Api (
  val id: Art.BridgeId,
  val lrl_Id : Art.PortId,
  val vrp_Id : Art.PortId,
  val s_Id : Art.PortId,
  val p_Id : Art.PortId,
  val n_Id : Art.PortId,
  val h_Id : Art.PortId) extends VVI_i_Api {

  // Logika spec var representing port state for incoming data port
  @spec var lrl: vvi_mode.CardiacDuration = $

  def get_lrl() : Option[vvi_mode.CardiacDuration] = {
    Contract(
      Ensures(
        Res == Some(lrl)
      )
    )
    val value : Option[vvi_mode.CardiacDuration] = Art.getValue(lrl_Id) match {
      case Some(vvi_mode.CardiacDuration_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port lrl.  Expecting 'vvi_mode.CardiacDuration_Payload' but received ${v}")
        None[vvi_mode.CardiacDuration]()
      case _ => None[vvi_mode.CardiacDuration]()
    }
    return value
  }

  // Logika spec var representing port state for incoming data port
  @spec var vrp: vvi_mode.CardiacDuration = $

  def get_vrp() : Option[vvi_mode.CardiacDuration] = {
    Contract(
      Ensures(
        Res == Some(vrp)
      )
    )
    val value : Option[vvi_mode.CardiacDuration] = Art.getValue(vrp_Id) match {
      case Some(vvi_mode.CardiacDuration_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port vrp.  Expecting 'vvi_mode.CardiacDuration_Payload' but received ${v}")
        None[vvi_mode.CardiacDuration]()
      case _ => None[vvi_mode.CardiacDuration]()
    }
    return value
  }

  // Logika spec var representing port state for incoming event port
  @spec var s: Option[art.Empty] = $

  def get_s() : Option[art.Empty] = {
    Contract(
      Ensures(
        Res == s
      )
    )
    val value : Option[art.Empty] = Art.getValue(s_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port s.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  // Logika spec var representing port state for incoming event port
  @spec var h: Option[art.Empty] = $

  def get_h() : Option[art.Empty] = {
    Contract(
      Ensures(
        Res == h
      )
    )
    val value : Option[art.Empty] = Art.getValue(h_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port h.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }
}
