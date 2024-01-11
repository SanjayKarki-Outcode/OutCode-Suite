package com.outcodesoftware.outcodesuite.framework

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


abstract class BaseVM<Event, VState>(val overrideSuccess: Boolean = false): ViewModel() {
    abstract fun initState(): VState
    abstract fun onHandleEvent(event: Event)

    abstract fun logState(state: VState)

    abstract fun <T> responseToState(it: AppResult<T>)

    protected val state: VState by lazy {
        initState()

    }

    private var uiState = MutableStateFlow(state)
    var uiStateUI: StateFlow<VState> = uiState


    protected fun setState(newState: VState) {
        viewModelScope.launch {
            delay(200)
            uiState.value = newState
            logState(state = state)
        }
    }

}