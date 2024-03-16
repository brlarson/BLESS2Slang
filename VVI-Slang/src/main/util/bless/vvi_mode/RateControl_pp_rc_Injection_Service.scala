// #Sireum
package bless.vvi_mode

import org.sireum._

// Do not edit this file as it will be overwritten if HAMR codegen is rerun

@msig trait RateControl_pp_rc_Injection_Provider {
  def pre_receiveInput(): Unit
}

object RateControl_pp_rc_Injection_Service {

  var providers: MSZ[RateControl_pp_rc_Injection_Provider] = MSZ()

  def register(provider: RateControl_pp_rc_Injection_Provider): Unit = {
    providers = providers :+ provider
  }

  def pre_receiveInput(): Unit = {
    for (provider <- providers) {
      provider.pre_receiveInput()
    }
  }
}