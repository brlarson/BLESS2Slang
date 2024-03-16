// #Sireum

package bless.vvi_mode

import org.sireum._
import art.Art
import bless._

// Do not edit this file as it will be overwritten if HAMR codegen is rerun
@msig trait VVI_i_pp_t_TestApi {

  def BeforeEntrypoint(): Unit = {
    Art.initTest(Arch.PG_i_Instance_pp_t)
  }

  def AfterEntrypoint(): Unit = {
    Art.finalizeTest(Arch.PG_i_Instance_pp_t)
  }

  def testCompute(): Unit = {
    Art.manuallyClearOutput()
    Art.testCompute(Arch.PG_i_Instance_pp_t)
  }

  def testInitialise(): Unit = {
    Art.manuallyClearOutput()
    Art.testInitialise(Arch.PG_i_Instance_pp_t)
  }

  /** helper function to set the values of all input ports.
   * @param lrl payload for data port lrl
   * @param vrp payload for data port vrp
   * @param s the number of events to place in the s event port queue.
   *   ART currently supports single element event queues so at most
   *   one event will be placed in the queue.
   * @param h the number of events to place in the h event port queue.
   *   ART currently supports single element event queues so at most
   *   one event will be placed in the queue.
   */
  def put_concrete_inputs(lrl : vvi_mode.CardiacDuration,
                          vrp : vvi_mode.CardiacDuration,
                          s : Z,
                          h : Z): Unit = {
    put_lrl(lrl)
    put_vrp(vrp)
    for(i <- 0 until s) {
      put_s()
    }
    for(i <- 0 until h) {
      put_h()
    }
  }


  /** helper function to check VVI_i_pp_t's
   * output ports.  Use named arguments to check subsets of the output ports.
   * @param p method that will be called with the number of events to be sent
   *        on the outgoing event port 'p'.
   * @param n method that will be called with the number of events to be sent
   *        on the outgoing event port 'n'.
   */
  def check_concrete_output(p: Z => B,
                            n: Z => B): Unit = {
    var testFailures: ISZ[ST] = ISZ()

    // TODO: event port getter should return the number of events in
    //       the output queue when queue sizes > 1 support is added to ART
    val pValue: Z = if(get_p().nonEmpty) z"1" else z"0"
    if(!p(pValue)) {
      testFailures = testFailures :+ st"'p' did not match expected: ${pValue} events were in the outgoing event queue"
    }
    // TODO: event port getter should return the number of events in
    //       the output queue when queue sizes > 1 support is added to ART
    val nValue: Z = if(get_n().nonEmpty) z"1" else z"0"
    if(!n(nValue)) {
      testFailures = testFailures :+ st"'n' did not match expected: ${nValue} events were in the outgoing event queue"
    }

    assert(testFailures.isEmpty, st"${(testFailures, "\n")}".render)
  }


  // setter for in DataPort
  def put_lrl(value : vvi_mode.CardiacDuration): Unit = {
    Art.insertInInfrastructurePort(Arch.PG_i_Instance_pp_t.operational_api.lrl_Id, vvi_mode.CardiacDuration_Payload(value))
  }

  // setter for in DataPort
  def put_vrp(value : vvi_mode.CardiacDuration): Unit = {
    Art.insertInInfrastructurePort(Arch.PG_i_Instance_pp_t.operational_api.vrp_Id, vvi_mode.CardiacDuration_Payload(value))
  }

  // setter for in EventPort
  def put_s(): Unit = {
    Art.insertInInfrastructurePort(Arch.PG_i_Instance_pp_t.operational_api.s_Id, art.Empty())
  }

  // setter for in EventPort
  def put_h(): Unit = {
    Art.insertInInfrastructurePort(Arch.PG_i_Instance_pp_t.operational_api.h_Id, art.Empty())
  }

  // getter for out EventPort
  def get_p(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_p_payload() match {
      case Some(art.Empty()) => Some(art.Empty())
      case Some(v) => halt(s"Unexpected payload on port p.  Expecting 'art.Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_p_payload(): Option[art.Empty] = {
    return Art.observeOutInfrastructurePort(Arch.PG_i_Instance_pp_t.initialization_api.p_Id).asInstanceOf[Option[art.Empty]]
  }

  // getter for out EventPort
  def get_n(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_n_payload() match {
      case Some(art.Empty()) => Some(art.Empty())
      case Some(v) => halt(s"Unexpected payload on port n.  Expecting 'art.Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_n_payload(): Option[art.Empty] = {
    return Art.observeOutInfrastructurePort(Arch.PG_i_Instance_pp_t.initialization_api.n_Id).asInstanceOf[Option[art.Empty]]
  }

}
