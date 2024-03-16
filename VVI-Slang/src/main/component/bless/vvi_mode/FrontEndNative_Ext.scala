package bless.vvi_mode

import UNO.UNOBridge

//this is hand written to invoke UNOBridage
//corresponds to FrontEnd_fe.FrontEndNative

class FrontEndNative_Ext {

  def initialise(api: FrontEnd_Initialization_Api): Unit =
    {
      UNOBridge.init(api)
    }

  def handle_pace(api: FrontEnd_Operational_Api): Unit =
    {
      UNOBridge.putVP(api)
    }

}
