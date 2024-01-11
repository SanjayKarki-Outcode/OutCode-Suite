package com.outcodesoftware.outcodesuite.features.home

import com.outcodesoftware.outcodesuite.framework.ScreenState
import com.outcodesoftware.outcodesuite.framework.ViewState
import kotlinx.coroutines.flow.MutableStateFlow

class HomeState: HomeScreenState(), ViewState<HomeState>{

    // leave section
    val isLeaveSheetVisible = MutableStateFlow(false)
    val isApplyingAttendance = MutableStateFlow(false)
    val isApplyingRemarks = MutableStateFlow(false)
    val etLeaveReason = MutableStateFlow("")
    val attendanceType = listOf("Check In", "Check Out")
    val isFullDay = MutableStateFlow(true)
    val showDatePIck = MutableStateFlow(false)
    val datePicker = MutableStateFlow("")
    val selectedFrom = MutableStateFlow("From")
    val selectedTo = MutableStateFlow("To")

}

sealed class HomeScreenState: ScreenState(){

}