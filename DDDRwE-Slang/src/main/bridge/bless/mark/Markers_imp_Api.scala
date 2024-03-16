// #Sireum

package bless.mark

import org.sireum._
import art._
import bless._

@sig trait Markers_imp_Api {
  def id: Art.BridgeId
  def tna_Id : Art.PortId
  def tnv_Id : Art.PortId
  def cci_Id : Art.PortId
  def mark_A_Id : Art.PortId
  def mark_V_Id : Art.PortId
  def mark_X_Id : Art.PortId
  def atr_dct_Id : Art.PortId
  def atr_end_Id : Art.PortId
  def ap_Id : Art.PortId
  def vp_Id : Art.PortId
  def as_Id : Art.PortId
  def at_Id : Art.PortId
  def vs_Id : Art.PortId
  def pvc_Id : Art.PortId
  def ras_Id : Art.PortId
  def rvs_Id : Art.PortId
  def atr_fb_Id : Art.PortId

  // Logika spec var representing port state for outgoing event data port
  @spec var mark_A: Option[mark.AtrialMarker] = $

  def put_mark_A(value : mark.AtrialMarker) : Unit = {
    Contract(
      Modifies(mark_A),
      Ensures(
        mark_A == Some(value)
      )
    )
    Spec {
      mark_A = Some(value)
    }

    Art.putValue(mark_A_Id, mark.AtrialMarker_Payload(value))
  }

  // Logika spec var representing port state for outgoing event data port
  @spec var mark_V: Option[mark.VentricularlMarker] = $

  def put_mark_V(value : mark.VentricularlMarker) : Unit = {
    Contract(
      Modifies(mark_V),
      Ensures(
        mark_V == Some(value)
      )
    )
    Spec {
      mark_V = Some(value)
    }

    Art.putValue(mark_V_Id, mark.VentricularlMarker_Payload(value))
  }

  // Logika spec var representing port state for outgoing event data port
  @spec var mark_X: Option[mark.ExtraordinaryMarker] = $

  def put_mark_X(value : mark.ExtraordinaryMarker) : Unit = {
    Contract(
      Modifies(mark_X),
      Ensures(
        mark_X == Some(value)
      )
    )
    Spec {
      mark_X = Some(value)
    }

    Art.putValue(mark_X_Id, mark.ExtraordinaryMarker_Payload(value))
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

@datatype class Markers_imp_Initialization_Api (
  val id: Art.BridgeId,
  val tna_Id : Art.PortId,
  val tnv_Id : Art.PortId,
  val cci_Id : Art.PortId,
  val mark_A_Id : Art.PortId,
  val mark_V_Id : Art.PortId,
  val mark_X_Id : Art.PortId,
  val atr_dct_Id : Art.PortId,
  val atr_end_Id : Art.PortId,
  val ap_Id : Art.PortId,
  val vp_Id : Art.PortId,
  val as_Id : Art.PortId,
  val at_Id : Art.PortId,
  val vs_Id : Art.PortId,
  val pvc_Id : Art.PortId,
  val ras_Id : Art.PortId,
  val rvs_Id : Art.PortId,
  val atr_fb_Id : Art.PortId) extends Markers_imp_Api

@datatype class Markers_imp_Operational_Api (
  val id: Art.BridgeId,
  val tna_Id : Art.PortId,
  val tnv_Id : Art.PortId,
  val cci_Id : Art.PortId,
  val mark_A_Id : Art.PortId,
  val mark_V_Id : Art.PortId,
  val mark_X_Id : Art.PortId,
  val atr_dct_Id : Art.PortId,
  val atr_end_Id : Art.PortId,
  val ap_Id : Art.PortId,
  val vp_Id : Art.PortId,
  val as_Id : Art.PortId,
  val at_Id : Art.PortId,
  val vs_Id : Art.PortId,
  val pvc_Id : Art.PortId,
  val ras_Id : Art.PortId,
  val rvs_Id : Art.PortId,
  val atr_fb_Id : Art.PortId) extends Markers_imp_Api {

  // Logika spec var representing port state for incoming data port
  @spec var tna: BLESS_Types.flag = $

  def get_tna() : Option[BLESS_Types.flag] = {
    Contract(
      Ensures(
        Res == Some(tna)
      )
    )
    val value : Option[BLESS_Types.flag] = Art.getValue(tna_Id) match {
      case Some(BLESS_Types.flag_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port tna.  Expecting 'BLESS_Types.flag_Payload' but received ${v}")
        None[BLESS_Types.flag]()
      case _ => None[BLESS_Types.flag]()
    }
    return value
  }

  // Logika spec var representing port state for incoming data port
  @spec var tnv: BLESS_Types.flag = $

  def get_tnv() : Option[BLESS_Types.flag] = {
    Contract(
      Ensures(
        Res == Some(tnv)
      )
    )
    val value : Option[BLESS_Types.flag] = Art.getValue(tnv_Id) match {
      case Some(BLESS_Types.flag_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port tnv.  Expecting 'BLESS_Types.flag_Payload' but received ${v}")
        None[BLESS_Types.flag]()
      case _ => None[BLESS_Types.flag]()
    }
    return value
  }

  // Logika spec var representing port state for incoming data port
  @spec var cci: PACE_Data.ms = $

  def get_cci() : Option[PACE_Data.ms] = {
    Contract(
      Ensures(
        Res == Some(cci)
      )
    )
    val value : Option[PACE_Data.ms] = Art.getValue(cci_Id) match {
      case Some(PACE_Data.ms_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port cci.  Expecting 'PACE_Data.ms_Payload' but received ${v}")
        None[PACE_Data.ms]()
      case _ => None[PACE_Data.ms]()
    }
    return value
  }

  // Logika spec var representing port state for incoming event data port
  @spec var atr_dct: Option[BLESS_Types.flag] = $

  def get_atr_dct() : Option[BLESS_Types.flag] = {
    Contract(
      Ensures(
        Res == atr_dct
      )
    )
    val value : Option[BLESS_Types.flag] = Art.getValue(atr_dct_Id) match {
      case Some(BLESS_Types.flag_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port atr_dct.  Expecting 'BLESS_Types.flag_Payload' but received ${v}")
        None[BLESS_Types.flag]()
      case _ => None[BLESS_Types.flag]()
    }
    return value
  }

  // Logika spec var representing port state for incoming event data port
  @spec var atr_end: Option[BLESS_Types.flag] = $

  def get_atr_end() : Option[BLESS_Types.flag] = {
    Contract(
      Ensures(
        Res == atr_end
      )
    )
    val value : Option[BLESS_Types.flag] = Art.getValue(atr_end_Id) match {
      case Some(BLESS_Types.flag_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port atr_end.  Expecting 'BLESS_Types.flag_Payload' but received ${v}")
        None[BLESS_Types.flag]()
      case _ => None[BLESS_Types.flag]()
    }
    return value
  }

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

  // Logika spec var representing port state for incoming event port
  @spec var as: Option[art.Empty] = $

  def get_as() : Option[art.Empty] = {
    Contract(
      Ensures(
        Res == as
      )
    )
    val value : Option[art.Empty] = Art.getValue(as_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port as.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  // Logika spec var representing port state for incoming event port
  @spec var at: Option[art.Empty] = $

  def get_at() : Option[art.Empty] = {
    Contract(
      Ensures(
        Res == at
      )
    )
    val value : Option[art.Empty] = Art.getValue(at_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port at.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  // Logika spec var representing port state for incoming event port
  @spec var vs: Option[art.Empty] = $

  def get_vs() : Option[art.Empty] = {
    Contract(
      Ensures(
        Res == vs
      )
    )
    val value : Option[art.Empty] = Art.getValue(vs_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port vs.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  // Logika spec var representing port state for incoming event port
  @spec var pvc: Option[art.Empty] = $

  def get_pvc() : Option[art.Empty] = {
    Contract(
      Ensures(
        Res == pvc
      )
    )
    val value : Option[art.Empty] = Art.getValue(pvc_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port pvc.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  // Logika spec var representing port state for incoming event port
  @spec var ras: Option[art.Empty] = $

  def get_ras() : Option[art.Empty] = {
    Contract(
      Ensures(
        Res == ras
      )
    )
    val value : Option[art.Empty] = Art.getValue(ras_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port ras.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  // Logika spec var representing port state for incoming event port
  @spec var rvs: Option[art.Empty] = $

  def get_rvs() : Option[art.Empty] = {
    Contract(
      Ensures(
        Res == rvs
      )
    )
    val value : Option[art.Empty] = Art.getValue(rvs_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port rvs.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  // Logika spec var representing port state for incoming event port
  @spec var atr_fb: Option[art.Empty] = $

  def get_atr_fb() : Option[art.Empty] = {
    Contract(
      Ensures(
        Res == atr_fb
      )
    )
    val value : Option[art.Empty] = Art.getValue(atr_fb_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port atr_fb.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }
}
