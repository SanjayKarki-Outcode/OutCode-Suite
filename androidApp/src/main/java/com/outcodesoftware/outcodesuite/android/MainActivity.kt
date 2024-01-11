package com.outcodesoftware.outcodesuite.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import com.outcodesoftware.outcodesuite.App


class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(darkTheme = isSystemInDarkTheme(), dynamicColor = true)
        }
    }
}
