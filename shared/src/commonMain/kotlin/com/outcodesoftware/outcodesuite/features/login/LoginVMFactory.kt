package com.outcodesoftware.outcodesuite.features.login

import dev.icerock.moko.mvvm.compose.ViewModelFactory
import kotlin.reflect.KClass

class LoginVMFactory: ViewModelFactory<LoginViewModel> {
    override val kClass: KClass<LoginViewModel>
        get() = LoginViewModel::class

    override fun createViewModel(): LoginViewModel {
       return LoginViewModel()
    }
}