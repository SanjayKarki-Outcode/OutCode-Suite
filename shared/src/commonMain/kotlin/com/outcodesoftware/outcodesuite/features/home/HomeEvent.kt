package com.outcodesoftware.outcodesuite.features.home

import com.outcodesoftware.outcodesuite.framework.Event

sealed class HomeEvent: Event<HomeEvent> {
    object OnApplyLeave: HomeEvent()
    object OnApplyAttendance: HomeEvent()
    object OnApplyRemarks: HomeEvent()
    object OnLeaveSubmit: HomeEvent()
    object OnAttendanceSubmit: HomeEvent()
    object OnRemarksSubmit: HomeEvent()
    data class OnLeaveReasonChange(val reason: String): HomeEvent()
}