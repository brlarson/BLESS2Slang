// #Sireum

package bless.vvi_mode

import org.sireum._
import art._
import bless._

// Do not edit this file as it will be overwritten if HAMR codegen is rerun

object RateControl_pp_rc_EntryPoint_Companion {

  var last_api_lrl: Option[vvi_mode.CardiacDuration] = None()

  /** get the value of outgoing data port lrl.  If a 'fresh' value wasn't sent
    * during the last dispatch then return last_api_lrl.get.
    * Note: this requires outgoing data ports to be initialized during the
    * initialization phase or prior to system testing.
    */
  def get_api_lrl: vvi_mode.CardiacDuration = {
    Art.observeOutPortVariable(Arch.PG_i_Instance_pp_rc.operational_api.lrl_Id) match {
      case Some(vvi_mode.CardiacDuration_Payload(value)) =>
        last_api_lrl = Some(value)
        return value
      case _ if last_api_lrl.isEmpty =>
        assert(F, "No value found on outgoing data port lrl.\n                  Note: values placed during the initialization phase will persist across dispatches")
        halt("No value found on outgoing data port lrl.\n                  Note: values placed during the initialization phase will persist across dispatches")
      case _ => return last_api_lrl.get
    }
  }
  var last_api_vrp: Option[vvi_mode.CardiacDuration] = None()

  /** get the value of outgoing data port vrp.  If a 'fresh' value wasn't sent
    * during the last dispatch then return last_api_vrp.get.
    * Note: this requires outgoing data ports to be initialized during the
    * initialization phase or prior to system testing.
    */
  def get_api_vrp: vvi_mode.CardiacDuration = {
    Art.observeOutPortVariable(Arch.PG_i_Instance_pp_rc.operational_api.vrp_Id) match {
      case Some(vvi_mode.CardiacDuration_Payload(value)) =>
        last_api_vrp = Some(value)
        return value
      case _ if last_api_vrp.isEmpty =>
        assert(F, "No value found on outgoing data port vrp.\n                  Note: values placed during the initialization phase will persist across dispatches")
        halt("No value found on outgoing data port vrp.\n                  Note: values placed during the initialization phase will persist across dispatches")
      case _ => return last_api_vrp.get
    }
  }
  var preStateContainer_wL: Option[RateControl_pp_rc_PreState_Container_PS] = None()

  def pre_initialise(): Unit = {
    // assume/require contracts cannot refer to incoming ports or
    // state variables so nothing to do here
  }

  def post_initialise(): Unit = {
    // block the component while its post-state values are retrieved
    val postStateContainer_wL =
      RateControl_pp_rc_PostState_Container_PS(
        api_lrl = get_api_lrl,
        api_vrp = get_api_vrp)

    // the rest can now be performed via a different thread
    bless.runtimemonitor.RuntimeMonitor.observeInitialisePostState(Arch.PG_i_Instance_pp_rc.id, bless.runtimemonitor.ObservationKind.PG_i_Instance_pp_rc_postInit, postStateContainer_wL)
  }

  def pre_compute(): Unit = {
    // block the component while its pre-state values are retrieved
    preStateContainer_wL = Some(
      RateControl_pp_rc_PreState_Container_PS())

    // the rest can now be performed via a different thread
    bless.runtimemonitor.RuntimeMonitor.observeComputePreState(Arch.PG_i_Instance_pp_rc.id, bless.runtimemonitor.ObservationKind.PG_i_Instance_pp_rc_preCompute, preStateContainer_wL.asInstanceOf[Option[art.DataContent]])
  }

  def post_compute(): Unit = {
    // block the component while its post-state values are retrieved
    val postStateContainer_wL =
      RateControl_pp_rc_PostState_Container_PS(
        api_lrl = get_api_lrl,
        api_vrp = get_api_vrp)

    // the rest can now be performed via a different thread
    bless.runtimemonitor.RuntimeMonitor.observeComputePrePostState(Arch.PG_i_Instance_pp_rc.id, bless.runtimemonitor.ObservationKind.PG_i_Instance_pp_rc_postCompute, preStateContainer_wL.asInstanceOf[Option[art.DataContent]], postStateContainer_wL)
  }
}