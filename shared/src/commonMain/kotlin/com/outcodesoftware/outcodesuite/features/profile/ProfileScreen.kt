package com.outcodesoftware.outcodesuite.features.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.*
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.outcodesoftware.outcodesuite.components.CardWithImageVerified
import com.outcodesoftware.outcodesuite.components.CustomAppBar
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource


class ProfileScreen : Screen{
    @Composable
    override fun Content() {
        ProfileScreen(LocalNavigator.currentOrThrow)
    }
}

@Composable
fun ProfileScreen(
    navController : Navigator
) {


    ScaffoldScreenProfile(
        navController
    )


}


@OptIn(ExperimentalResourceApi::class)
@Composable
fun ScaffoldScreenProfile(
    navController: Navigator
) {


        Scaffold(
            topBar = {
//                CustomAppBar(label = "Profile", isBackIcon = true)
            }
        ) {

            Box(modifier = Modifier.padding(it)) {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource("stars_galaxy.png"),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds
                )

                ProfileContent()
                CustomAppBar(label = "Profile", isBackIcon = true, onClick = {
                    navController.pop()
                })

            }

        }





}

@Composable
fun ProfileContent() {



    Column(
        modifier = Modifier.fillMaxSize().padding( top = 40.dp, start = 16.dp, end = 16.dp)
            .verticalScroll(
                rememberScrollState()
            )
    ) {


        CardWithImageVerified(
            name = "Sanjay Karki",
            mobileNumber = "+977 9842250093",
            imageUrl = null,
            email = "sanjayusk786@gmail.com",
            status = false,
            designation = "Software Engineer"
        )



    }
}