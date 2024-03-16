// #Sireum 
   // generated by BLESS v3.2.1 at Tue Nov 14 03:54:35 CST 2023 from ["PACE_Data", "Rx"]

package bless.PACE_Data

import org.sireum._
import bless._
import org.sireum.S64._
import org.sireum.F64._
import art.Art

// This file will not be overwritten so is safe to edit

// This is a type skeleton as HAMR doesn't know how to translate PACE_Data::Rx

object Rx {
  def example(): PACE_Data.Rx =
    { return PACE_Data.Rx(lrl_label = ms.example(),
  url_label = ms.example(),
  av_label = ms.example(),
  savo_label = ms.example(),
  act_label = milliG.example(),
  vrp_label = ms.example(),
  arp_label = ms.example(),
  pvarp_label = ms.example(),
  pv_label = F,
  sv_label = F,
  pa_label = F,
  sa_label = F,
  inhibit_label = F,
  track_label = F,
  hy_label = ms.example(),
  rr_label = F,
  rf_label = rf.example(),
  msr_label = ms.example(),
  min_av_label = ms.example(),
  ex_pvarp_label = ms.example(),
  rt_label = second.example(),
  ct_label = second.example(),
  at_label = milliG.example(),
  atr_enable_label = F,
  atr_duration_label = s64"3",
  fb_time_label = second.example(),
  drs_label = f64"0.4",
  urs_label = f64"0.5") }
}

@datatype class Rx(
  lrl_label : ms,
  url_label : ms,
  av_label : ms,
  savo_label : ms,
  act_label : milliG,
  vrp_label : ms,
  arp_label : ms,
  pvarp_label : ms,
  pv_label : B,
  sv_label : B,
  pa_label : B,
  sa_label : B,
  inhibit_label : B,
  track_label : B,
  hy_label : ms,
  rr_label : B,
  rf_label : rf,
  msr_label : ms,
  min_av_label : ms,
  ex_pvarp_label : ms,
  rt_label : second,
  ct_label : second,
  at_label : milliG,
  atr_enable_label : B,
  atr_duration_label : S64,
  fb_time_label : second,
  drs_label : F64,
  urs_label : F64) {
}

object Rx_Payload {
  def example(): Rx_Payload = {
    return Rx_Payload(PACE_Data.Rx.example())
  }
}

@datatype class Rx_Payload(value: PACE_Data.Rx) extends art.DataContent
