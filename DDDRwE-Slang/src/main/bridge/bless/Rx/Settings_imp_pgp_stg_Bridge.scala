// #Sireum

package bless.Rx

import org.sireum._
import art._
import bless._
import bless.Rx.{Settings_imp_pgp_stg => component}
import org.sireum.S64._

// Do not edit this file as it will be overwritten if HAMR codegen is rerun

@datatype class Settings_imp_pgp_stg_Bridge(
  val id: Art.BridgeId,
  val name: String,
  val dispatchProtocol: DispatchPropertyProtocol,
  val dispatchTriggers: Option[ISZ[Art.PortId]],

  lrl: Port[PACE_Data.ms],
  url: Port[PACE_Data.ms],
  av: Port[PACE_Data.ms],
  savo: Port[PACE_Data.ms],
  act: Port[PACE_Data.milliG],
  vrp: Port[PACE_Data.ms],
  arp: Port[PACE_Data.ms],
  pvarp: Port[PACE_Data.ms],
  pv: Port[BLESS_Types.flag],
  sv: Port[BLESS_Types.flag],
  pa: Port[BLESS_Types.flag],
  sa: Port[BLESS_Types.flag],
  inhibit: Port[BLESS_Types.flag],
  track: Port[BLESS_Types.flag],
  hy: Port[PACE_Data.ms],
  rr: Port[BLESS_Types.flag],
  rf: Port[PACE_Data.rf],
  msr: Port[PACE_Data.ms],
  min_av: Port[PACE_Data.ms],
  ex_pvarp: Port[PACE_Data.ms],
  rt: Port[PACE_Data.second],
  ct: Port[PACE_Data.second],
  atr_enable: Port[BLESS_Types.flag],
  atr_duration: Port[PACE_Data.CCcount],
  fb_time: Port[PACE_Data.second],
  drs: Port[PACE_Data.percent],
  urs: Port[PACE_Data.percent],
  settings: Port[PACE_Data.Rx]
  ) extends Bridge {

  val ports : Bridge.Ports = Bridge.Ports(
    dataIns = ISZ[art.UPort](),

    dataOuts = ISZ[art.UPort](lrl,
                              url,
                              av,
                              savo,
                              act,
                              vrp,
                              arp,
                              pvarp,
                              pv,
                              sv,
                              pa,
                              sa,
                              inhibit,
                              track,
                              hy,
                              rr,
                              rf,
                              msr,
                              min_av,
                              ex_pvarp,
                              rt,
                              ct,
                              atr_enable,
                              atr_duration,
                              fb_time,
                              drs,
                              urs),

    eventIns = ISZ[art.UPort](settings),

    eventOuts = ISZ[art.UPort]()
  )

  val initialization_api : Settings_imp_Initialization_Api = {
    val api = Settings_imp_Initialization_Api(
      id,
      lrl.id,
      url.id,
      av.id,
      savo.id,
      act.id,
      vrp.id,
      arp.id,
      pvarp.id,
      pv.id,
      sv.id,
      pa.id,
      sa.id,
      inhibit.id,
      track.id,
      hy.id,
      rr.id,
      rf.id,
      msr.id,
      min_av.id,
      ex_pvarp.id,
      rt.id,
      ct.id,
      atr_enable.id,
      atr_duration.id,
      fb_time.id,
      drs.id,
      urs.id,
      settings.id
    )
    Settings_imp_pgp_stg_Bridge.c_initialization_api = Some(api)
    api
  }

  val operational_api : Settings_imp_Operational_Api = {
    val api = Settings_imp_Operational_Api(
      id,
      lrl.id,
      url.id,
      av.id,
      savo.id,
      act.id,
      vrp.id,
      arp.id,
      pvarp.id,
      pv.id,
      sv.id,
      pa.id,
      sa.id,
      inhibit.id,
      track.id,
      hy.id,
      rr.id,
      rf.id,
      msr.id,
      min_av.id,
      ex_pvarp.id,
      rt.id,
      ct.id,
      atr_enable.id,
      atr_duration.id,
      fb_time.id,
      drs.id,
      urs.id,
      settings.id
    )
    Settings_imp_pgp_stg_Bridge.c_operational_api = Some(api)
    api
  }

  val entryPoints : Bridge.EntryPoints =
    Settings_imp_pgp_stg_Bridge.EntryPoints(
      id,

      lrl.id,
      url.id,
      av.id,
      savo.id,
      act.id,
      vrp.id,
      arp.id,
      pvarp.id,
      pv.id,
      sv.id,
      pa.id,
      sa.id,
      inhibit.id,
      track.id,
      hy.id,
      rr.id,
      rf.id,
      msr.id,
      min_av.id,
      ex_pvarp.id,
      rt.id,
      ct.id,
      atr_enable.id,
      atr_duration.id,
      fb_time.id,
      drs.id,
      urs.id,
      settings.id,

      dispatchTriggers,

      initialization_api,
      operational_api)
}

object Settings_imp_pgp_stg_Bridge {

  var c_initialization_api: Option[Settings_imp_Initialization_Api] = None()
  var c_operational_api: Option[Settings_imp_Operational_Api] = None()
  // I'm a companion object block

  def contains(isz : ISZ[Art.PortId], elt : Art.PortId) : B =
    { for ( i <- isz )
      { if (i == elt) { return T } }
    return F
    }

  var event_set : Set[Art.PortId] = Set.empty[Art.PortId]

  var timeout_id : Art.PortId = Art.PortId.fromZ(Art.numPorts - 4)





  @datatype class EntryPoints(
    Settings_imp_pgp_stg_BridgeId : Art.BridgeId,
    lrl_Id : Art.PortId,
    url_Id : Art.PortId,
    av_Id : Art.PortId,
    savo_Id : Art.PortId,
    act_Id : Art.PortId,
    vrp_Id : Art.PortId,
    arp_Id : Art.PortId,
    pvarp_Id : Art.PortId,
    pv_Id : Art.PortId,
    sv_Id : Art.PortId,
    pa_Id : Art.PortId,
    sa_Id : Art.PortId,
    inhibit_Id : Art.PortId,
    track_Id : Art.PortId,
    hy_Id : Art.PortId,
    rr_Id : Art.PortId,
    rf_Id : Art.PortId,
    msr_Id : Art.PortId,
    min_av_Id : Art.PortId,
    ex_pvarp_Id : Art.PortId,
    rt_Id : Art.PortId,
    ct_Id : Art.PortId,
    atr_enable_Id : Art.PortId,
    atr_duration_Id : Art.PortId,
    fb_time_Id : Art.PortId,
    drs_Id : Art.PortId,
    urs_Id : Art.PortId,
    settings_Id : Art.PortId,
    dispatchTriggers : Option[ISZ[Art.PortId]],
    initialization_api: Settings_imp_Initialization_Api,
    operational_api: Settings_imp_Operational_Api) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = IS()

    val eventInPortIds: ISZ[Art.PortId] = IS(settings_Id)

    val dataOutPortIds: ISZ[Art.PortId] = IS(lrl_Id,
                                             url_Id,
                                             av_Id,
                                             savo_Id,
                                             act_Id,
                                             vrp_Id,
                                             arp_Id,
                                             pvarp_Id,
                                             pv_Id,
                                             sv_Id,
                                             pa_Id,
                                             sa_Id,
                                             inhibit_Id,
                                             track_Id,
                                             hy_Id,
                                             rr_Id,
                                             rf_Id,
                                             msr_Id,
                                             min_av_Id,
                                             ex_pvarp_Id,
                                             rt_Id,
                                             ct_Id,
                                             atr_enable_Id,
                                             atr_duration_Id,
                                             fb_time_Id,
                                             drs_Id,
                                             urs_Id)

    val eventOutPortIds: ISZ[Art.PortId] = IS()



    def initialise(): Unit = {
      // i'm an initialize body
        initialization_api.logDebug("Settings_imp_pgp_stg_Bridge.initialise()")  
        component.Initialize_Entrypoint(initialization_api)
        Art.sendOutput(eventOutPortIds, dataOutPortIds)
    }

    def compute(): Unit = {
      // i'm a compute body
        operational_api.logDebug("Settings_imp_pgp_stg_Bridge.compute()")  
        val EventTriggered(receivedEvents) = Art.dispatchStatus(Settings_imp_pgp_stg_BridgeId)
        event_set = event_set ++ receivedEvents  
        Art.receiveInput(eventInPortIds, dataInPortIds)
        val dispatched : B = { component.Compute_Entrypoint(operational_api, event_set) }
        if (dispatched) { event_set = Set.empty[Art.PortId] }
        Art.sendOutput(eventOutPortIds, dataOutPortIds)
    }

    def activate(): Unit = {
      // i'm an activate body
    }

    def deactivate(): Unit = {
      // i'm a deactivate body
    }

    def finalise(): Unit = {
      // i'm a finalize body
      Art.receiveInput(eventInPortIds, dataInPortIds)
      component.Finalize_Entrypoint(operational_api)
    }

    def recover(): Unit = {
      // i'm a recover body
    }

    override
    def testInitialise(): Unit = {
      // i'm an initialize body
        initialization_api.logDebug("Settings_imp_pgp_stg_Bridge.initialise()")  
        component.Initialize_Entrypoint(initialization_api)
        Art.sendOutput(eventOutPortIds, dataOutPortIds)
    }

    override
    def testCompute(): Unit = {
      // i'm a compute body
        operational_api.logDebug("Settings_imp_pgp_stg_Bridge.compute()")  
        val EventTriggered(receivedEvents) = Art.dispatchStatus(Settings_imp_pgp_stg_BridgeId)
        event_set = event_set ++ receivedEvents  
        Art.receiveInput(eventInPortIds, dataInPortIds)
        val dispatched : B = { component.Compute_Entrypoint(operational_api, event_set) }
        if (dispatched) { event_set = Set.empty[Art.PortId] }
        Art.sendOutput(eventOutPortIds, dataOutPortIds)
    }
  }
}