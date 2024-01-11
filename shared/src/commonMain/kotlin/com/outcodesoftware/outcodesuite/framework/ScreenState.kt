package com.outcodesoftware.outcodesuite.framework

import kotlinx.coroutines.flow.MutableStateFlow

open class ScreenState {

    object EMPTY: ScreenState()

    data class LOADING(val run: Boolean, val message: String = "Please wait...") : ScreenState()
    val isLoading = MutableStateFlow<LOADING?>(null)

    data class SHOWCONFIRMATIONDIAlOG<T>(
        val run: Boolean,
        val message: String? = null,
        val positiveBtnTitle: String? = null,
        val negativeBtnTitle: String? = null,
        val enableNegativeButton: Boolean = false,
        val data: T? = null
    ) : ScreenState()

    data class ERROR(val run:Boolean,val error: String?=null) : ScreenState()

    val isError = MutableStateFlow<ERROR?>(null)
    data class LOGOUTDIALOG(val run: Boolean): ScreenState()
    val isLogout = MutableStateFlow<LOGOUTDIALOG?>(null)
    data class SUCCESS<T>(val run: Boolean,val data: T?=null) : ScreenState()
}