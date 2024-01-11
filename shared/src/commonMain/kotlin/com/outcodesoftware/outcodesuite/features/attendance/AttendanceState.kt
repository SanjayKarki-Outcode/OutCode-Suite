package com.outcodesoftware.outcodesuite.features.attendance

import com.outcodesoftware.outcodesuite.framework.ScreenState
import com.outcodesoftware.outcodesuite.framework.ViewState

class AttendanceState : AttendanceScreenState(), ViewState<AttendanceState> {

}

sealed class AttendanceScreenState: ScreenState(){

}