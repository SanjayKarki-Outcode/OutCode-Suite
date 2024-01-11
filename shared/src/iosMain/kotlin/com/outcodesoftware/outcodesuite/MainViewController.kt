package com.outcodesoftware.outcodesuite

import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIScreen
import platform.UIKit.UIUserInterfaceStyle

@Suppress("FunctionName","unused")
fun MainViewController() = ComposeUIViewController {
    val isDarkTheme =
        UIScreen.mainScreen.traitCollection.userInterfaceStyle ==
                UIUserInterfaceStyle.UIUserInterfaceStyleDark
    App(darkTheme = isDarkTheme, dynamicColor = false)
}