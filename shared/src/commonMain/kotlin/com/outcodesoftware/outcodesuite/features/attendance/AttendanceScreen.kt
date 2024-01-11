package com.outcodesoftware.outcodesuite.features.attendance

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.outcodesoftware.outcodesuite.components.CustomAppBar
import com.outcodesoftware.outcodesuite.utils.DateAndTimeUtils
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun AttendanceScreen(
    openDrawer: () -> Unit,
    state: AttendanceState,
    onEvent: (AttendanceEvent) -> Unit
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
        AttendanceContent(
            openDrawer = openDrawer,
            onEvent = onEvent,
            state = state
        )
    }
}


@Composable
fun AttendanceContent(
    openDrawer: () -> Unit,
    onEvent: (AttendanceEvent) -> Unit,
    state: AttendanceState
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopStart,
        propagateMinConstraints = false
    ) {
        CustomAppBar(
            title = "Attendance",
            buttonIcon = Icons.Filled.Menu,
            onButtonClicked = { openDrawer() }
        )
        LazyColumn(
            modifier = Modifier.padding(top = 50.dp).padding(
                horizontal = 16.dp
            ),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(5) {
                MyAttendanceCard()
            }
        }
    }
}

@Composable
fun MyAttendanceCard() {

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {

        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = DateAndTimeUtils.today.toString(),
                    fontSize = MaterialTheme.typography.bodySmall.fontSize
                )
                Text(
                    text = "[${DateAndTimeUtils.today.dayOfWeek.name.substring(0, 3)}]",
                    fontSize = MaterialTheme.typography.bodySmall.fontSize
                )
            }

            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween){
                Text("00:00:00,00:00:00", fontSize = MaterialTheme.typography.bodyMedium.fontSize)
                Text("0hrs 0mins", fontSize = MaterialTheme.typography.bodyLarge.fontSize)
            }

        }

    }


}