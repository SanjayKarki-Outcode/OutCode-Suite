package com.outcodesoftware.outcodesuite.features.welcome


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.outcodesoftware.outcodesuite.features.login.LoginScreen
import com.outcodesoftware.outcodesuite.features.login.LoginViewModel
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

class WelcomeScreenModel: Screen{
    @Composable
    override fun Content() {
        WelcomeScreen(LocalNavigator.currentOrThrow)
    }
}


@OptIn(ExperimentalResourceApi::class)
@Composable
fun WelcomeScreen(
    navigator: Navigator
) {

    InitDependency(
        navigator = navigator
    )

//
    var count = 5
    var visible :Boolean by remember { mutableStateOf(false) }
    val density = LocalDensity.current
//
    Box(
        Modifier.fillMaxSize().background(color = Color.White),
        contentAlignment = Alignment.Center,
    ) {
        visible = true


        Column {

            AnimatedVisibility(
                visible = visible,
                enter = slideInHorizontally()+ fadeIn(
                    initialAlpha = 0.3f
                )
            ){
                Image(
                    painter = painterResource("outcode_suite_main.png"),
                    contentDescription = "OutCode Suite Logo",
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.Fit
                )
            }

           AnimatedVisibility(
               visible = visible,
               enter = slideInHorizontally {
                   with(density) { -40.dp.roundToPx()}
               }
           ){
               Text(
                   text = "Welcome To Outcode Suite",
                   modifier = Modifier.fillMaxWidth(),
                   textAlign = TextAlign.Center,
//                   color = colorResource(SharedRes.colors.accentColor),
                   fontSize = 24.sp,
                   fontWeight = FontWeight.SemiBold
               )
           }


        }


    }


}

@Composable
fun InitDependency(
    navigator: Navigator
){
    LaunchedEffect(key1 = null){
        delay(3000)
        val loginViewModel = LoginViewModel()
        navigator.push(LoginScreen(loginViewModel))
    }
}