package com.outcodesoftware.outcodesuite.features.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.outcodesoftware.outcodesuite.features.drawers.DrawerScreenItem


private val screens = listOf(
    DrawerScreenItem.Home,
    DrawerScreenItem.Leave,
    DrawerScreenItem.Attendance,
    DrawerScreenItem.Remarks,
    DrawerScreenItem.Profile,
)


@Composable
fun DrawerScreen(
    modifier: Modifier = Modifier,
    onDestinationClicked: (route: String) -> Unit
) {

    Column(
        modifier = modifier.fillMaxWidth(0.6f).fillMaxHeight()
            .background(color = MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.End,
    ) {

        Row (modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center){
            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle()) {
                        append("O")
                    }
                    append("ut")
                    withStyle(style = SpanStyle()) {
                        append("C")
                    }
                    append("ode")
                },
                modifier = Modifier.fillMaxWidth(),
                fontSize = 26.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier =Modifier.height(24.dp))
        screens.forEach { dashboardScreen ->
            Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp).clickable {
                onDestinationClicked(dashboardScreen.route)
            },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)){

                Icon(
                    imageVector = dashboardScreen.imageVector,
                    contentDescription = dashboardScreen.title
                )

                Text(
                    text = dashboardScreen.title,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(4.dp),
                    textAlign = TextAlign.Start
                )

                Text("")


            }

        }
    }


}

