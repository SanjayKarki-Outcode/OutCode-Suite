package com.outcodesoftware.outcodesuite.features.remarks

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.outcodesoftware.outcodesuite.components.CustomAppBar
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun RemarkScreen(
    openDrawer: () -> Unit,
    state: RemarkState,
    onEvent: (RemarkEvent) -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource("stars_galaxy.png"),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )

        RemarkContent(
            openDrawer,
            onEvent,
            state
        )
    }
}

@Composable
fun RemarkContent(openDrawer: () -> Unit, onEvent: (RemarkEvent) -> Unit, state: RemarkState) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopStart,
        propagateMinConstraints = false
    ){
        CustomAppBar(
            title = "Remarks",
            buttonIcon = Icons.Filled.Menu,
            onButtonClicked = { openDrawer() }
        )
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(top = 50.dp).padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {

        }
    }
}
