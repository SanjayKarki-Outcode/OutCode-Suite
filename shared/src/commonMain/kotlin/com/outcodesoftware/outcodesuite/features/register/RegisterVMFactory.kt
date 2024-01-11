package com.outcodesoftware.outcodesuite.features.register

import dev.icerock.moko.mvvm.compose.ViewModelFactory
import kotlin.reflect.KClass

class RegisterVMFactory: ViewModelFactory<RegisterViewModel> {
    override val kClass: KClass<RegisterViewModel>
        get() = RegisterViewModel::class

    override fun createViewModel(): RegisterViewModel {
        return RegisterViewModel()
    }

}