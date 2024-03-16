// #Sireum

// generated by BLESS v3.2.1 at Tue Nov 14 03:54:35 CST 2023 from sw::pacer.imp

package bless.sw

import org.sireum._
import org.sireum.S64._  //type for native time (in ms) and integers
import org.sireum.F64._  //type for quantities
import art.Art           // for .time() timestamp
import bless._
// import types created for data components
import bless.PACE_Data.rf
import bless.PACE_Data.percent
import bless.PACE_Data.Rx
import bless.mark.AtrialMarker
import bless.PACE_Data.ms
import bless.mark.ExtraordinaryMarker
import bless.PACE_Data.CCcount
import bless.PACE_Data.milliG
import bless.PACE_Data.second
import bless.BLESS_Types.flag
import bless.mark.VentricularlMarker

object pacer_imp_pgp_ddd 
  {
  @enum object CompleteStates 
    {
    "go_state" //initial state
    "pav_state" 
    "sav_state" 
    "va_state" 
    }
  //  execution states: pav_check_vrp_state sav_check_vrp_state check_atrial_refractories_state check_vrp_state sav_check_url_state
  //  final states: off_state

  var currentState: CompleteStates.Type = CompleteStates.go_state

  var last_vp_or_vs: F64 = f64"0.0"
  var last_ap_or_as: F64 = f64"0.0"
  var lastVwasVS: B = F
  var va_interval: F64 = f64"1000"-f64"150"
  var dav_savo: F64 = f64"150"-f64"20"
  var max_CCI: F64 = f64"1000"
  var timeout_id : Art.PortId = Art.PortId.fromZ(Art.numPorts - 4)
  val timeout_as_dav_savo_Id : Art.PortId = timeout_id+Art.PortId.fromZ(1)
  val timeout_vp_vs_va_interval_Id : Art.PortId = timeout_id+Art.PortId.fromZ(2)
  val timeout_vp_vs_max_CCI_Id : Art.PortId = timeout_id+Art.PortId.fromZ(3)
  var dispatch_status: Set[art.Art.PortId] = Set.empty  //local copy of Dispatch_Status

  def Initialize_Entrypoint(api: pacer_imp_Initialization_Api): Unit = 
    {
    api.logDebug("executing Initialize_Entrypoint of pacer_imp_pgp_ddd")
    if ( true )
      { do_T0_GO_go(api) }
    //  set durations of timeouts in Bridge
    pacer_imp_pgp_ddd_Bridge.timeout_as_dav_savo_Duration = bless.util.BlessConversion.floatSecondToS64millisecond(dav_savo)
    pacer_imp_pgp_ddd_Bridge.timeout_vp_vs_va_interval_Duration = bless.util.BlessConversion.floatSecondToS64millisecond(va_interval)
    pacer_imp_pgp_ddd_Bridge.timeout_vp_vs_max_CCI_Duration = bless.util.BlessConversion.floatSecondToS64millisecond(max_CCI)
    }  //end of Initialize_Entrypoint

  def Compute_Entrypoint(api: pacer_imp_Operational_Api, Dispatch_Status: Set[art.Art.PortId]): B = 
    {
    dispatch_status = Dispatch_Status  // save local copy of dispatch status
    api.logDebug("executing Compute_Entrypoint of pacer_imp_pgp_ddd")
    api.logDebug(s"Dispatch_Status = ${dispatch_status.elements}")
    api.logDebug(s"current complete state = ${currentState}")
    var retval : B = F
    currentState match
      {
      case pacer_imp_pgp_ddd.CompleteStates.go_state =>
        if ( true )
          { //initial state case needed for complete match
            retval = T }
      case pacer_imp_pgp_ddd.CompleteStates.pav_state =>
        if ( dispatch_status.contains(timeout_vp_vs_max_CCI_Id) )
          { do_T1_PACE_AFTER_LRL_pav(api)
            retval = T }
        if ( dispatch_status.contains(api.v_Id) )
          { do_T9_VS_AFTER_AP_pav(api)
            retval = T }
      case pacer_imp_pgp_ddd.CompleteStates.sav_state =>
        if ( dispatch_status.contains(timeout_vp_vs_max_CCI_Id) )
          { do_T1_PACE_AFTER_LRL_sav(api)
            retval = T }
        if ( dispatch_status.contains(api.v_Id) )
          { do_T2_VS_AFTER_AS_sav(api)
            retval = T }
        if ( dispatch_status.contains(timeout_as_dav_savo_Id) )
          { do_T6_EXPIRED_SENSED_AV_DELAY_sav(api)
            retval = T }
      case pacer_imp_pgp_ddd.CompleteStates.va_state =>
        if ( dispatch_status.contains(timeout_vp_vs_max_CCI_Id) )
          { do_T1_PACE_AFTER_LRL_va(api)
            retval = T }
        if ( dispatch_status.contains(api.a_Id) )
          { do_T12_AS_AFTER_VS_OR_VP_va(api)
            retval = T }
        if ( dispatch_status.contains(api.v_Id) )
          { do_T16_VS_AFTER_VS_OR_VP_va(api)
            retval = T }
        if ( dispatch_status.contains(timeout_vp_vs_va_interval_Id) )
          { do_T19_AP_AFTER_TIMEOUT_VS_OR_VP_va(api)
            retval = T }
      }
    pacer_imp_pgp_ddd_Bridge.timeout_as_dav_savo_Duration = bless.util.BlessConversion.floatSecondToS64millisecond(dav_savo)
    pacer_imp_pgp_ddd_Bridge.timeout_vp_vs_va_interval_Duration = bless.util.BlessConversion.floatSecondToS64millisecond(va_interval)
    pacer_imp_pgp_ddd_Bridge.timeout_vp_vs_max_CCI_Duration = bless.util.BlessConversion.floatSecondToS64millisecond(max_CCI)
    return retval
    }  //end of Compute_Entrypoint

  def Finalize_Entrypoint(api: pacer_imp_Operational_Api): Unit = 
    {
    }  //end of Finalize_Entrypoint

  // methods for transitions leaving initial state  
  def do_T0_GO_go(api: pacer_imp_Initialization_Api): Unit = 
    {
    api.logDebug("executing T0_GO")

      {
      api.put_vs()
      api.put_cci(ms(f64"1000"))
      last_vp_or_vs = bless.util.BlessConversion.s64millisecondToFloatSecond(Art.time())
      api.put_as()
      api.put_last_v_was_vs(flag(T))
      // simultaneous assignment
      last_ap_or_as = bless.util.BlessConversion.s64millisecondToFloatSecond(Art.time())
      dav_savo = f64"150"-f64"20"
      va_interval = f64"1000"-f64"150"
      }
    //set currentState to destination complete state va
    currentState = pacer_imp_pgp_ddd.CompleteStates.va_state
    }  //end of do_T0_GO_go

  // methods for transitions leaving complete states  
  def do_T1_PACE_AFTER_LRL_pav(api: pacer_imp_Operational_Api): Unit = 
    {
    api.logDebug("executing T1_PACE_AFTER_LRL")

    api.put_vp()
    api.put_cci(ms(bless.util.BlessConversion.s64millisecondToFloatSecond(Art.time())-
    last_vp_or_vs))
    // simultaneous assignment
    last_vp_or_vs = bless.util.BlessConversion.s64millisecondToFloatSecond(Art.time())
    dav_savo = api.get_dav().get.ms-api.get_savo().get.ms
    va_interval = f64"1000"-api.get_dav().get.ms
    max_CCI = api.get_max_cci().get.ms
    //set currentState to destination complete state va
    currentState = pacer_imp_pgp_ddd.CompleteStates.va_state
    }  //end of do_T1_PACE_AFTER_LRL_pav

  def do_T9_VS_AFTER_AP_pav(api: pacer_imp_Operational_Api): Unit = 
    {
    api.logDebug("executing T9_VS_AFTER_AP")

    //no action
    //the destination is execution state pav_check_vrp
    executionState_pav_check_vrp(api)
    }  //end of do_T9_VS_AFTER_AP_pav

  def do_T1_PACE_AFTER_LRL_sav(api: pacer_imp_Operational_Api): Unit = 
    {
    api.logDebug("executing T1_PACE_AFTER_LRL")

    api.put_vp()
    api.put_cci(ms(bless.util.BlessConversion.s64millisecondToFloatSecond(Art.time())-
    last_vp_or_vs))
    // simultaneous assignment
    last_vp_or_vs = bless.util.BlessConversion.s64millisecondToFloatSecond(Art.time())
    dav_savo = api.get_dav().get.ms-api.get_savo().get.ms
    va_interval = f64"1000"-api.get_dav().get.ms
    max_CCI = api.get_max_cci().get.ms
    //set currentState to destination complete state va
    currentState = pacer_imp_pgp_ddd.CompleteStates.va_state
    }  //end of do_T1_PACE_AFTER_LRL_sav

  def do_T2_VS_AFTER_AS_sav(api: pacer_imp_Operational_Api): Unit = 
    {
    api.logDebug("executing T2_VS_AFTER_AS")

    //no action
    //the destination is execution state sav_check_vrp
    executionState_sav_check_vrp(api)
    }  //end of do_T2_VS_AFTER_AS_sav

  def do_T6_EXPIRED_SENSED_AV_DELAY_sav(api: pacer_imp_Operational_Api): Unit = 
    {
    api.logDebug("executing T6_EXPIRED_SENSED_AV_DELAY")

    //no action
    //the destination is execution state sav_check_url
    executionState_sav_check_url(api)
    }  //end of do_T6_EXPIRED_SENSED_AV_DELAY_sav

  def do_T1_PACE_AFTER_LRL_va(api: pacer_imp_Operational_Api): Unit = 
    {
    api.logDebug("executing T1_PACE_AFTER_LRL")

    api.put_vp()
    api.put_cci(ms(bless.util.BlessConversion.s64millisecondToFloatSecond(Art.time())-
    last_vp_or_vs))
    // simultaneous assignment
    last_vp_or_vs = bless.util.BlessConversion.s64millisecondToFloatSecond(Art.time())
    dav_savo = api.get_dav().get.ms-api.get_savo().get.ms
    va_interval = f64"1000"-api.get_dav().get.ms
    max_CCI = api.get_max_cci().get.ms
    //set currentState to destination complete state va
    currentState = pacer_imp_pgp_ddd.CompleteStates.va_state
    }  //end of do_T1_PACE_AFTER_LRL_va

  def do_T12_AS_AFTER_VS_OR_VP_va(api: pacer_imp_Operational_Api): Unit = 
    {
    api.logDebug("executing T12_AS_AFTER_VS_OR_VP")

    //no action
    //the destination is execution state check_atrial_refractories
    executionState_check_atrial_refractories(api)
    }  //end of do_T12_AS_AFTER_VS_OR_VP_va

  def do_T16_VS_AFTER_VS_OR_VP_va(api: pacer_imp_Operational_Api): Unit = 
    {
    api.logDebug("executing T16_VS_AFTER_VS_OR_VP")

    //no action
    //the destination is execution state check_vrp
    executionState_check_vrp(api)
    }  //end of do_T16_VS_AFTER_VS_OR_VP_va

  def do_T19_AP_AFTER_TIMEOUT_VS_OR_VP_va(api: pacer_imp_Operational_Api): Unit = 
    {
    api.logDebug("executing T19_AP_AFTER_TIMEOUT_VS_OR_VP")

      {
      api.put_ap()
      // simultaneous assignment
      last_ap_or_as = bless.util.BlessConversion.s64millisecondToFloatSecond(Art.time())
      dav_savo = api.get_dav().get.ms-api.get_savo().get.ms
      va_interval = f64"1000"-api.get_dav().get.ms
      }
    //set currentState to destination complete state pav
    currentState = pacer_imp_pgp_ddd.CompleteStates.pav_state
    }  //end of do_T19_AP_AFTER_TIMEOUT_VS_OR_VP_va

  // methods for execution states
  def executionState_pav_check_vrp(api: pacer_imp_Operational_Api): Unit = 
    {
    if ( ! (api.get_sv().get.value) | api.get_tnv().get.value | ((api.get_vrp().get.ms > (
    bless.util.BlessConversion.s64millisecondToFloatSecond(Art.time())-last_vp_or_vs))) )
      { do_T10_VS_AFTER_AP_IN_VRP_pav_check_vrp(api) }
    else if ( api.get_sv().get.value & ! api.get_tnv().get.value & ((api.get_vrp().get.ms <= (
    bless.util.BlessConversion.s64millisecondToFloatSecond(Art.time())-last_vp_or_vs))) )
      { do_T11_VS_AFTER_AP_AFTER_VRP_pav_check_vrp(api) }
    }  //end of executionState_pav_check_vrp

  def do_T10_VS_AFTER_AP_IN_VRP_pav_check_vrp(api: pacer_imp_Operational_Api): Unit = 
    {
    api.logDebug("executing do_T10_VS_AFTER_AP_IN_VRP_pav_check_vrp")

    currentState = pacer_imp_pgp_ddd.CompleteStates.pav_state  //destination is complete state pav
    }  //end of do_T10_VS_AFTER_AP_IN_VRP_pav_check_vrp

  def do_T11_VS_AFTER_AP_AFTER_VRP_pav_check_vrp(api: pacer_imp_Operational_Api): Unit = 
    {
    api.logDebug("executing do_T11_VS_AFTER_AP_AFTER_VRP_pav_check_vrp")

      {
      api.put_vs()
      api.put_cci(ms(bless.util.BlessConversion.s64millisecondToFloatSecond(Art.time())-
      last_vp_or_vs))
      // simultaneous assignment
      last_vp_or_vs = bless.util.BlessConversion.s64millisecondToFloatSecond(Art.time())
      dav_savo = api.get_dav().get.ms-api.get_savo().get.ms
      va_interval = f64"1000"-api.get_dav().get.ms
      max_CCI = api.get_max_cci().get.ms
      }
    currentState = pacer_imp_pgp_ddd.CompleteStates.va_state  //destination is complete state va
    }  //end of do_T11_VS_AFTER_AP_AFTER_VRP_pav_check_vrp

  def executionState_sav_check_vrp(api: pacer_imp_Operational_Api): Unit = 
    {
    if ( ! api.get_sv().get.value | api.get_tnv().get.value | ((api.get_vrp().get.ms > (
    bless.util.BlessConversion.s64millisecondToFloatSecond(Art.time())-last_vp_or_vs))) )
      { do_T4_VS_AFTER_AS_IN_VRP_sav_check_vrp(api) }
    else if ( api.get_sv().get.value & ! api.get_tnv().get.value & ((api.get_vrp().get.ms <= (
    bless.util.BlessConversion.s64millisecondToFloatSecond(Art.time())-last_vp_or_vs))) )
      { do_T5_VS_AFTER_AS_AFTER_VRP_sav_check_vrp(api) }
    }  //end of executionState_sav_check_vrp

  def do_T4_VS_AFTER_AS_IN_VRP_sav_check_vrp(api: pacer_imp_Operational_Api): Unit = 
    {
    api.logDebug("executing do_T4_VS_AFTER_AS_IN_VRP_sav_check_vrp")

    currentState = pacer_imp_pgp_ddd.CompleteStates.sav_state  //destination is complete state sav
    }  //end of do_T4_VS_AFTER_AS_IN_VRP_sav_check_vrp

  def do_T5_VS_AFTER_AS_AFTER_VRP_sav_check_vrp(api: pacer_imp_Operational_Api): Unit = 
    {
    api.logDebug("executing do_T5_VS_AFTER_AS_AFTER_VRP_sav_check_vrp")

    api.put_vs()
    api.put_cci(ms(bless.util.BlessConversion.s64millisecondToFloatSecond(Art.time())-
    last_vp_or_vs))
    // simultaneous assignment
    last_vp_or_vs = bless.util.BlessConversion.s64millisecondToFloatSecond(Art.time())
    dav_savo = api.get_dav().get.ms-api.get_savo().get.ms
    va_interval = f64"1000"-api.get_dav().get.ms
    max_CCI = api.get_max_cci().get.ms
    currentState = pacer_imp_pgp_ddd.CompleteStates.va_state  //destination is complete state va
    }  //end of do_T5_VS_AFTER_AS_AFTER_VRP_sav_check_vrp

  def executionState_check_atrial_refractories(api: pacer_imp_Operational_Api): Unit = 
    {
    if ( api.get_sa().get.value & ! api.get_tna().get.value & ! api.get_fb().get.value & 
    ((api.get_pvarp().get.ms <= (bless.util.BlessConversion.s64millisecondToFloatSecond(Art.time())-
    last_vp_or_vs))) & ((api.get_arp().get.ms <= (bless.util.BlessConversion.s64millisecondToFloatSecond(Art.time())-
    last_ap_or_as))) & (((api.get_dav().get.ms+api.get_savo().get.ms) <= (
    bless.util.BlessConversion.s64millisecondToFloatSecond(Art.time())-last_ap_or_as))) & 
    ((api.get_dav().get.ms <= (bless.util.BlessConversion.s64millisecondToFloatSecond(Art.time())-
    last_ap_or_as))) & ((api.get_url().get.ms <= (bless.util.BlessConversion.s64millisecondToFloatSecond(Art.time())-
    last_ap_or_as))) )
      { do_T13_AS_check_atrial_refractories(api) }
    else if ( api.get_sa().get.value & ! api.get_tna().get.value & ! api.get_fb().get.value & 
    ((api.get_pvarp().get.ms <= (bless.util.BlessConversion.s64millisecondToFloatSecond(Art.time())-
    last_vp_or_vs))) & ((api.get_arp().get.ms <= (bless.util.BlessConversion.s64millisecondToFloatSecond(Art.time())-
    last_ap_or_as))) & (((api.get_dav().get.ms+api.get_savo().get.ms) <= (
    bless.util.BlessConversion.s64millisecondToFloatSecond(Art.time())-last_ap_or_as))) & 
    ((api.get_dav().get.ms <= (bless.util.BlessConversion.s64millisecondToFloatSecond(Art.time())-
    last_ap_or_as))) & (((bless.util.BlessConversion.s64millisecondToFloatSecond(Art.time())-
    last_ap_or_as) < api.get_url().get.ms)) )
      { do_T14_AS_AT_check_atrial_refractories(api) }
    else if ( ! api.get_sa().get.value | api.get_tna().get.value | api.get_fb().get.value | 
    ((api.get_pvarp().get.ms > (bless.util.BlessConversion.s64millisecondToFloatSecond(Art.time())-
    last_vp_or_vs))) | ((api.get_arp().get.ms > (bless.util.BlessConversion.s64millisecondToFloatSecond(Art.time())-
    last_ap_or_as))) | (((api.get_dav().get.ms+api.get_savo().get.ms) > (
    bless.util.BlessConversion.s64millisecondToFloatSecond(Art.time())-last_ap_or_as))) | 
    ((api.get_dav().get.ms > (bless.util.BlessConversion.s64millisecondToFloatSecond(Art.time())-
    last_ap_or_as))) )
      { do_T15_STILL_IN_PVARP_check_atrial_refractories(api) }
    }  //end of executionState_check_atrial_refractories

  def do_T13_AS_check_atrial_refractories(api: pacer_imp_Operational_Api): Unit = 
    {
    api.logDebug("executing do_T13_AS_check_atrial_refractories")

    api.put_as()
    // simultaneous assignment
    last_ap_or_as = bless.util.BlessConversion.s64millisecondToFloatSecond(Art.time())
    dav_savo = api.get_dav().get.ms-api.get_savo().get.ms
    va_interval = f64"1000"-api.get_dav().get.ms
    currentState = pacer_imp_pgp_ddd.CompleteStates.sav_state  //destination is complete state sav
    }  //end of do_T13_AS_check_atrial_refractories

  def do_T14_AS_AT_check_atrial_refractories(api: pacer_imp_Operational_Api): Unit = 
    {
    api.logDebug("executing do_T14_AS_AT_check_atrial_refractories")

    api.put_as()
    api.put_at()
    // simultaneous assignment
    last_ap_or_as = bless.util.BlessConversion.s64millisecondToFloatSecond(Art.time())
    dav_savo = api.get_dav().get.ms-api.get_savo().get.ms
    va_interval = f64"1000"-api.get_dav().get.ms
    currentState = pacer_imp_pgp_ddd.CompleteStates.sav_state  //destination is complete state sav
    }  //end of do_T14_AS_AT_check_atrial_refractories

  def do_T15_STILL_IN_PVARP_check_atrial_refractories(api: pacer_imp_Operational_Api): Unit = 
    {
    api.logDebug("executing do_T15_STILL_IN_PVARP_check_atrial_refractories")

    currentState = pacer_imp_pgp_ddd.CompleteStates.va_state  //destination is complete state va
    }  //end of do_T15_STILL_IN_PVARP_check_atrial_refractories

  def executionState_check_vrp(api: pacer_imp_Operational_Api): Unit = 
    {
    if ( api.get_tnv().get.value | ! api.get_sv().get.value | ((api.get_vrp().get.ms > (
    bless.util.BlessConversion.s64millisecondToFloatSecond(Art.time())-last_vp_or_vs))) )
      { do_T17_STILL_IN_VRP_check_vrp(api) }
    else if ( api.get_sv().get.value & ! api.get_tnv().get.value & ((api.get_vrp().get.ms <= (
    bless.util.BlessConversion.s64millisecondToFloatSecond(Art.time())-last_vp_or_vs))) )
      { do_T18_VRP_EXPIRED_check_vrp(api) }
    }  //end of executionState_check_vrp

  def do_T17_STILL_IN_VRP_check_vrp(api: pacer_imp_Operational_Api): Unit = 
    {
    api.logDebug("executing do_T17_STILL_IN_VRP_check_vrp")

    currentState = pacer_imp_pgp_ddd.CompleteStates.va_state  //destination is complete state va
    }  //end of do_T17_STILL_IN_VRP_check_vrp

  def do_T18_VRP_EXPIRED_check_vrp(api: pacer_imp_Operational_Api): Unit = 
    {
    api.logDebug("executing do_T18_VRP_EXPIRED_check_vrp")

    api.put_vs()
    api.put_cci(ms(bless.util.BlessConversion.s64millisecondToFloatSecond(Art.time())-
    last_vp_or_vs))
    // simultaneous assignment
    last_vp_or_vs = bless.util.BlessConversion.s64millisecondToFloatSecond(Art.time())
    dav_savo = api.get_dav().get.ms-api.get_savo().get.ms
    va_interval = f64"1000"-api.get_dav().get.ms
    currentState = pacer_imp_pgp_ddd.CompleteStates.va_state  //destination is complete state va
    }  //end of do_T18_VRP_EXPIRED_check_vrp

  def executionState_sav_check_url(api: pacer_imp_Operational_Api): Unit = 
    {
    if ( (last_vp_or_vs > (bless.util.BlessConversion.s64millisecondToFloatSecond(Art.time())-
    api.get_min_cci().get.ms)) )
      { do_T7_TRACKED_VP_TOO_SOON_AFTER_PREVIOUS_VS_OR_VP_sav_check_url(api) }
    else if ( (last_vp_or_vs <= (bless.util.BlessConversion.s64millisecondToFloatSecond(Art.time())-
    api.get_min_cci().get.ms)) )
      { do_T8_TRACKED_VP_AFTER_AS_sav_check_url(api) }
    }  //end of executionState_sav_check_url

  def do_T7_TRACKED_VP_TOO_SOON_AFTER_PREVIOUS_VS_OR_VP_sav_check_url(api: pacer_imp_Operational_Api): Unit = 
    {
    api.logDebug("executing do_T7_TRACKED_VP_TOO_SOON_AFTER_PREVIOUS_VS_OR_VP_sav_check_url")

    currentState = pacer_imp_pgp_ddd.CompleteStates.sav_state  //destination is complete state sav
    }  //end of do_T7_TRACKED_VP_TOO_SOON_AFTER_PREVIOUS_VS_OR_VP_sav_check_url

  def do_T8_TRACKED_VP_AFTER_AS_sav_check_url(api: pacer_imp_Operational_Api): Unit = 
    {
    api.logDebug("executing do_T8_TRACKED_VP_AFTER_AS_sav_check_url")

    api.put_vp()
    api.put_cci(ms(bless.util.BlessConversion.s64millisecondToFloatSecond(Art.time())-
    last_vp_or_vs))
    // simultaneous assignment
    last_vp_or_vs = bless.util.BlessConversion.s64millisecondToFloatSecond(Art.time())
    dav_savo = api.get_dav().get.ms-api.get_savo().get.ms
    va_interval = f64"1000"-api.get_dav().get.ms
    max_CCI = api.get_max_cci().get.ms
    currentState = pacer_imp_pgp_ddd.CompleteStates.va_state  //destination is complete state va
    }  //end of do_T8_TRACKED_VP_AFTER_AS_sav_check_url

  def contains(isz : ISZ[Art.PortId], elt : Art.PortId) : B =
    { for ( i <- isz )
      { if (i == elt) { return T } }
    return F
    }
  }
