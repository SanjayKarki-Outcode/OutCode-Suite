package com.outcodesoftware.outcodesuite.features.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.NavigatorDisposeBehavior
import cafe.adriel.voyager.navigator.currentOrThrow
import com.outcodesoftware.outcodesuite.features.attendance.AttendanceScreen
import com.outcodesoftware.outcodesuite.features.attendance.AttendanceViewModel
import com.outcodesoftware.outcodesuite.features.home.HomeScreen
import com.outcodesoftware.outcodesuite.features.home.HomeViewModel
import com.outcodesoftware.outcodesuite.features.leave.LeaveScreen
import com.outcodesoftware.outcodesuite.features.leave.LeaveViewModel
import com.outcodesoftware.outcodesuite.features.profile.ProfileScreen
import com.outcodesoftware.outcodesuite.features.remarks.RemarkScreen
import com.outcodesoftware.outcodesuite.features.remarks.RemarkViewModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

class DashboardMainScreen : Screen {

    val homeViewModel = HomeViewModel()
    val leaveViewModel = LeaveViewModel()
    val attendanceViewModel = AttendanceViewModel()
    val remarkViewModel = RemarkViewModel()

    @Composable
    override fun Content() {
        val navController = LocalNavigator.currentOrThrow

        DashboardMainScreen(
            navController,
            homeViewModel,
            leaveViewModel,
            attendanceViewModel,
            remarkViewModel
        )
    }
}

@OptIn(ExperimentalResourceApi::class, ExperimentalMaterial3Api::class)
@Composable
fun DashboardMainScreen(
    navController: Navigator,
    homeViewModel: HomeViewModel,
    leaveViewModel: LeaveViewModel,
    attendanceViewModel: AttendanceViewModel,
    remarkViewModel: RemarkViewModel
) {

    Surface(color = MaterialTheme.colorScheme.background) {
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        val scope = rememberCoroutineScope()
        val openDrawer = {
            scope.launch {
                drawerState.open()
            }
        }

        ModalNavigationDrawer(
            drawerContent = {
                AppDrawer(
                    route = "home",
                    navigateToHome = { navController.push(HomeScreen()) },
                    navigateToSettings = {  },
                    closeDrawer = { scope.launch { drawerState.close() } },
                    modifier = Modifier
                )
            }, drawerState = drawerState
//            drawerState = drawerState,
//            gesturesEnabled = drawerState.isOpen,
//            drawerContent = {
//                DrawerScreen(
//                    onDestinationClicked = { route ->
//                        scope.launch {
//                            drawerState.close()
//                        }
//                        navController.navigate(
//                            route, options = NavOptions(
//                                popUpTo = PopUpTo(route = route),
//                                launchSingleTop = true
//                            )
//                        )
//                    }
//                )
//            }
        ) {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text(text = "Home") },
                        modifier = Modifier.fillMaxWidth(),
                        navigationIcon = {
                            IconButton(onClick = {
                                scope.launch { drawerState.open() }
                            }, content = {
                                Icon(imageVector = Icons.Default.Menu, contentDescription = null)
                            })
                        }, colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primaryContainer))
                }, modifier = Modifier
            ){
//                val screenList : List<Screen> = listOf(
//                    HomeScreen(),
//                )
//               Navigator(
//                   screen = screenList.first(),
//                   onBackPressed = null,
//                   key = "2",
//                   content = {
//                    navController.push(HomeScreen())
//                   }
//               )

            }


        }
//        {
//
//
//            NavHost(
//                navigator = navController,
//                initialRoute = "/homepage"
//            ) {
//                scene(
//                    route = "/homepage"
//                ) {
//                    HomeScreen(
//                        openDrawer = {
//                            openDrawer()
//                        },
//                        state = homeViewModel.uiStateUI.collectAsState().value,
//                        onEvent = homeViewModel::onHandleEvent
//                    )
//                }
//
//                scene(route = "/leave") {
//                    LeaveScreen(
//                        openDrawer = {
//                            openDrawer()
//                        },
//                        state = leaveViewModel.uiStateUI.collectAsState().value,
//                        onEvent = leaveViewModel::onHandleEvent
//                    )
//                }
//
//                scene(route = "/attendance") {
//                    AttendanceScreen(
//                        openDrawer = {
//                            openDrawer()
//                        },
//                        state = attendanceViewModel.uiStateUI.collectAsState().value,
//                        onEvent = attendanceViewModel::onHandleEvent
//                    )
//                }
//
//                scene(route = "/remarks") {
//                    RemarkScreen(
//                        openDrawer = {
//                            openDrawer()
//                        },
//                        state = remarkViewModel.uiStateUI.collectAsState().value,
//                        onEvent = remarkViewModel::onHandleEvent
//                    )
//                }
//
//                scene(route = "/profile") {
//                    ProfileScreen(
//                        navController = navController
//                    )
//                }
//
//            }
//
//        }
    }



}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppDrawer(
    route: String,
    modifier: Modifier = Modifier,
    navigateToHome: () -> Unit,
    navigateToSettings: () -> Unit,
    closeDrawer: () -> Unit
) {
    ModalDrawerSheet(modifier = Modifier) {
        DrawerHeader(modifier)
        Spacer(modifier = Modifier.padding(5.dp))
        NavigationDrawerItem(
            label = {
                Text(
                    text = "Home",
                    style = MaterialTheme.typography.labelSmall
                )
            },
            selected = route == "home",
            onClick = {
                navigateToHome()
                closeDrawer()
            },
            icon = { Icon(imageVector = Icons.Default.Home, contentDescription = null) },
            shape = MaterialTheme.shapes.small
        )

        NavigationDrawerItem(
            label = { Text(text = "Sewttings", style = MaterialTheme.typography.labelSmall) },
            selected = route == "",
            onClick = {
                navigateToSettings()
                closeDrawer()
            },
            icon = { Icon(imageVector = Icons.Default.Person, contentDescription = null) },
            shape = MaterialTheme.shapes.small
        )
    }
}



@OptIn(ExperimentalResourceApi::class)
@Composable
fun DrawerHeader(modifier: Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
        modifier = modifier
            .background(MaterialTheme.colorScheme.secondary)
            .padding(15.dp)
            .fillMaxWidth()
    ) {

        Image(
            painterResource("ic_profile.png"),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier
                .size(70.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.padding(5.dp))

        Text(
            text = "OutCode Suite",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onPrimary,
        )
    }
}