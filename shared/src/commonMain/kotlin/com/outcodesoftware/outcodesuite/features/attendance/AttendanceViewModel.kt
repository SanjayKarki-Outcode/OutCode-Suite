package com.outcodesoftware.outcodesuite.features.attendance

import com.outcodesoftware.outcodesuite.framework.AppResult
import com.outcodesoftware.outcodesuite.framework.BaseVM
import com.outcodesoftware.outcodesuite.framework.ScreenState
import kotlinx.coroutines.launch

class AttendanceViewModel(): BaseVM<AttendanceEvent, AttendanceState>() {

    override fun initState(): AttendanceState {
        return AttendanceState()
    }

    override fun <T> responseToState(it: AppResult<T>) {
        when (it.status) {
            AppResult.Status.EXCEPTION -> {
                state.isError.value = ScreenState.ERROR(run = true, it.error)
            }

            AppResult.Status.ERROR -> {
                state.isError.value = ScreenState.ERROR(run = true, it.error)
                setState(state)
            }

            AppResult.Status.NO_INTERNET_AVAILABLE -> {
                state.isError.value = ScreenState.ERROR(run = true, it.error)

            }

            else -> {}
        }
    }

    override fun logState(state: AttendanceState) {

    }

    override fun onHandleEvent(event: AttendanceEvent) {
        viewModelScope.launch {
            when(event){

                else ->{}
            }
        }
    }

}