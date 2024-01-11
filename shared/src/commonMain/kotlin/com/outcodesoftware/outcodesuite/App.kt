package com.outcodesoftware.outcodesuite

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.outcodesoftware.outcodesuite.features.welcome.WelcomeScreenModel
import com.outcodesoftware.outcodesuite.theme.OutCodeTheme

@Composable
fun App(
    darkTheme: Boolean,
    dynamicColor: Boolean,
) {

    OutCodeTheme(
        darkTheme = darkTheme,
        dynamicColor = dynamicColor,
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
           Navigator(WelcomeScreenModel(), onBackPressed = {_ -> false})
        }
    }

}