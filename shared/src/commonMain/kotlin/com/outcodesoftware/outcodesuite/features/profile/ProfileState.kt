package com.outcodesoftware.outcodesuite.features.profile

import com.outcodesoftware.outcodesuite.framework.ScreenState
import com.outcodesoftware.outcodesuite.framework.ViewState

class ProfileState : ProfileScreenState(), ViewState<ProfileState>{

}

sealed class ProfileScreenState(): ScreenState(){

}