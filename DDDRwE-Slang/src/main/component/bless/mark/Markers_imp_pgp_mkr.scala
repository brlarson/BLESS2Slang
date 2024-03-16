// #Sireum

package bless.mark

import org.sireum._
import bless._

// This file will not be overwritten so is safe to edit
object Markers_imp_pgp_mkr {

  def initialise(api: Markers_imp_Initialization_Api): Unit = {
    // example api usage

    api.logInfo("Example info logging")
    api.logDebug("Example debug logging")
    api.logError("Example error logging")

    api.put_mark_A(mark.AtrialMarker.example())
    api.put_mark_V(mark.VentricularlMarker.example())
    api.put_mark_X(mark.ExtraordinaryMarker.example())
  }

  def handle_atr_dct(api: Markers_imp_Operational_Api, value: BLESS_Types.flag): Unit = {
    api.logInfo("example handle_atr_dct implementation")
    api.logInfo(s"  received $value")
    // example api usage

    val apiUsage_tna: Option[BLESS_Types.flag] = api.get_tna()
    api.logInfo(s"Received on data port tna: ${apiUsage_tna}")
    val apiUsage_tnv: Option[BLESS_Types.flag] = api.get_tnv()
    api.logInfo(s"Received on data port tnv: ${apiUsage_tnv}")
    val apiUsage_cci: Option[PACE_Data.ms] = api.get_cci()
    api.logInfo(s"Received on data port cci: ${apiUsage_cci}")
    val apiUsage_atr_dct: Option[BLESS_Types.flag] = api.get_atr_dct()
    api.logInfo(s"Received on event data port atr_dct: ${apiUsage_atr_dct}")
    val apiUsage_atr_end: Option[BLESS_Types.flag] = api.get_atr_end()
    api.logInfo(s"Received on event data port atr_end: ${apiUsage_atr_end}")
    val apiUsage_ap: Option[art.Empty] = api.get_ap()
    api.logInfo(s"Received on event port ap: ${apiUsage_ap}")
    val apiUsage_vp: Option[art.Empty] = api.get_vp()
    api.logInfo(s"Received on event port vp: ${apiUsage_vp}")
    val apiUsage_as: Option[art.Empty] = api.get_as()
    api.logInfo(s"Received on event port as: ${apiUsage_as}")
    val apiUsage_at: Option[art.Empty] = api.get_at()
    api.logInfo(s"Received on event port at: ${apiUsage_at}")
    val apiUsage_vs: Option[art.Empty] = api.get_vs()
    api.logInfo(s"Received on event port vs: ${apiUsage_vs}")
    val apiUsage_pvc: Option[art.Empty] = api.get_pvc()
    api.logInfo(s"Received on event port pvc: ${apiUsage_pvc}")
    val apiUsage_ras: Option[art.Empty] = api.get_ras()
    api.logInfo(s"Received on event port ras: ${apiUsage_ras}")
    val apiUsage_rvs: Option[art.Empty] = api.get_rvs()
    api.logInfo(s"Received on event port rvs: ${apiUsage_rvs}")
    val apiUsage_atr_fb: Option[art.Empty] = api.get_atr_fb()
    api.logInfo(s"Received on event port atr_fb: ${apiUsage_atr_fb}")
  }

  def handle_atr_end(api: Markers_imp_Operational_Api, value: BLESS_Types.flag): Unit = {
    api.logInfo("example handle_atr_end implementation")
    api.logInfo(s"  received $value")
  }

  def handle_ap(api: Markers_imp_Operational_Api): Unit = {
    api.logInfo("example handle_ap implementation")
    api.logInfo("  received event")
  }

  def handle_vp(api: Markers_imp_Operational_Api): Unit = {
    api.logInfo("example handle_vp implementation")
    api.logInfo("  received event")
  }

  def handle_as(api: Markers_imp_Operational_Api): Unit = {
    api.logInfo("example handle_as implementation")
    api.logInfo("  received event")
  }

  def handle_at(api: Markers_imp_Operational_Api): Unit = {
    api.logInfo("example handle_at implementation")
    api.logInfo("  received event")
  }

  def handle_vs(api: Markers_imp_Operational_Api): Unit = {
    api.logInfo("example handle_vs implementation")
    api.logInfo("  received event")
  }

  def handle_pvc(api: Markers_imp_Operational_Api): Unit = {
    api.logInfo("example handle_pvc implementation")
    api.logInfo("  received event")
  }

  def handle_ras(api: Markers_imp_Operational_Api): Unit = {
    api.logInfo("example handle_ras implementation")
    api.logInfo("  received event")
  }

  def handle_rvs(api: Markers_imp_Operational_Api): Unit = {
    api.logInfo("example handle_rvs implementation")
    api.logInfo("  received event")
  }

  def handle_atr_fb(api: Markers_imp_Operational_Api): Unit = {
    api.logInfo("example handle_atr_fb implementation")
    api.logInfo("  received event")
  }

  def activate(api: Markers_imp_Operational_Api): Unit = { }

  def deactivate(api: Markers_imp_Operational_Api): Unit = { }

  def finalise(api: Markers_imp_Operational_Api): Unit = { }

  def recover(api: Markers_imp_Operational_Api): Unit = { }
}
