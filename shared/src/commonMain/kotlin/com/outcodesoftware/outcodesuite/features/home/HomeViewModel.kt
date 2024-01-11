package com.outcodesoftware.outcodesuite.features.home

import com.outcodesoftware.outcodesuite.framework.AppResult
import com.outcodesoftware.outcodesuite.framework.BaseVM
import com.outcodesoftware.outcodesuite.framework.ScreenState
import kotlinx.coroutines.launch

class HomeViewModel(): BaseVM<HomeEvent, HomeState>(){
    override fun initState(): HomeState {
        return HomeState()
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

    override fun logState(state: HomeState) {

    }

    override fun onHandleEvent(event: HomeEvent) {
      viewModelScope.launch {
          when(event){
              is HomeEvent.OnApplyLeave ->{
                  state.isLeaveSheetVisible.value = !state.isLeaveSheetVisible.value
                  state.etLeaveReason.value = ""
                  setState(state)
              }

              is HomeEvent.OnApplyAttendance ->{
                  state.isApplyingAttendance.value = !state.isApplyingAttendance.value
                  setState(state)
              }

              is HomeEvent.OnApplyRemarks ->{
                  state.isApplyingRemarks.value = !state.isApplyingRemarks.value
                  setState(state)
              }

              is HomeEvent.OnLeaveReasonChange ->{
                  state.etLeaveReason.value = event.reason
                  setState(state)
              }

              else ->{}
          }
      }
    }

}