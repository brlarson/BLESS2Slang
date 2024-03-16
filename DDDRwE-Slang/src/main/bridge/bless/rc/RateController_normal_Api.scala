// #Sireum

package bless.rc

import org.sireum._
import art._
import bless._

@sig trait RateController_normal_Api {
  def id: Art.BridgeId
  def min_cci_Id : Art.PortId
  def max_cci_Id : Art.PortId
  def atr_max_cci_Id : Art.PortId
  def dav_Id : Art.PortId
  def xl_Id : Art.PortId
  def mag_Id : Art.PortId
  def last_v_was_vs_Id : Art.PortId
  def rr_Id : Art.PortId
  def rf_Id : Art.PortId
  def rt_Id : Art.PortId
  def at_Id : Art.PortId
  def ct_Id : Art.PortId
  def lrl_Id : Art.PortId
  def url_Id : Art.PortId
  def msr_Id : Art.PortId
  def av_Id : Art.PortId
  def min_av_Id : Art.PortId
  def drs_Id : Art.PortId
  def urs_Id : Art.PortId
  def fb_time_Id : Art.PortId
  def hy_Id : Art.PortId
  def cci_Id : Art.PortId

  // Logika spec var representing port state for outgoing data port
  @spec var min_cci: PACE_Data.ms = $

  def put_min_cci(value : PACE_Data.ms) : Unit = {
    Contract(
      Modifies(min_cci),
      Ensures(
        min_cci == value
      )
    )
    Spec {
      min_cci = value
    }

    Art.putValue(min_cci_Id, PACE_Data.ms_Payload(value))
  }

  // Logika spec var representing port state for outgoing data port
  @spec var max_cci: PACE_Data.ms = $

  def put_max_cci(value : PACE_Data.ms) : Unit = {
    Contract(
      Modifies(max_cci),
      Ensures(
        max_cci == value
      )
    )
    Spec {
      max_cci = value
    }

    Art.putValue(max_cci_Id, PACE_Data.ms_Payload(value))
  }

  // Logika spec var representing port state for outgoing data port
  @spec var atr_max_cci: PACE_Data.ms = $

  def put_atr_max_cci(value : PACE_Data.ms) : Unit = {
    Contract(
      Modifies(atr_max_cci),
      Ensures(
        atr_max_cci == value
      )
    )
    Spec {
      atr_max_cci = value
    }

    Art.putValue(atr_max_cci_Id, PACE_Data.ms_Payload(value))
  }

  // Logika spec var representing port state for outgoing data port
  @spec var dav: PACE_Data.ms = $

  def put_dav(value : PACE_Data.ms) : Unit = {
    Contract(
      Modifies(dav),
      Ensures(
        dav == value
      )
    )
    Spec {
      dav = value
    }

    Art.putValue(dav_Id, PACE_Data.ms_Payload(value))
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

@datatype class RateController_normal_Initialization_Api (
  val id: Art.BridgeId,
  val min_cci_Id : Art.PortId,
  val max_cci_Id : Art.PortId,
  val atr_max_cci_Id : Art.PortId,
  val dav_Id : Art.PortId,
  val xl_Id : Art.PortId,
  val mag_Id : Art.PortId,
  val last_v_was_vs_Id : Art.PortId,
  val rr_Id : Art.PortId,
  val rf_Id : Art.PortId,
  val rt_Id : Art.PortId,
  val at_Id : Art.PortId,
  val ct_Id : Art.PortId,
  val lrl_Id : Art.PortId,
  val url_Id : Art.PortId,
  val msr_Id : Art.PortId,
  val av_Id : Art.PortId,
  val min_av_Id : Art.PortId,
  val drs_Id : Art.PortId,
  val urs_Id : Art.PortId,
  val fb_time_Id : Art.PortId,
  val hy_Id : Art.PortId,
  val cci_Id : Art.PortId) extends RateController_normal_Api

@datatype class RateController_normal_Operational_Api (
  val id: Art.BridgeId,
  val min_cci_Id : Art.PortId,
  val max_cci_Id : Art.PortId,
  val atr_max_cci_Id : Art.PortId,
  val dav_Id : Art.PortId,
  val xl_Id : Art.PortId,
  val mag_Id : Art.PortId,
  val last_v_was_vs_Id : Art.PortId,
  val rr_Id : Art.PortId,
  val rf_Id : Art.PortId,
  val rt_Id : Art.PortId,
  val at_Id : Art.PortId,
  val ct_Id : Art.PortId,
  val lrl_Id : Art.PortId,
  val url_Id : Art.PortId,
  val msr_Id : Art.PortId,
  val av_Id : Art.PortId,
  val min_av_Id : Art.PortId,
  val drs_Id : Art.PortId,
  val urs_Id : Art.PortId,
  val fb_time_Id : Art.PortId,
  val hy_Id : Art.PortId,
  val cci_Id : Art.PortId) extends RateController_normal_Api {

  // Logika spec var representing port state for incoming data port
  @spec var xl: PACE_Data.milliG = $

  def get_xl() : Option[PACE_Data.milliG] = {
    Contract(
      Ensures(
        Res == Some(xl)
      )
    )
    val value : Option[PACE_Data.milliG] = Art.getValue(xl_Id) match {
      case Some(PACE_Data.milliG_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port xl.  Expecting 'PACE_Data.milliG_Payload' but received ${v}")
        None[PACE_Data.milliG]()
      case _ => None[PACE_Data.milliG]()
    }
    return value
  }

  // Logika spec var representing port state for incoming data port
  @spec var mag: BLESS_Types.flag = $

  def get_mag() : Option[BLESS_Types.flag] = {
    Contract(
      Ensures(
        Res == Some(mag)
      )
    )
    val value : Option[BLESS_Types.flag] = Art.getValue(mag_Id) match {
      case Some(BLESS_Types.flag_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port mag.  Expecting 'BLESS_Types.flag_Payload' but received ${v}")
        None[BLESS_Types.flag]()
      case _ => None[BLESS_Types.flag]()
    }
    return value
  }

  // Logika spec var representing port state for incoming data port
  @spec var last_v_was_vs: BLESS_Types.flag = $

  def get_last_v_was_vs() : Option[BLESS_Types.flag] = {
    Contract(
      Ensures(
        Res == Some(last_v_was_vs)
      )
    )
    val value : Option[BLESS_Types.flag] = Art.getValue(last_v_was_vs_Id) match {
      case Some(BLESS_Types.flag_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port last_v_was_vs.  Expecting 'BLESS_Types.flag_Payload' but received ${v}")
        None[BLESS_Types.flag]()
      case _ => None[BLESS_Types.flag]()
    }
    return value
  }

  // Logika spec var representing port state for incoming data port
  @spec var rr: BLESS_Types.flag = $

  def get_rr() : Option[BLESS_Types.flag] = {
    Contract(
      Ensures(
        Res == Some(rr)
      )
    )
    val value : Option[BLESS_Types.flag] = Art.getValue(rr_Id) match {
      case Some(BLESS_Types.flag_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port rr.  Expecting 'BLESS_Types.flag_Payload' but received ${v}")
        None[BLESS_Types.flag]()
      case _ => None[BLESS_Types.flag]()
    }
    return value
  }

  // Logika spec var representing port state for incoming data port
  @spec var rf: PACE_Data.rf = $

  def get_rf() : Option[PACE_Data.rf] = {
    Contract(
      Ensures(
        Res == Some(rf)
      )
    )
    val value : Option[PACE_Data.rf] = Art.getValue(rf_Id) match {
      case Some(PACE_Data.rf_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port rf.  Expecting 'PACE_Data.rf_Payload' but received ${v}")
        None[PACE_Data.rf]()
      case _ => None[PACE_Data.rf]()
    }
    return value
  }

  // Logika spec var representing port state for incoming data port
  @spec var rt: PACE_Data.second = $

  def get_rt() : Option[PACE_Data.second] = {
    Contract(
      Ensures(
        Res == Some(rt)
      )
    )
    val value : Option[PACE_Data.second] = Art.getValue(rt_Id) match {
      case Some(PACE_Data.second_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port rt.  Expecting 'PACE_Data.second_Payload' but received ${v}")
        None[PACE_Data.second]()
      case _ => None[PACE_Data.second]()
    }
    return value
  }

  // Logika spec var representing port state for incoming data port
  @spec var at: PACE_Data.milliG = $

  def get_at() : Option[PACE_Data.milliG] = {
    Contract(
      Ensures(
        Res == Some(at)
      )
    )
    val value : Option[PACE_Data.milliG] = Art.getValue(at_Id) match {
      case Some(PACE_Data.milliG_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port at.  Expecting 'PACE_Data.milliG_Payload' but received ${v}")
        None[PACE_Data.milliG]()
      case _ => None[PACE_Data.milliG]()
    }
    return value
  }

  // Logika spec var representing port state for incoming data port
  @spec var ct: PACE_Data.second = $

  def get_ct() : Option[PACE_Data.second] = {
    Contract(
      Ensures(
        Res == Some(ct)
      )
    )
    val value : Option[PACE_Data.second] = Art.getValue(ct_Id) match {
      case Some(PACE_Data.second_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port ct.  Expecting 'PACE_Data.second_Payload' but received ${v}")
        None[PACE_Data.second]()
      case _ => None[PACE_Data.second]()
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
  @spec var msr: PACE_Data.ms = $

  def get_msr() : Option[PACE_Data.ms] = {
    Contract(
      Ensures(
        Res == Some(msr)
      )
    )
    val value : Option[PACE_Data.ms] = Art.getValue(msr_Id) match {
      case Some(PACE_Data.ms_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port msr.  Expecting 'PACE_Data.ms_Payload' but received ${v}")
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
  @spec var drs: PACE_Data.percent = $

  def get_drs() : Option[PACE_Data.percent] = {
    Contract(
      Ensures(
        Res == Some(drs)
      )
    )
    val value : Option[PACE_Data.percent] = Art.getValue(drs_Id) match {
      case Some(PACE_Data.percent_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port drs.  Expecting 'PACE_Data.percent_Payload' but received ${v}")
        None[PACE_Data.percent]()
      case _ => None[PACE_Data.percent]()
    }
    return value
  }

  // Logika spec var representing port state for incoming data port
  @spec var urs: PACE_Data.percent = $

  def get_urs() : Option[PACE_Data.percent] = {
    Contract(
      Ensures(
        Res == Some(urs)
      )
    )
    val value : Option[PACE_Data.percent] = Art.getValue(urs_Id) match {
      case Some(PACE_Data.percent_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port urs.  Expecting 'PACE_Data.percent_Payload' but received ${v}")
        None[PACE_Data.percent]()
      case _ => None[PACE_Data.percent]()
    }
    return value
  }

  // Logika spec var representing port state for incoming data port
  @spec var fb_time: PACE_Data.second = $

  def get_fb_time() : Option[PACE_Data.second] = {
    Contract(
      Ensures(
        Res == Some(fb_time)
      )
    )
    val value : Option[PACE_Data.second] = Art.getValue(fb_time_Id) match {
      case Some(PACE_Data.second_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port fb_time.  Expecting 'PACE_Data.second_Payload' but received ${v}")
        None[PACE_Data.second]()
      case _ => None[PACE_Data.second]()
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

  // Logika spec var representing port state for incoming event data port
  @spec var cci: Option[PACE_Data.ms] = $

  def get_cci() : Option[PACE_Data.ms] = {
    Contract(
      Ensures(
        Res == cci
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
}
