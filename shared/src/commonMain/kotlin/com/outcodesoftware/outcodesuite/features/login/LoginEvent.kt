package com.outcodesoftware.outcodesuite.features.login

import cafe.adriel.voyager.navigator.Navigator
import com.outcodesoftware.outcodesuite.framework.Event

sealed class LoginEvent : Event<LoginEvent>{

    data class OnEmailChange(val email:String): LoginEvent()
    data class OnPasswordChange(val password: String): LoginEvent()
    data class OnRememberMe(val isChecked: Boolean): LoginEvent()

    data class OnLoginClick(val navigator: Navigator): LoginEvent()
    data class OnForgotPasswordClick(val navigator: Navigator): LoginEvent()

//    object RegisterSc: MainLoginScreen()
//    object List: MainLoginScreen()

}