// #Sireum

package bless.sw

import org.sireum._
import art._
import bless._

@sig trait pacer_imp_Api {
  def id: Art.BridgeId
  def tna_Id : Art.PortId
  def tnv_Id : Art.PortId
  def last_v_was_vs_Id : Art.PortId
  def min_cci_Id : Art.PortId
  def max_cci_Id : Art.PortId
  def atr_max_cci_Id : Art.PortId
  def dav_Id : Art.PortId
  def fb_Id : Art.PortId
  def lrl_Id : Art.PortId
  def url_Id : Art.PortId
  def av_Id : Art.PortId
  def savo_Id : Art.PortId
  def act_Id : Art.PortId
  def vrp_Id : Art.PortId
  def arp_Id : Art.PortId
  def pvarp_Id : Art.PortId
  def ex_pvarp_Id : Art.PortId
  def hy_Id : Art.PortId
  def min_av_Id : Art.PortId
  def pv_Id : Art.PortId
  def sv_Id : Art.PortId
  def pa_Id : Art.PortId
  def sa_Id : Art.PortId
  def inhibit_Id : Art.PortId
  def track_Id : Art.PortId
  def cci_Id : Art.PortId
  def a_Id : Art.PortId
  def v_Id : Art.PortId
  def ap_Id : Art.PortId
  def vp_Id : Art.PortId
  def as_Id : Art.PortId
  def at_Id : Art.PortId
  def vs_Id : Art.PortId
  def pvc_Id : Art.PortId
  def ras_Id : Art.PortId
  def rvs_Id : Art.PortId

  // Logika spec var representing port state for outgoing data port
  @spec var last_v_was_vs: BLESS_Types.flag = $

  def put_last_v_was_vs(value : BLESS_Types.flag) : Unit = {
    Contract(
      Modifies(last_v_was_vs),
      Ensures(
        last_v_was_vs == value
      )
    )
    Spec {
      last_v_was_vs = value
    }

    Art.putValue(last_v_was_vs_Id, BLESS_Types.flag_Payload(value))
  }

  // Logika spec var representing port state for outgoing event data port
  @spec var cci: Option[PACE_Data.ms] = $

  def put_cci(value : PACE_Data.ms) : Unit = {
    Contract(
      Modifies(cci),
      Ensures(
        cci == Some(value)
      )
    )
    Spec {
      cci = Some(value)
    }

    Art.putValue(cci_Id, PACE_Data.ms_Payload(value))
  }

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
  @spec var at: Option[art.Empty] = $

  def put_at() : Unit = {
    Contract(
      Modifies(at),
      Ensures(
        at == Some(Empty())
      )
    )
    Spec {
      at = Some(Empty())
    }

    Art.putValue(at_Id, art.Empty())
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

  // Logika spec var representing port state for outgoing event port
  @spec var pvc: Option[art.Empty] = $

  def put_pvc() : Unit = {
    Contract(
      Modifies(pvc),
      Ensures(
        pvc == Some(Empty())
      )
    )
    Spec {
      pvc = Some(Empty())
    }

    Art.putValue(pvc_Id, art.Empty())
  }

  // Logika spec var representing port state for outgoing event port
  @spec var ras: Option[art.Empty] = $

  def put_ras() : Unit = {
    Contract(
      Modifies(ras),
      Ensures(
        ras == Some(Empty())
      )
    )
    Spec {
      ras = Some(Empty())
    }

    Art.putValue(ras_Id, art.Empty())
  }

  // Logika spec var representing port state for outgoing event port
  @spec var rvs: Option[art.Empty] = $

  def put_rvs() : Unit = {
    Contract(
      Modifies(rvs),
      Ensures(
        rvs == Some(Empty())
      )
    )
    Spec {
      rvs = Some(Empty())
    }

    Art.putValue(rvs_Id, art.Empty())
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

@datatype class pacer_imp_Initialization_Api (
  val id: Art.BridgeId,
  val tna_Id : Art.PortId,
  val tnv_Id : Art.PortId,
  val last_v_was_vs_Id : Art.PortId,
  val min_cci_Id : Art.PortId,
  val max_cci_Id : Art.PortId,
  val atr_max_cci_Id : Art.PortId,
  val dav_Id : Art.PortId,
  val fb_Id : Art.PortId,
  val lrl_Id : Art.PortId,
  val url_Id : Art.PortId,
  val av_Id : Art.PortId,
  val savo_Id : Art.PortId,
  val act_Id : Art.PortId,
  val vrp_Id : Art.PortId,
  val arp_Id : Art.PortId,
  val pvarp_Id : Art.PortId,
  val ex_pvarp_Id : Art.PortId,
  val hy_Id : Art.PortId,
  val min_av_Id : Art.PortId,
  val pv_Id : Art.PortId,
  val sv_Id : Art.PortId,
  val pa_Id : Art.PortId,
  val sa_Id : Art.PortId,
  val inhibit_Id : Art.PortId,
  val track_Id : Art.PortId,
  val cci_Id : Art.PortId,
  val a_Id : Art.PortId,
  val v_Id : Art.PortId,
  val ap_Id : Art.PortId,
  val vp_Id : Art.PortId,
  val as_Id : Art.PortId,
  val at_Id : Art.PortId,
  val vs_Id : Art.PortId,
  val pvc_Id : Art.PortId,
  val ras_Id : Art.PortId,
  val rvs_Id : Art.PortId) extends pacer_imp_Api

@datatype class pacer_imp_Operational_Api (
  val id: Art.BridgeId,
  val tna_Id : Art.PortId,
  val tnv_Id : Art.PortId,
  val last_v_was_vs_Id : Art.PortId,
  val min_cci_Id : Art.PortId,
  val max_cci_Id : Art.PortId,
  val atr_max_cci_Id : Art.PortId,
  val dav_Id : Art.PortId,
  val fb_Id : Art.PortId,
  val lrl_Id : Art.PortId,
  val url_Id : Art.PortId,
  val av_Id : Art.PortId,
  val savo_Id : Art.PortId,
  val act_Id : Art.PortId,
  val vrp_Id : Art.PortId,
  val arp_Id : Art.PortId,
  val pvarp_Id : Art.PortId,
  val ex_pvarp_Id : Art.PortId,
  val hy_Id : Art.PortId,
  val min_av_Id : Art.PortId,
  val pv_Id : Art.PortId,
  val sv_Id : Art.PortId,
  val pa_Id : Art.PortId,
  val sa_Id : Art.PortId,
  val inhibit_Id : Art.PortId,
  val track_Id : Art.PortId,
  val cci_Id : Art.PortId,
  val a_Id : Art.PortId,
  val v_Id : Art.PortId,
  val ap_Id : Art.PortId,
  val vp_Id : Art.PortId,
  val as_Id : Art.PortId,
  val at_Id : Art.PortId,
  val vs_Id : Art.PortId,
  val pvc_Id : Art.PortId,
  val ras_Id : Art.PortId,
  val rvs_Id : Art.PortId) extends pacer_imp_Api {

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
  @spec var min_cci: PACE_Data.ms = $

  def get_min_cci() : Option[PACE_Data.ms] = {
    Contract(
      Ensures(
        Res == Some(min_cci)
      )
    )
    val value : Option[PACE_Data.ms] = Art.getValue(min_cci_Id) match {
      case Some(PACE_Data.ms_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port min_cci.  Expecting 'PACE_Data.ms_Payload' but received ${v}")
        None[PACE_Data.ms]()
      case _ => None[PACE_Data.ms]()
    }
    return value
  }

  // Logika spec var representing port state for incoming data port
  @spec var max_cci: PACE_Data.ms = $

  def get_max_cci() : Option[PACE_Data.ms] = {
    Contract(
      Ensures(
        Res == Some(max_cci)
      )
    )
    val value : Option[PACE_Data.ms] = Art.getValue(max_cci_Id) match {
      case Some(PACE_Data.ms_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port max_cci.  Expecting 'PACE_Data.ms_Payload' but received ${v}")
        None[PACE_Data.ms]()
      case _ => None[PACE_Data.ms]()
    }
    return value
  }

  // Logika spec var representing port state for incoming data port
  @spec var atr_max_cci: PACE_Data.ms = $

  def get_atr_max_cci() : Option[PACE_Data.ms] = {
    Contract(
      Ensures(
        Res == Some(atr_max_cci)
      )
    )
    val value : Option[PACE_Data.ms] = Art.getValue(atr_max_cci_Id) match {
      case Some(PACE_Data.ms_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port atr_max_cci.  Expecting 'PACE_Data.ms_Payload' but received ${v}")
        None[PACE_Data.ms]()
      case _ => None[PACE_Data.ms]()
    }
    return value
  }

  // Logika spec var representing port state for incoming data port
  @spec var dav: PACE_Data.ms = $

  def get_dav() : Option[PACE_Data.ms] = {
    Contract(
      Ensures(
        Res == Some(dav)
      )
    )
    val value : Option[PACE_Data.ms] = Art.getValue(dav_Id) match {
      case Some(PACE_Data.ms_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port dav.  Expecting 'PACE_Data.ms_Payload' but received ${v}")
        None[PACE_Data.ms]()
      case _ => None[PACE_Data.ms]()
    }
    return value
  }

  // Logika spec var representing port state for incoming data port
  @spec var fb: BLESS_Types.flag = $

  def get_fb() : Option[BLESS_Types.flag] = {
    Contract(
      Ensures(
        Res == Some(fb)
      )
    )
    val value : Option[BLESS_Types.flag] = Art.getValue(fb_Id) match {
      case Some(BLESS_Types.flag_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port fb.  Expecting 'BLESS_Types.flag_Payload' but received ${v}")
        None[BLESS_Types.flag]()
      case _ => None[BLESS_Types.flag]()
    }
    return value
  }

  // Logika spec var representing port state for incoming data port
  @spec var lrl: PACE_Data.ms = $

  def get_lrl() : Option[PACE_Data.ms] = {
    Contract(
      Ensures(
        Res == Some(lrl)
      )
    )
    val value : Option[PACE_Data.ms] = Art.getValue(lrl_Id) match {
      case Some(PACE_Data.ms_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port lrl.  Expecting 'PACE_Data.ms_Payload' but received ${v}")
        None[PACE_Data.ms]()
      case _ => None[PACE_Data.ms]()
    }
    return value
  }

  // Logika spec var representing port state for incoming data port
  @spec var url: PACE_Data.ms = $

  def get_url() : Option[PACE_Data.ms] = {
    Contract(
      Ensures(
        Res == Some(url)
      )
    )
    val value : Option[PACE_Data.ms] = Art.getValue(url_Id) match {
      case Some(PACE_Data.ms_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port url.  Expecting 'PACE_Data.ms_Payload' but received ${v}")
        None[PACE_Data.ms]()
      case _ => None[PACE_Data.ms]()
    }
    return value
  }

  // Logika spec var representing port state for incoming data port
  @spec var av: PACE_Data.ms = $

  def get_av() : Option[PACE_Data.ms] = {
    Contract(
      Ensures(
        Res == Some(av)
      )
    )
    val value : Option[PACE_Data.ms] = Art.getValue(av_Id) match {
      case Some(PACE_Data.ms_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port av.  Expecting 'PACE_Data.ms_Payload' but received ${v}")
        None[PACE_Data.ms]()
      case _ => None[PACE_Data.ms]()
    }
    return value
  }

  // Logika spec var representing port state for incoming data port
  @spec var savo: PACE_Data.ms = $

  def get_savo() : Option[PACE_Data.ms] = {
    Contract(
      Ensures(
        Res == Some(savo)
      )
    )
    val value : Option[PACE_Data.ms] = Art.getValue(savo_Id) match {
      case Some(PACE_Data.ms_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port savo.  Expecting 'PACE_Data.ms_Payload' but received ${v}")
        None[PACE_Data.ms]()
      case _ => None[PACE_Data.ms]()
    }
    return value
  }

  // Logika spec var representing port state for incoming data port
  @spec var act: PACE_Data.milliG = $

  def get_act() : Option[PACE_Data.milliG] = {
    Contract(
      Ensures(
        Res == Some(act)
      )
    )
    val value : Option[PACE_Data.milliG] = Art.getValue(act_Id) match {
      case Some(PACE_Data.milliG_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port act.  Expecting 'PACE_Data.milliG_Payload' but received ${v}")
        None[PACE_Data.milliG]()
      case _ => None[PACE_Data.milliG]()
    }
    return value
  }

  // Logika spec var representing port state for incoming data port
  @spec var vrp: PACE_Data.ms = $

  def get_vrp() : Option[PACE_Data.ms] = {
    Contract(
      Ensures(
        Res == Some(vrp)
      )
    )
    val value : Option[PACE_Data.ms] = Art.getValue(vrp_Id) match {
      case Some(PACE_Data.ms_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port vrp.  Expecting 'PACE_Data.ms_Payload' but received ${v}")
        None[PACE_Data.ms]()
      case _ => None[PACE_Data.ms]()
    }
    return value
  }

  // Logika spec var representing port state for incoming data port
  @spec var arp: PACE_Data.ms = $

  def get_arp() : Option[PACE_Data.ms] = {
    Contract(
      Ensures(
        Res == Some(arp)
      )
    )
    val value : Option[PACE_Data.ms] = Art.getValue(arp_Id) match {
      case Some(PACE_Data.ms_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port arp.  Expecting 'PACE_Data.ms_Payload' but received ${v}")
        None[PACE_Data.ms]()
      case _ => None[PACE_Data.ms]()
    }
    return value
  }

  // Logika spec var representing port state for incoming data port
  @spec var pvarp: PACE_Data.ms = $

  def get_pvarp() : Option[PACE_Data.ms] = {
    Contract(
      Ensures(
        Res == Some(pvarp)
      )
    )
    val value : Option[PACE_Data.ms] = Art.getValue(pvarp_Id) match {
      case Some(PACE_Data.ms_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port pvarp.  Expecting 'PACE_Data.ms_Payload' but received ${v}")
        None[PACE_Data.ms]()
      case _ => None[PACE_Data.ms]()
    }
    return value
  }

  // Logika spec var representing port state for incoming data port
  @spec var ex_pvarp: PACE_Data.ms = $

  def get_ex_pvarp() : Option[PACE_Data.ms] = {
    Contract(
      Ensures(
        Res == Some(ex_pvarp)
      )
    )
    val value : Option[PACE_Data.ms] = Art.getValue(ex_pvarp_Id) match {
      case Some(PACE_Data.ms_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port ex_pvarp.  Expecting 'PACE_Data.ms_Payload' but received ${v}")
        None[PACE_Data.ms]()
      case _ => None[PACE_Data.ms]()
    }
    return value
  }

  // Logika spec var representing port state for incoming data port
  @spec var hy: PACE_Data.ms = $

  def get_hy() : Option[PACE_Data.ms] = {
    Contract(
      Ensures(
        Res == Some(hy)
      )
    )
    val value : Option[PACE_Data.ms] = Art.getValue(hy_Id) match {
      case Some(PACE_Data.ms_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port hy.  Expecting 'PACE_Data.ms_Payload' but received ${v}")
        None[PACE_Data.ms]()
      case _ => None[PACE_Data.ms]()
    }
    return value
  }

  // Logika spec var representing port state for incoming data port
  @spec var min_av: PACE_Data.ms = $

  def get_min_av() : Option[PACE_Data.ms] = {
    Contract(
      Ensures(
        Res == Some(min_av)
      )
    )
    val value : Option[PACE_Data.ms] = Art.getValue(min_av_Id) match {
      case Some(PACE_Data.ms_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port min_av.  Expecting 'PACE_Data.ms_Payload' but received ${v}")
        None[PACE_Data.ms]()
      case _ => None[PACE_Data.ms]()
    }
    return value
  }

  // Logika spec var representing port state for incoming data port
  @spec var pv: BLESS_Types.flag = $

  def get_pv() : Option[BLESS_Types.flag] = {
    Contract(
      Ensures(
        Res == Some(pv)
      )
    )
    val value : Option[BLESS_Types.flag] = Art.getValue(pv_Id) match {
      case Some(BLESS_Types.flag_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port pv.  Expecting 'BLESS_Types.flag_Payload' but received ${v}")
        None[BLESS_Types.flag]()
      case _ => None[BLESS_Types.flag]()
    }
    return value
  }

  // Logika spec var representing port state for incoming data port
  @spec var sv: BLESS_Types.flag = $

  def get_sv() : Option[BLESS_Types.flag] = {
    Contract(
      Ensures(
        Res == Some(sv)
      )
    )
    val value : Option[BLESS_Types.flag] = Art.getValue(sv_Id) match {
      case Some(BLESS_Types.flag_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port sv.  Expecting 'BLESS_Types.flag_Payload' but received ${v}")
        None[BLESS_Types.flag]()
      case _ => None[BLESS_Types.flag]()
    }
    return value
  }

  // Logika spec var representing port state for incoming data port
  @spec var pa: BLESS_Types.flag = $

  def get_pa() : Option[BLESS_Types.flag] = {
    Contract(
      Ensures(
        Res == Some(pa)
      )
    )
    val value : Option[BLESS_Types.flag] = Art.getValue(pa_Id) match {
      case Some(BLESS_Types.flag_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port pa.  Expecting 'BLESS_Types.flag_Payload' but received ${v}")
        None[BLESS_Types.flag]()
      case _ => None[BLESS_Types.flag]()
    }
    return value
  }

  // Logika spec var representing port state for incoming data port
  @spec var sa: BLESS_Types.flag = $

  def get_sa() : Option[BLESS_Types.flag] = {
    Contract(
      Ensures(
        Res == Some(sa)
      )
    )
    val value : Option[BLESS_Types.flag] = Art.getValue(sa_Id) match {
      case Some(BLESS_Types.flag_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port sa.  Expecting 'BLESS_Types.flag_Payload' but received ${v}")
        None[BLESS_Types.flag]()
      case _ => None[BLESS_Types.flag]()
    }
    return value
  }

  // Logika spec var representing port state for incoming data port
  @spec var inhibit: BLESS_Types.flag = $

  def get_inhibit() : Option[BLESS_Types.flag] = {
    Contract(
      Ensures(
        Res == Some(inhibit)
      )
    )
    val value : Option[BLESS_Types.flag] = Art.getValue(inhibit_Id) match {
      case Some(BLESS_Types.flag_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port inhibit.  Expecting 'BLESS_Types.flag_Payload' but received ${v}")
        None[BLESS_Types.flag]()
      case _ => None[BLESS_Types.flag]()
    }
    return value
  }

  // Logika spec var representing port state for incoming data port
  @spec var track: BLESS_Types.flag = $

  def get_track() : Option[BLESS_Types.flag] = {
    Contract(
      Ensures(
        Res == Some(track)
      )
    )
    val value : Option[BLESS_Types.flag] = Art.getValue(track_Id) match {
      case Some(BLESS_Types.flag_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port track.  Expecting 'BLESS_Types.flag_Payload' but received ${v}")
        None[BLESS_Types.flag]()
      case _ => None[BLESS_Types.flag]()
    }
    return value
  }

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
