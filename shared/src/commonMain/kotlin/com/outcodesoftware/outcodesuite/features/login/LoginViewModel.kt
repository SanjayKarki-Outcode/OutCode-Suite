package com.outcodesoftware.outcodesuite.features.login

import com.outcodesoftware.outcodesuite.features.dashboard.DashboardMainScreen
import com.outcodesoftware.outcodesuite.features.register.RegisterScreen
import com.outcodesoftware.outcodesuite.features.register.RegisterViewModel
import com.outcodesoftware.outcodesuite.framework.AppResult
import com.outcodesoftware.outcodesuite.framework.BaseVM
import com.outcodesoftware.outcodesuite.framework.ScreenState
import kotlinx.coroutines.launch


class LoginViewModel() : BaseVM<LoginEvent, LoginState>() {
    override fun initState(): LoginState {
        return LoginState()
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

    override fun logState(state: LoginState) {

    }

    override fun onHandleEvent(event: LoginEvent) {
        viewModelScope.launch {

            when (event) {

                is LoginEvent.OnEmailChange -> {
                    state.etEmail.value = event.email
                    setState(state)
                }

                is LoginEvent.OnLoginClick -> {
                    if (validationLogin()) {
                        event.navigator.push(
                            DashboardMainScreen()
                        )
                    }
                }

                is LoginEvent.OnPasswordChange -> {
                    state.etPassword.value = event.password
                    setState(state)


                }

                is LoginEvent.OnRememberMe -> {
                    state.rememberMe.value = event.isChecked
                    setState(state)


                }

                is LoginEvent.OnForgotPasswordClick -> {
                    event.navigator.push(RegisterScreen())
                }

            }


        }
    }

    private fun validationLogin(): Boolean{

         val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        var isValid = true

        isValid = state.etEmail.value.matches(emailPattern.toRegex())

        if(state.etPassword.value.isEmpty()){
            isValid = false
        }


        return isValid
    }


}