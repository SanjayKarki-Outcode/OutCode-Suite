package com.outcodesoftware.outcodesuite.features.leave

import com.outcodesoftware.outcodesuite.framework.AppResult
import com.outcodesoftware.outcodesuite.framework.BaseVM
import com.outcodesoftware.outcodesuite.framework.ScreenState
import kotlinx.coroutines.launch

class LeaveViewModel(): BaseVM<LeaveEvent,LeaveState>() {
    override fun initState(): LeaveState {
        return LeaveState()
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

    override fun logState(state: LeaveState) {

    }

    override fun onHandleEvent(event: LeaveEvent) {
        viewModelScope.launch {
            when(event){

                else ->{}
            }
        }
    }

}