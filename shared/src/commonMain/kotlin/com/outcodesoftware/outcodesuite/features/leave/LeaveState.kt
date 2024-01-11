package com.outcodesoftware.outcodesuite.features.leave

import com.outcodesoftware.outcodesuite.framework.ScreenState
import com.outcodesoftware.outcodesuite.framework.ViewState

class LeaveState: LeaveScreenState(), ViewState<LeaveState>{

}

sealed class LeaveScreenState: ScreenState(){

}