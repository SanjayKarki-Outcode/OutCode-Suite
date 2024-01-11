package com.outcodesoftware.outcodesuite.features.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import com.outcodesoftware.outcodesuite.components.CardUpComingEvents
import com.outcodesoftware.outcodesuite.components.CardWithImageText
import com.outcodesoftware.outcodesuite.components.CustomAppBar
import com.outcodesoftware.outcodesuite.components.BottomSheetCompo
import com.outcodesoftware.outcodesuite.components.OutlinedTextFieldCompo
import com.outcodesoftware.outcodesuite.utils.DateAndTimeUtils
import epicarchitect.calendar.compose.basis.config.rememberBasisEpicCalendarConfig
import epicarchitect.calendar.compose.datepicker.EpicDatePicker
import epicarchitect.calendar.compose.datepicker.config.rememberEpicDatePickerConfig
import epicarchitect.calendar.compose.datepicker.state.EpicDatePickerState
import epicarchitect.calendar.compose.datepicker.state.rememberEpicDatePickerState
import epicarchitect.calendar.compose.pager.EpicCalendarPager
import epicarchitect.calendar.compose.pager.config.rememberEpicCalendarPagerConfig
import epicarchitect.calendar.compose.pager.state.rememberEpicCalendarPagerState
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

class HomeScreen : Screen{
    val homeViewModel = HomeViewModel()

    @Composable
    override fun Content() {
        HomeScreen(
            openDrawer = {},
            state = homeViewModel.uiStateUI.collectAsState().value,
            onEvent = {}
        )
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun HomeScreen(
    openDrawer: () -> Unit,
    state: HomeState,
    onEvent: (HomeEvent) -> Unit
) {

//InitDependency(state)
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {

        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource("stars_galaxy.png"),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )



        HomeContent(openDrawer, onEvent, state)

    }

}

@Composable
fun InitDependency(
    state: HomeState
) {

}


@Composable
fun HomeContent(
    openDrawer: () -> Unit,
    onEvent: (HomeEvent) -> Unit,
    state: HomeState

) {


    val upComingEventsList = listOf(
        ItemEvent(name = "Some events are coming up next", icon = Icons.Default.Event),
        ItemEvent(name = "Your friend\'s birthday is near", icon = Icons.Default.Cake),
        ItemEvent(name = "Your leave is approved", icon = Icons.Default.ThumbUp),
        ItemEvent(name = "Your remark is rejected", icon = Icons.Default.ThumbDown),
    )

    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
    ) {

        CustomAppBar(
            title = "Home",
            buttonIcon = Icons.Filled.Menu,
            onButtonClicked = { openDrawer() }
        )

        Column(
            modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {


            Row(
                modifier = Modifier.fillMaxWidth()
                    .background(
                        color = MaterialTheme.colorScheme.tertiaryContainer.copy(alpha = 0.7f),
                        shape = RoundedCornerShape(8.dp)
                    ),
            ) {

                CardWithImageText(
                    modifier = Modifier.weight(0.33f).clickable {
                        onEvent(HomeEvent.OnApplyLeave)
                    },
                    painter = Icons.Default.TimeToLeave,
                    title = "Apply Leave",
                    borderColor = Color.Green,
                )
                CardWithImageText(
                    modifier = Modifier.weight(0.33f).clickable {
                        onEvent(HomeEvent.OnApplyAttendance)
                    },
                    painter = Icons.Default.AvTimer,
                    title = "Send Attendance",
                    borderColor = Color.Yellow,
                )
                CardWithImageText(
                    modifier = Modifier.weight(0.33f).clickable {
                        onEvent(HomeEvent.OnApplyRemarks)
                    },
                    painter = Icons.Default.Chat,
                    title = "Send Remarks",
                    borderColor = Color.Red,
                )


            }



            LazyColumn(
                modifier = Modifier.height(145.dp)
            ) {
                items(upComingEventsList.size) { items ->
                    CardUpComingEvents(upComingEventsList[items])
                    Spacer(modifier = Modifier.height(4.dp))
                }
            }


            Box(
                modifier = Modifier.background(
                    color = MaterialTheme.colorScheme.tertiaryContainer.copy(
                        alpha = 0.7f
                    )
                )
            ) {

                EpicCalendarPager(
                    state = rememberEpicCalendarPagerState(
                        config = rememberEpicCalendarPagerConfig(
                            basisConfig = rememberBasisEpicCalendarConfig(
                                contentColor = MaterialTheme.colorScheme.primary,
                                displayDaysOfAdjacentMonths = false
                            )
                        ),

                        ),
                    pageModifier = { Modifier },
                    dayOfMonthContent = {
                        Text(it.dayOfMonth.toString())
                    },
                    onDayOfMonthClick = {

                    }
                )

            }


        }


    }

    ApplyLeave(
        isOpen = state.isLeaveSheetVisible.collectAsState().value,
        onEvent = onEvent,
        state = state
    )

    ApplyAttendance(
        isApplyAttendance = state.isApplyingAttendance.collectAsState().value,
        onEvent = onEvent,
        state = state
    )

    ApplyRemarks(
        isApplyRemark = state.isApplyingRemarks.collectAsState().value,
        onEvent = onEvent,
        state = state
    )

}

@Composable
fun ApplyRemarks(
    isApplyRemark: Boolean,
    onEvent: (HomeEvent) -> Unit,
    state: HomeState,
    modifier: Modifier = Modifier
) {

    BottomSheetCompo(
        visible = isApplyRemark,
        modifier = modifier.fillMaxSize().alpha(0.8f)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopStart
        ) {
            IconButton(
                onClick = {
                    onEvent(HomeEvent.OnApplyRemarks)
                }
            ) {
                Icon(
                    imageVector = Icons.Rounded.Close,
                    contentDescription = null
                )
            }

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Spacer(modifier = Modifier.height(40.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,

                    ) {
                    Text(text = "Date: ${DateAndTimeUtils.today}", fontWeight = FontWeight.SemiBold)
                    Text(
                        text = "Time: ${DateAndTimeUtils.timeNow}",
                        fontWeight = FontWeight.SemiBold
                    )

                }

                Text(text = "Remarks Type")
                Text("Drop Down menu will be here.")

                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                    Button(onClick = {
                        onEvent(HomeEvent.OnRemarksSubmit)
                    }, modifier = Modifier.fillMaxWidth()) {
                        Text("Submit", modifier = Modifier.padding(4.dp))
                    }
                }

            }

        }
    }
}

@Composable
fun ApplyAttendance(
    isApplyAttendance: Boolean,
    onEvent: (HomeEvent) -> Unit,
    state: HomeState,
    modifier: Modifier = Modifier
) {

    val (selectedOption, onOptionSelected) = remember { mutableStateOf(state.attendanceType[0]) }

    BottomSheetCompo(
        visible = isApplyAttendance,
        modifier = modifier.fillMaxSize().alpha(0.8f)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopStart
        ) {
            IconButton(
                onClick = {
                    onEvent(HomeEvent.OnApplyAttendance)
                }
            ) {
                Icon(
                    imageVector = Icons.Rounded.Close,
                    contentDescription = null
                )
            }

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Spacer(modifier = Modifier.height(40.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,

                    ) {
                    Text(text = "Date: ${DateAndTimeUtils.today}", fontWeight = FontWeight.SemiBold)
                    Text(
                        text = "Time: ${DateAndTimeUtils.timeNow}",
                        fontWeight = FontWeight.SemiBold
                    )

                }

                Text(
                    text = "Attendance Type",
                    fontSize = MaterialTheme.typography.titleMedium.fontSize,
                    fontWeight = FontWeight.SemiBold
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    state.attendanceType.forEach { text ->
                        Row(
                            Modifier.wrapContentWidth().selectable(
                                selected = (text == selectedOption),
                                onClick = {
                                    onOptionSelected(text)
                                }
                            ).padding(horizontal = 16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = (text == selectedOption),
                                onClick = { onOptionSelected(text) }
                            )
                            Text(
                                text = text,
                                style = MaterialTheme.typography.bodySmall.merge(),
                                modifier = Modifier.padding(start = 16.dp)
                            )
                        }
                    }
                }



                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                    Button(onClick = {
                        onEvent(HomeEvent.OnAttendanceSubmit)
                    }, modifier = Modifier.fillMaxWidth()) {
                        Text("Submit", modifier = Modifier.padding(4.dp))
                    }
                }

            }

        }
    }
}


@Composable
fun ApplyLeave(
    isOpen: Boolean,
    onEvent: (HomeEvent) -> Unit,
    state: HomeState,
    modifier: Modifier = Modifier
) {
    val selectFromDate = rememberEpicDatePickerState(
        selectionMode = EpicDatePickerState.SelectionMode.Single(),

        )
    BottomSheetCompo(
        visible = isOpen,
        modifier = modifier.fillMaxSize().alpha(0.8f)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopStart
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = {
                        onEvent(HomeEvent.OnApplyLeave)
                    }
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Close,
                        contentDescription = null
                    )
                }

                Text(
                    text = "Leave Request",
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.primary
                )

            }

            Column(
                modifier = Modifier.fillMaxWidth(),
//                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Spacer(modifier = Modifier.height(40.dp))


                Text(
                    text = "Subject",
                    fontSize = MaterialTheme.typography.titleMedium.fontSize,
                    fontWeight = FontWeight.SemiBold
                )
                Text("Here will be drop down menu")



                Text(
                    "Reason",
                    fontSize = MaterialTheme.typography.titleMedium.fontSize,
                    fontWeight = FontWeight.SemiBold
                )
                OutlinedTextFieldCompo(
                    placeholderText = "Enter your leave reason",
                    value = state.etLeaveReason.collectAsState().value,
                    onValueChanged = {
                        onEvent(HomeEvent.OnLeaveReasonChange(it))
                    },
                    keyboardType = KeyboardType.Text
                )


                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {


                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Button(
                            modifier = Modifier.weight(0.5f),
                            onClick = {
                                state.isFullDay.value = true
                            },
                            enabled = state.isFullDay.collectAsState().value,
                            content = { Text("Full Day") },
                        )
                        Button(
                            modifier = Modifier.weight(0.5f),
                            onClick = {
                                state.isFullDay.value = false
                            },
                            enabled = !state.isFullDay.collectAsState().value,
                            content = { Text("Half Day") },

                            )
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Button(
                            modifier = Modifier.weight(0.5f),
                            onClick = {
                                state.isFullDay.value = true
                            },
                            content = { Text("") },
                            colors = ButtonDefaults.buttonColors(
                                contentColor = Color.Transparent,
                                disabledContentColor = Color.Transparent,
                                containerColor = Color.Transparent,
                                disabledContainerColor = Color.Transparent
                            )

                        )
                        Button(
                            modifier = Modifier.weight(0.5f),
                            onClick = {
                                state.isFullDay.value = false
                            },
                            content = { Text("") },
                            colors = ButtonDefaults.buttonColors(
                                contentColor = Color.Transparent,
                                disabledContentColor = Color.Transparent,
                                containerColor = Color.Transparent,
                                disabledContainerColor = Color.Transparent
                            )
                        )
                    }

                }



                Text(
                    "Duration",
                    fontSize = MaterialTheme.typography.titleMedium.fontSize,
                    fontWeight = FontWeight.SemiBold
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    OutlinedButton(onClick = {
                        state.showDatePIck.value = true
                        state.datePicker.value = "from"

                    }, modifier = Modifier.wrapContentSize()) {
                        Text(text = state.selectedFrom.collectAsState().value)
                    }
                    Text("-")
                    OutlinedButton(onClick = {
                        state.showDatePIck.value = true
                        state.datePicker.value = "to"

                    }, modifier = Modifier.wrapContentSize()) {
                        Text(state.selectedTo.collectAsState().value)
                    }


                }

                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                    OutlinedButton(onClick = {
                        onEvent(HomeEvent.OnLeaveSubmit)
                    }, modifier = Modifier.fillMaxWidth()) {
                        Text("Submit", modifier = Modifier.padding(4.dp))
                    }
                }
                datePicker(state)


            }


        }
    }
}

@Composable
fun datePicker(
    stated: HomeState
) {
    if (stated.showDatePIck.collectAsState().value) {

        val eState = rememberEpicDatePickerState(
            config = rememberEpicDatePickerConfig(
                pagerConfig = rememberEpicCalendarPagerConfig(
                    basisConfig = rememberBasisEpicCalendarConfig(
                        displayDaysOfAdjacentMonths = false
                    )
                ),
                selectionContentColor = MaterialTheme.colorScheme.onPrimary,
                selectionContainerColor = MaterialTheme.colorScheme.primary
        )
        )

        EpicDatePicker(state = eState)




        if(eState.selectedDates.toString().isNotEmpty() && !eState.selectedDates.toString().equals("[]")){
            if(stated.datePicker.value == "to"){
                stated.selectedTo.value = eState.selectedDates.toString().substring(1,11).trim()

            } else{
                stated.selectedFrom.value = eState.selectedDates.toString().substring(1,11).trim()

            }

            stated.showDatePIck.value = false
        }

    }
}

data class ItemEvent(val name: String, val icon: ImageVector)



