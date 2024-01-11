package com.outcodesoftware.outcodesuite.features.leave

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.HolidayVillage
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.outcodesoftware.outcodesuite.components.CustomAppBar
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun LeaveScreen(
    openDrawer: () -> Unit,
    state: LeaveState,
    onEvent: (LeaveEvent) -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource("stars_galaxy.png"),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
        LeaveContent(
            openDrawer, onEvent, state
        )
    }

}

@Composable
fun LeaveContent(
    openDrawer: () -> Unit,
    onEvent: (LeaveEvent) -> Unit,
    state: LeaveState
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopStart,
        propagateMinConstraints = false
    ) {
        CustomAppBar(
            title = "Leave",
            buttonIcon = Icons.Filled.Menu,
            onButtonClicked = { openDrawer() }
        )
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(top = 50.dp).padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {


            items(10) {
                var mColor = if (it % 2 == 0 && it % 3 == 0) {
                    Color.Red
                } else if (it % 5 == 0) {
                    Color.Yellow
                } else {
                    Color.Green.copy(red = 0.6f, green = 0.8f, blue = 0.4f)
                }
                LeaveCard(mColor)
            }


        }


    }

}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun LeaveCard(
    sColor: Color,
) {

    Card(
        modifier = Modifier.fillMaxWidth().alpha(0.8f),
//        colors = CardDefaults.cardColors(containerColor = sColor)
    ) {

        Box(
            contentAlignment = Alignment.BottomEnd
        ) {
            Image(
                painter = painterResource("bg_vacation.png"),
                modifier = Modifier.size(120.dp).alpha(0.6f),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.onBackground)
            )
            Column(
                modifier = Modifier.padding(8.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Text(
                            text = "From: ",
                            fontWeight = FontWeight.SemiBold,
                            fontSize = MaterialTheme.typography.bodySmall.fontSize
                        )
                        Text(
                            text = "2023-08-08 - 2023-08-08",
                            fontSize = MaterialTheme.typography.bodySmall.fontSize
                        )
                    }

//                    Row(
//                        horizontalArrangement = Arrangement.SpaceBetween,
//                        verticalAlignment = Alignment.CenterVertically
//
//                    ) {
//                        Text("Status: ", fontWeight = FontWeight.SemiBold, fontSize = MaterialTheme.typography.bodySmall.fontSize)
                    Text(
                        "PENDING",
                        modifier = Modifier.padding()
                            .background(sColor, shape = RoundedCornerShape(5.dp)).padding(4.dp),
                        fontSize = MaterialTheme.typography.bodySmall.fontSize
                    )
//                    }

                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    Text(
                        "No Of Day(s): ",
                        fontWeight = FontWeight.Bold,
                        fontSize = MaterialTheme.typography.bodyMedium.fontSize
                    )
                    Text(
                        "1",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = MaterialTheme.typography.bodyLarge.fontSize
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Type: ",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = MaterialTheme.typography.bodySmall.fontSize
                    )
                    Text(
                        "Sick Leave (PAID)",
                        fontSize = MaterialTheme.typography.bodySmall.fontSize
                    )
                }

//                Row (
//                    modifier =Modifier.fillMaxWidth(),
//                    verticalAlignment = Alignment.CenterVertically
//
//                ){
//                    Text("Reason: ", fontWeight = FontWeight.SemiBold, fontSize = MaterialTheme.typography.bodySmall.fontSize)
//                    Text(
//                        "Feeling unwell, high fever, sore throat, running nose cannot be available for few days.",
//                        fontSize = MaterialTheme.typography.bodySmall.fontSize,
//                        softWrap = false,
//                        overflow = TextOverflow.Ellipsis,
//                        maxLines = 1
//                    )
//                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically

                ) {

                    OutlinedButton(
                        onClick = {},
                        modifier = Modifier.wrapContentSize()
                    ) {
                        Text("View Details")
                    }

                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "Status By: ",
                            fontWeight = FontWeight.SemiBold,
                            fontSize = MaterialTheme.typography.bodySmall.fontSize
                        )
                        Text("Manager", fontSize = MaterialTheme.typography.bodySmall.fontSize)
                    }
                }


            }

        }


    }

}