package com.outcodesoftware.outcodesuite.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource


@OptIn(ExperimentalResourceApi::class)
@Composable
fun BottomSheetCompo(
    visible: Boolean,
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
){


    AnimatedVisibility(
        visible = visible,
        enter = slideInVertically (
            animationSpec = tween(durationMillis = 300),
            initialOffsetY = {it}
        ),
        exit = slideOutVertically(
            animationSpec = tween(durationMillis = 300),
            targetOffsetY = {it}
        ),
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center,
        ) {

            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource("star_galaxy"),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
            Column(
                modifier = modifier
                    .clip(
                        RoundedCornerShape(
                            topStart = 30.dp,
                            topEnd = 30.dp
                        )
                    )
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(16.dp)
            ) {
                content()
            }
        }
    }
}