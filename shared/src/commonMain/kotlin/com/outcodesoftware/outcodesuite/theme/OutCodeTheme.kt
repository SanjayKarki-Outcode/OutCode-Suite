package com.outcodesoftware.outcodesuite.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
expect fun OutCodeTheme(
    darkTheme: Boolean,
    dynamicColor: Boolean,
    content: @Composable() () -> Unit
)