// #Sireum

package bless

import org.sireum._
import art._
import art.PortMode._
import art.DispatchPropertyProtocol._
import art.Art.BridgeId._
import art.Art.PortId._

// Do not edit this file as it will be overwritten if HAMR codegen is rerun

object Arch {
  val PG_i_Instance_pp_t : bless.vvi_mode.VVI_i_pp_t_Bridge = {
    val lrl = Port[vvi_mode.CardiacDuration] (id = portId"0", name = "PG_i_Instance_pp_t_lrl", mode = DataIn)
    val vrp = Port[vvi_mode.CardiacDuration] (id = portId"1", name = "PG_i_Instance_pp_t_vrp", mode = DataIn)
    val s = Port[art.Empty] (id = portId"2", name = "PG_i_Instance_pp_t_s", mode = EventIn)
    val p = Port[art.Empty] (id = portId"3", name = "PG_i_Instance_pp_t_p", mode = EventOut)
    val n = Port[art.Empty] (id = portId"4", name = "PG_i_Instance_pp_t_n", mode = EventOut)
    val h = Port[art.Empty] (id = portId"5", name = "PG_i_Instance_pp_t_h", mode = EventIn)

    bless.vvi_mode.VVI_i_pp_t_Bridge(
      id = bridgeId"0",
      name = "PG_i_Instance_pp_t",
      dispatchProtocol = Sporadic(min = 1),
      dispatchTriggers = None(),

      lrl = lrl,
      vrp = vrp,
      s = s,
      p = p,
      n = n,
      h = h
    )
  }
  val PG_i_Instance_pp_rc : bless.vvi_mode.RateControl_pp_rc_Bridge = {
    val lrl = Port[vvi_mode.CardiacDuration] (id = portId"6", name = "PG_i_Instance_pp_rc_lrl", mode = DataOut)
    val vrp = Port[vvi_mode.CardiacDuration] (id = portId"7", name = "PG_i_Instance_pp_rc_vrp", mode = DataOut)

    bless.vvi_mode.RateControl_pp_rc_Bridge(
      id = bridgeId"1",
      name = "PG_i_Instance_pp_rc",
      dispatchProtocol = Periodic(period = 10000),
      dispatchTriggers = None(),

      lrl = lrl,
      vrp = vrp
    )
  }

  val ad : ArchitectureDescription = {

    ArchitectureDescription(
      components = IS[Art.BridgeId, Bridge] (PG_i_Instance_pp_t, PG_i_Instance_pp_rc),

      connections = IS[Art.ConnectionId, UConnection] (Connection(from = PG_i_Instance_pp_rc.lrl, to = PG_i_Instance_pp_t.lrl),
                                                       Connection(from = PG_i_Instance_pp_rc.vrp, to = PG_i_Instance_pp_t.vrp))
    )
  }
}