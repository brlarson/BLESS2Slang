// #Sireum

package bless.Rx

import org.sireum._
import art._
import bless._

@sig trait Settings_imp_Api {
  def id: Art.BridgeId
  def lrl_Id : Art.PortId
  def url_Id : Art.PortId
  def av_Id : Art.PortId
  def savo_Id : Art.PortId
  def act_Id : Art.PortId
  def vrp_Id : Art.PortId
  def arp_Id : Art.PortId
  def pvarp_Id : Art.PortId
  def pv_Id : Art.PortId
  def sv_Id : Art.PortId
  def pa_Id : Art.PortId
  def sa_Id : Art.PortId
  def inhibit_Id : Art.PortId
  def track_Id : Art.PortId
  def hy_Id : Art.PortId
  def rr_Id : Art.PortId
  def rf_Id : Art.PortId
  def msr_Id : Art.PortId
  def min_av_Id : Art.PortId
  def ex_pvarp_Id : Art.PortId
  def rt_Id : Art.PortId
  def ct_Id : Art.PortId
  def atr_enable_Id : Art.PortId
  def atr_duration_Id : Art.PortId
  def fb_time_Id : Art.PortId
  def drs_Id : Art.PortId
  def urs_Id : Art.PortId
  def settings_Id : Art.PortId

  // Logika spec var representing port state for outgoing data port
  @spec var lrl: PACE_Data.ms = $

  def put_lrl(value : PACE_Data.ms) : Unit = {
    Contract(
      Modifies(lrl),
      Ensures(
        lrl == value
      )
    )
    Spec {
      lrl = value
    }

    Art.putValue(lrl_Id, PACE_Data.ms_Payload(value))
  }

  // Logika spec var representing port state for outgoing data port
  @spec var url: PACE_Data.ms = $

  def put_url(value : PACE_Data.ms) : Unit = {
    Contract(
      Modifies(url),
      Ensures(
        url == value
      )
    )
    Spec {
      url = value
    }

    Art.putValue(url_Id, PACE_Data.ms_Payload(value))
  }

  // Logika spec var representing port state for outgoing data port
  @spec var av: PACE_Data.ms = $

  def put_av(value : PACE_Data.ms) : Unit = {
    Contract(
      Modifies(av),
      Ensures(
        av == value
      )
    )
    Spec {
      av = value
    }

    Art.putValue(av_Id, PACE_Data.ms_Payload(value))
  }

  // Logika spec var representing port state for outgoing data port
  @spec var savo: PACE_Data.ms = $

  def put_savo(value : PACE_Data.ms) : Unit = {
    Contract(
      Modifies(savo),
      Ensures(
        savo == value
      )
    )
    Spec {
      savo = value
    }

    Art.putValue(savo_Id, PACE_Data.ms_Payload(value))
  }

  // Logika spec var representing port state for outgoing data port
  @spec var act: PACE_Data.milliG = $

  def put_act(value : PACE_Data.milliG) : Unit = {
    Contract(
      Modifies(act),
      Ensures(
        act == value
      )
    )
    Spec {
      act = value
    }

    Art.putValue(act_Id, PACE_Data.milliG_Payload(value))
  }

  // Logika spec var representing port state for outgoing data port
  @spec var vrp: PACE_Data.ms = $

  def put_vrp(value : PACE_Data.ms) : Unit = {
    Contract(
      Modifies(vrp),
      Ensures(
        vrp == value
      )
    )
    Spec {
      vrp = value
    }

    Art.putValue(vrp_Id, PACE_Data.ms_Payload(value))
  }

  // Logika spec var representing port state for outgoing data port
  @spec var arp: PACE_Data.ms = $

  def put_arp(value : PACE_Data.ms) : Unit = {
    Contract(
      Modifies(arp),
      Ensures(
        arp == value
      )
    )
    Spec {
      arp = value
    }

    Art.putValue(arp_Id, PACE_Data.ms_Payload(value))
  }

  // Logika spec var representing port state for outgoing data port
  @spec var pvarp: PACE_Data.ms = $

  def put_pvarp(value : PACE_Data.ms) : Unit = {
    Contract(
      Modifies(pvarp),
      Ensures(
        pvarp == value
      )
    )
    Spec {
      pvarp = value
    }

    Art.putValue(pvarp_Id, PACE_Data.ms_Payload(value))
  }

  // Logika spec var representing port state for outgoing data port
  @spec var pv: BLESS_Types.flag = $

  def put_pv(value : BLESS_Types.flag) : Unit = {
    Contract(
      Modifies(pv),
      Ensures(
        pv == value
      )
    )
    Spec {
      pv = value
    }

    Art.putValue(pv_Id, BLESS_Types.flag_Payload(value))
  }

  // Logika spec var representing port state for outgoing data port
  @spec var sv: BLESS_Types.flag = $

  def put_sv(value : BLESS_Types.flag) : Unit = {
    Contract(
      Modifies(sv),
      Ensures(
        sv == value
      )
    )
    Spec {
      sv = value
    }

    Art.putValue(sv_Id, BLESS_Types.flag_Payload(value))
  }

  // Logika spec var representing port state for outgoing data port
  @spec var pa: BLESS_Types.flag = $

  def put_pa(value : BLESS_Types.flag) : Unit = {
    Contract(
      Modifies(pa),
      Ensures(
        pa == value
      )
    )
    Spec {
      pa = value
    }

    Art.putValue(pa_Id, BLESS_Types.flag_Payload(value))
  }

  // Logika spec var representing port state for outgoing data port
  @spec var sa: BLESS_Types.flag = $

  def put_sa(value : BLESS_Types.flag) : Unit = {
    Contract(
      Modifies(sa),
      Ensures(
        sa == value
      )
    )
    Spec {
      sa = value
    }

    Art.putValue(sa_Id, BLESS_Types.flag_Payload(value))
  }

  // Logika spec var representing port state for outgoing data port
  @spec var inhibit: BLESS_Types.flag = $

  def put_inhibit(value : BLESS_Types.flag) : Unit = {
    Contract(
      Modifies(inhibit),
      Ensures(
        inhibit == value
      )
    )
    Spec {
      inhibit = value
    }

    Art.putValue(inhibit_Id, BLESS_Types.flag_Payload(value))
  }

  // Logika spec var representing port state for outgoing data port
  @spec var track: BLESS_Types.flag = $

  def put_track(value : BLESS_Types.flag) : Unit = {
    Contract(
      Modifies(track),
      Ensures(
        track == value
      )
    )
    Spec {
      track = value
    }

    Art.putValue(track_Id, BLESS_Types.flag_Payload(value))
  }

  // Logika spec var representing port state for outgoing data port
  @spec var hy: PACE_Data.ms = $

  def put_hy(value : PACE_Data.ms) : Unit = {
    Contract(
      Modifies(hy),
      Ensures(
        hy == value
      )
    )
    Spec {
      hy = value
    }

    Art.putValue(hy_Id, PACE_Data.ms_Payload(value))
  }

  // Logika spec var representing port state for outgoing data port
  @spec var rr: BLESS_Types.flag = $

  def put_rr(value : BLESS_Types.flag) : Unit = {
    Contract(
      Modifies(rr),
      Ensures(
        rr == value
      )
    )
    Spec {
      rr = value
    }

    Art.putValue(rr_Id, BLESS_Types.flag_Payload(value))
  }

  // Logika spec var representing port state for outgoing data port
  @spec var rf: PACE_Data.rf = $

  def put_rf(value : PACE_Data.rf) : Unit = {
    Contract(
      Modifies(rf),
      Ensures(
        rf == value
      )
    )
    Spec {
      rf = value
    }

    Art.putValue(rf_Id, PACE_Data.rf_Payload(value))
  }

  // Logika spec var representing port state for outgoing data port
  @spec var msr: PACE_Data.ms = $

  def put_msr(value : PACE_Data.ms) : Unit = {
    Contract(
      Modifies(msr),
      Ensures(
        msr == value
      )
    )
    Spec {
      msr = value
    }

    Art.putValue(msr_Id, PACE_Data.ms_Payload(value))
  }

  // Logika spec var representing port state for outgoing data port
  @spec var min_av: PACE_Data.ms = $

  def put_min_av(value : PACE_Data.ms) : Unit = {
    Contract(
      Modifies(min_av),
      Ensures(
        min_av == value
      )
    )
    Spec {
      min_av = value
    }

    Art.putValue(min_av_Id, PACE_Data.ms_Payload(value))
  }

  // Logika spec var representing port state for outgoing data port
  @spec var ex_pvarp: PACE_Data.ms = $

  def put_ex_pvarp(value : PACE_Data.ms) : Unit = {
    Contract(
      Modifies(ex_pvarp),
      Ensures(
        ex_pvarp == value
      )
    )
    Spec {
      ex_pvarp = value
    }

    Art.putValue(ex_pvarp_Id, PACE_Data.ms_Payload(value))
  }

  // Logika spec var representing port state for outgoing data port
  @spec var rt: PACE_Data.second = $

  def put_rt(value : PACE_Data.second) : Unit = {
    Contract(
      Modifies(rt),
      Ensures(
        rt == value
      )
    )
    Spec {
      rt = value
    }

    Art.putValue(rt_Id, PACE_Data.second_Payload(value))
  }

  // Logika spec var representing port state for outgoing data port
  @spec var ct: PACE_Data.second = $

  def put_ct(value : PACE_Data.second) : Unit = {
    Contract(
      Modifies(ct),
      Ensures(
        ct == value
      )
    )
    Spec {
      ct = value
    }

    Art.putValue(ct_Id, PACE_Data.second_Payload(value))
  }

  // Logika spec var representing port state for outgoing data port
  @spec var atr_enable: BLESS_Types.flag = $

  def put_atr_enable(value : BLESS_Types.flag) : Unit = {
    Contract(
      Modifies(atr_enable),
      Ensures(
        atr_enable == value
      )
    )
    Spec {
      atr_enable = value
    }

    Art.putValue(atr_enable_Id, BLESS_Types.flag_Payload(value))
  }

  // Logika spec var representing port state for outgoing data port
  @spec var atr_duration: PACE_Data.CCcount = $

  def put_atr_duration(value : PACE_Data.CCcount) : Unit = {
    Contract(
      Modifies(atr_duration),
      Ensures(
        atr_duration == value
      )
    )
    Spec {
      atr_duration = value
    }

    Art.putValue(atr_duration_Id, PACE_Data.CCcount_Payload(value))
  }

  // Logika spec var representing port state for outgoing data port
  @spec var fb_time: PACE_Data.second = $

  def put_fb_time(value : PACE_Data.second) : Unit = {
    Contract(
      Modifies(fb_time),
      Ensures(
        fb_time == value
      )
    )
    Spec {
      fb_time = value
    }

    Art.putValue(fb_time_Id, PACE_Data.second_Payload(value))
  }

  // Logika spec var representing port state for outgoing data port
  @spec var drs: PACE_Data.percent = $

  def put_drs(value : PACE_Data.percent) : Unit = {
    Contract(
      Modifies(drs),
      Ensures(
        drs == value
      )
    )
    Spec {
      drs = value
    }

    Art.putValue(drs_Id, PACE_Data.percent_Payload(value))
  }

  // Logika spec var representing port state for outgoing data port
  @spec var urs: PACE_Data.percent = $

  def put_urs(value : PACE_Data.percent) : Unit = {
    Contract(
      Modifies(urs),
      Ensures(
        urs == value
      )
    )
    Spec {
      urs = value
    }

    Art.putValue(urs_Id, PACE_Data.percent_Payload(value))
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

@datatype class Settings_imp_Initialization_Api (
  val id: Art.BridgeId,
  val lrl_Id : Art.PortId,
  val url_Id : Art.PortId,
  val av_Id : Art.PortId,
  val savo_Id : Art.PortId,
  val act_Id : Art.PortId,
  val vrp_Id : Art.PortId,
  val arp_Id : Art.PortId,
  val pvarp_Id : Art.PortId,
  val pv_Id : Art.PortId,
  val sv_Id : Art.PortId,
  val pa_Id : Art.PortId,
  val sa_Id : Art.PortId,
  val inhibit_Id : Art.PortId,
  val track_Id : Art.PortId,
  val hy_Id : Art.PortId,
  val rr_Id : Art.PortId,
  val rf_Id : Art.PortId,
  val msr_Id : Art.PortId,
  val min_av_Id : Art.PortId,
  val ex_pvarp_Id : Art.PortId,
  val rt_Id : Art.PortId,
  val ct_Id : Art.PortId,
  val atr_enable_Id : Art.PortId,
  val atr_duration_Id : Art.PortId,
  val fb_time_Id : Art.PortId,
  val drs_Id : Art.PortId,
  val urs_Id : Art.PortId,
  val settings_Id : Art.PortId) extends Settings_imp_Api

@datatype class Settings_imp_Operational_Api (
  val id: Art.BridgeId,
  val lrl_Id : Art.PortId,
  val url_Id : Art.PortId,
  val av_Id : Art.PortId,
  val savo_Id : Art.PortId,
  val act_Id : Art.PortId,
  val vrp_Id : Art.PortId,
  val arp_Id : Art.PortId,
  val pvarp_Id : Art.PortId,
  val pv_Id : Art.PortId,
  val sv_Id : Art.PortId,
  val pa_Id : Art.PortId,
  val sa_Id : Art.PortId,
  val inhibit_Id : Art.PortId,
  val track_Id : Art.PortId,
  val hy_Id : Art.PortId,
  val rr_Id : Art.PortId,
  val rf_Id : Art.PortId,
  val msr_Id : Art.PortId,
  val min_av_Id : Art.PortId,
  val ex_pvarp_Id : Art.PortId,
  val rt_Id : Art.PortId,
  val ct_Id : Art.PortId,
  val atr_enable_Id : Art.PortId,
  val atr_duration_Id : Art.PortId,
  val fb_time_Id : Art.PortId,
  val drs_Id : Art.PortId,
  val urs_Id : Art.PortId,
  val settings_Id : Art.PortId) extends Settings_imp_Api {

  // Logika spec var representing port state for incoming event data port
  @spec var settings: Option[PACE_Data.Rx] = $

  def get_settings() : Option[PACE_Data.Rx] = {
    Contract(
      Ensures(
        Res == settings
      )
    )
    val value : Option[PACE_Data.Rx] = Art.getValue(settings_Id) match {
      case Some(PACE_Data.Rx_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port settings.  Expecting 'PACE_Data.Rx_Payload' but received ${v}")
        None[PACE_Data.Rx]()
      case _ => None[PACE_Data.Rx]()
    }
    return value
  }
}
