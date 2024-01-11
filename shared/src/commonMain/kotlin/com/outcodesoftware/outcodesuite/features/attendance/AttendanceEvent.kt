package com.outcodesoftware.outcodesuite.features.attendance

import com.outcodesoftware.outcodesuite.features.leave.LeaveEvent
import com.outcodesoftware.outcodesuite.framework.Event

sealed class AttendanceEvent: Event<LeaveEvent> {
}