// #Sireum

package bless.vvi_mode

import org.sireum._
import art.Art
import bless._

// Do not edit this file as it will be overwritten if HAMR codegen is rerun
@msig trait RateControl_pp_rc_TestApi {

  def BeforeEntrypoint(): Unit = {
    Art.initTest(Arch.PG_i_Instance_pp_rc)
  }

  def AfterEntrypoint(): Unit = {
    Art.finalizeTest(Arch.PG_i_Instance_pp_rc)
  }

  def testCompute(): Unit = {
    Art.manuallyClearOutput()
    Art.testCompute(Arch.PG_i_Instance_pp_rc)
  }

  def testInitialise(): Unit = {
    Art.manuallyClearOutput()
    Art.testInitialise(Arch.PG_i_Instance_pp_rc)
  }

  /** helper function to check RateControl_pp_rc's
   * output ports.  Use named arguments to check subsets of the output ports.
   * @param lrl method that will be called with the value of the outgoing data
   *        port 'lrl'.
   * @param vrp method that will be called with the value of the outgoing data
   *        port 'vrp'.
   */
  def check_concrete_output(lrl: vvi_mode.CardiacDuration => B,
                            vrp: vvi_mode.CardiacDuration => B): Unit = {
    var testFailures: ISZ[ST] = ISZ()

    val lrlValue: vvi_mode.CardiacDuration = get_lrl().get
    if(!lrl(lrlValue)) {
      testFailures = testFailures :+ st"'lrl' did not match expected: value of the outgoing data port is ${lrlValue}"
    }
    val vrpValue: vvi_mode.CardiacDuration = get_vrp().get
    if(!vrp(vrpValue)) {
      testFailures = testFailures :+ st"'vrp' did not match expected: value of the outgoing data port is ${vrpValue}"
    }

    assert(testFailures.isEmpty, st"${(testFailures, "\n")}".render)
  }


  // getter for out DataPort
  def get_lrl(): Option[vvi_mode.CardiacDuration] = {
    val value: Option[vvi_mode.CardiacDuration] = get_lrl_payload() match {
      case Some(vvi_mode.CardiacDuration_Payload(v)) => Some(v)
      case Some(v) => halt(s"Unexpected payload on port lrl.  Expecting 'vvi_mode.CardiacDuration_Payload' but received ${v}")
      case _ => None[vvi_mode.CardiacDuration]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_lrl_payload(): Option[vvi_mode.CardiacDuration_Payload] = {
    return Art.observeOutInfrastructurePort(Arch.PG_i_Instance_pp_rc.initialization_api.lrl_Id).asInstanceOf[Option[vvi_mode.CardiacDuration_Payload]]
  }

  // getter for out DataPort
  def get_vrp(): Option[vvi_mode.CardiacDuration] = {
    val value: Option[vvi_mode.CardiacDuration] = get_vrp_payload() match {
      case Some(vvi_mode.CardiacDuration_Payload(v)) => Some(v)
      case Some(v) => halt(s"Unexpected payload on port vrp.  Expecting 'vvi_mode.CardiacDuration_Payload' but received ${v}")
      case _ => None[vvi_mode.CardiacDuration]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_vrp_payload(): Option[vvi_mode.CardiacDuration_Payload] = {
    return Art.observeOutInfrastructurePort(Arch.PG_i_Instance_pp_rc.initialization_api.vrp_Id).asInstanceOf[Option[vvi_mode.CardiacDuration_Payload]]
  }

}
