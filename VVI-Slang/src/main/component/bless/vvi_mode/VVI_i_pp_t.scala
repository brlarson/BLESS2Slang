// #Sireum

// generated by BLESS v3.2.4 at Wed Mar 20 20:11:31 EDT 2024 from vvi_mode::VVI.i

package bless.vvi_mode

import org.sireum._
import org.sireum.S64._  //type for native time (in ms) and integers
import org.sireum.F64._  //type for quantities
import art.Art           // for .time() timestamp
import bless._
// import types created for data components
import bless.vvi_mode.CardiacDuration

object VVI_i_pp_t 
  {
  @enum object CompleteStates 
    {
    "power_on_state" //initial state
    "pace_state" 
    "sense_state" 
    }
  //  execution states: check_pace_vrp_state check_sense_vrp_state
  //  final states: off_state

  var currentState: CompleteStates.Type = CompleteStates.power_on_state

  var last_beat: F64 = f64"0.5"
  var timeout_id : Art.PortId = Art.PortId.fromZ(Art.numPorts - 3)
  val timeout_n_p_lrl_Id : Art.PortId = timeout_id+Art.PortId.fromZ(1)
  var dispatch_status: Set[art.Art.PortId] = Set.empty  //local copy of Dispatch_Status

  def Initialize_Entrypoint(api: VVI_i_Initialization_Api): Unit = 
    {
    api.logDebug("executing Initialize_Entrypoint of VVI_i_pp_t")
    if ( true )
      { do_T1_POWER_ON_power_on(api) }
    }  //end of Initialize_Entrypoint

  def Compute_Entrypoint(api: VVI_i_Operational_Api, Dispatch_Status: Set[art.Art.PortId]): B = 
    {
    dispatch_status = Dispatch_Status  // save local copy of dispatch status
    api.logDebug("executing Compute_Entrypoint of VVI_i_pp_t")
    api.logDebug(s"Dispatch_Status = ${dispatch_status.elements}")
    api.logDebug(s"current complete state = ${currentState}")
    var retval : B = F
    currentState match
      {
      case VVI_i_pp_t.CompleteStates.power_on_state =>
        if ( true )
          { //initial state case needed for complete match
            retval = T }
      case VVI_i_pp_t.CompleteStates.pace_state =>
        if ( dispatch_status.contains(api.h_Id) )
          { do_T2_STOP_pace_pace(api)
            retval = T }
        if ( dispatch_status.contains(timeout_n_p_lrl_Id) )
          { do_T3_PACE_LRL_AFTER_VP_pace(api)
            retval = T }
        if ( dispatch_status.contains(api.s_Id) )
          { do_T4_VS_AFTER_VP_pace(api)
            retval = T }
      case VVI_i_pp_t.CompleteStates.sense_state =>
        if ( dispatch_status.contains(api.h_Id) )
          { do_T2_STOP_sense_sense(api)
            retval = T }
        if ( dispatch_status.contains(timeout_n_p_lrl_Id) )
          { do_T7_PACE_LRL_AFTER_VS_sense(api)
            retval = T }
        if ( dispatch_status.contains(api.s_Id) )
          { do_T8_VS_AFTER_VS_sense(api)
            retval = T }
      }
    //  set durations of timeouts in Bridge
    VVI_i_pp_t_Bridge.timeout_n_p_lrl_Duration = bless.util.BlessConversion.floatSecondToS64millisecond(api.get_lrl().get.ms)
    return retval
    }  //end of Compute_Entrypoint

  def Finalize_Entrypoint(api: VVI_i_Operational_Api): Unit = 
    {
    }  //end of Finalize_Entrypoint

  // methods for transitions leaving initial state  
  def do_T1_POWER_ON_power_on(api: VVI_i_Initialization_Api): Unit = 
    {
    api.logDebug("executing T1_POWER_ON")

    api.put_n()
    last_beat = bless.util.BlessConversion.s64millisecondToFloatSecond(Art.time())
    //set currentState to destination complete state sense
    currentState = VVI_i_pp_t.CompleteStates.sense_state
    }  //end of do_T1_POWER_ON_power_on

  // methods for transitions leaving complete states  
  def do_T2_STOP_pace_pace(api: VVI_i_Operational_Api): Unit = 
    {
    api.logDebug("executing T2_STOP_pace")

    //no action
    //the destination is final state off
    Finalize_Entrypoint(api)
    }  //end of do_T2_STOP_pace_pace

  def do_T3_PACE_LRL_AFTER_VP_pace(api: VVI_i_Operational_Api): Unit = 
    {
    api.logDebug("executing T3_PACE_LRL_AFTER_VP")

    api.put_p()
    last_beat = bless.util.BlessConversion.s64millisecondToFloatSecond(Art.time())
    //set currentState to destination complete state pace
    currentState = VVI_i_pp_t.CompleteStates.pace_state
    }  //end of do_T3_PACE_LRL_AFTER_VP_pace

  def do_T4_VS_AFTER_VP_pace(api: VVI_i_Operational_Api): Unit = 
    {
    api.logDebug("executing T4_VS_AFTER_VP")

    //no action
    //the destination is execution state check_pace_vrp
    executionState_check_pace_vrp(api)
    }  //end of do_T4_VS_AFTER_VP_pace

  def do_T2_STOP_sense_sense(api: VVI_i_Operational_Api): Unit = 
    {
    api.logDebug("executing T2_STOP_sense")

    //no action
    //the destination is final state off
    Finalize_Entrypoint(api)
    }  //end of do_T2_STOP_sense_sense

  def do_T7_PACE_LRL_AFTER_VS_sense(api: VVI_i_Operational_Api): Unit = 
    {
    api.logDebug("executing T7_PACE_LRL_AFTER_VS")

    api.put_p()
    last_beat = bless.util.BlessConversion.s64millisecondToFloatSecond(Art.time())
    //set currentState to destination complete state pace
    currentState = VVI_i_pp_t.CompleteStates.pace_state
    }  //end of do_T7_PACE_LRL_AFTER_VS_sense

  def do_T8_VS_AFTER_VS_sense(api: VVI_i_Operational_Api): Unit = 
    {
    api.logDebug("executing T8_VS_AFTER_VS")

    //no action
    //the destination is execution state check_sense_vrp
    executionState_check_sense_vrp(api)
    }  //end of do_T8_VS_AFTER_VS_sense

  // methods for execution states
  def executionState_check_pace_vrp(api: VVI_i_Operational_Api): Unit = 
    {
    if ( (bless.util.BlessConversion.s64millisecondToFloatSecond(Art.time())-
    last_beat < api.get_vrp().get.ms) )
      { do_T5_VS_AFTER_VP_IN_VRP_check_pace_vrp(api) }
    else if ( (bless.util.BlessConversion.s64millisecondToFloatSecond(Art.time())-
    last_beat >= api.get_vrp().get.ms) )
      { do_T6_VS_AFTER_VP_IS_NR_check_pace_vrp(api) }
    }  //end of executionState_check_pace_vrp

  def do_T5_VS_AFTER_VP_IN_VRP_check_pace_vrp(api: VVI_i_Operational_Api): Unit = 
    {
    api.logDebug("executing do_T5_VS_AFTER_VP_IN_VRP_check_pace_vrp")

    currentState = VVI_i_pp_t.CompleteStates.pace_state  //destination is complete state pace
    }  //end of do_T5_VS_AFTER_VP_IN_VRP_check_pace_vrp

  def do_T6_VS_AFTER_VP_IS_NR_check_pace_vrp(api: VVI_i_Operational_Api): Unit = 
    {
    api.logDebug("executing do_T6_VS_AFTER_VP_IS_NR_check_pace_vrp")

    api.put_n()
    last_beat = bless.util.BlessConversion.s64millisecondToFloatSecond(Art.time())
    currentState = VVI_i_pp_t.CompleteStates.sense_state  //destination is complete state sense
    }  //end of do_T6_VS_AFTER_VP_IS_NR_check_pace_vrp

  def executionState_check_sense_vrp(api: VVI_i_Operational_Api): Unit = 
    {
    if ( (bless.util.BlessConversion.s64millisecondToFloatSecond(Art.time())-
    last_beat < api.get_vrp().get.ms) )
      { do_T9_VS_AFTER_VS_IN_VRP_check_sense_vrp(api) }
    else if ( (bless.util.BlessConversion.s64millisecondToFloatSecond(Art.time())-
    last_beat >= api.get_vrp().get.ms) )
      { do_T10_VS_AFTER_VS_IS_NR_check_sense_vrp(api) }
    }  //end of executionState_check_sense_vrp

  def do_T9_VS_AFTER_VS_IN_VRP_check_sense_vrp(api: VVI_i_Operational_Api): Unit = 
    {
    api.logDebug("executing do_T9_VS_AFTER_VS_IN_VRP_check_sense_vrp")

    currentState = VVI_i_pp_t.CompleteStates.sense_state  //destination is complete state sense
    }  //end of do_T9_VS_AFTER_VS_IN_VRP_check_sense_vrp

  def do_T10_VS_AFTER_VS_IS_NR_check_sense_vrp(api: VVI_i_Operational_Api): Unit = 
    {
    api.logDebug("executing do_T10_VS_AFTER_VS_IS_NR_check_sense_vrp")

    api.put_n()
    last_beat = bless.util.BlessConversion.s64millisecondToFloatSecond(Art.time())
    currentState = VVI_i_pp_t.CompleteStates.sense_state  //destination is complete state sense
    }  //end of do_T10_VS_AFTER_VS_IS_NR_check_sense_vrp

  def contains(isz : ISZ[Art.PortId], elt : Art.PortId) : B =
    { for ( i <- isz )
      { if (i == elt) { return T } }
    return F
    }
  }

