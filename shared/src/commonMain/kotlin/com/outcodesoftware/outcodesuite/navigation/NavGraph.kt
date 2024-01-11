package com.outcodesoftware.outcodesuite.navigation

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import com.outcodesoftware.outcodesuite.features.dashboard.DashboardMainScreen
import com.outcodesoftware.outcodesuite.features.login.LoginScreen
import com.outcodesoftware.outcodesuite.features.login.LoginViewModel
import com.outcodesoftware.outcodesuite.features.register.RegisterScreen

@Composable
fun NavGraph(
    navigator: Navigator,
) {
    val loginVM = LoginViewModel()

//    NavHost(
//        navigator = navigator,
//        initialRoute = Screen.Login.route,
//    ) {
//
//
//        // (:login Route)
//        scene(
//            route = Screen.Login.route,
//        ) {
//            LoginScreen(
//                navigator = navigator,
//                viewModel = loginVM
//            )
//        }
//
//        // (:register route)
//        scene(
//            route = Screen.Register.route,
//        ) {
//            RegisterScreen(
//                navigator = navigator
//            )
//        }
//
//        // (:homepage route)
//        scene(
//            route = Screen.Dashboard.route,
//        ) {
//            DashboardMainScreen()
//        }
//
//
//    }

}