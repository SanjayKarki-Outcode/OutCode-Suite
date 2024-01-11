package com.outcodesoftware.outcodesuite.features.login

import com.outcodesoftware.outcodesuite.framework.ScreenState
import com.outcodesoftware.outcodesuite.framework.ViewState
import kotlinx.coroutines.flow.MutableStateFlow

class LoginState : LoginScreenState(), ViewState<LoginState> {
    var etEmail = MutableStateFlow("sanjay.karki@outcodesoftware.com")
    var etPassword= MutableStateFlow("pass")
    var rememberMe= MutableStateFlow(false)


}

sealed class LoginScreenState : ScreenState() {

}