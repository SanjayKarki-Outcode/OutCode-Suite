package com.outcodesoftware.outcodesuite.features.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.outcodesoftware.outcodesuite.components.PasswordCompo
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource


class RegisterScreen : Screen{
    @Composable
    override fun Content() {
        RegisterScreen(LocalNavigator.currentOrThrow)
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun RegisterScreen(
    navigator: Navigator
){

    var etEmail: String by remember {
        mutableStateOf("")
    }

    var etNewPassword: String by remember {
        mutableStateOf("")
    }

    var etCPassword: String by remember {
        mutableStateOf("")
    }

    val focusManager = LocalFocusManager.current

    Box(
        modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background) .pointerInput(Unit) {
            detectTapGestures(onTap = {
                focusManager.clearFocus()
            })
        },
        contentAlignment = Alignment.Center
    ) {

        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource("stars_galaxy.png"),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )

        Column(
            Modifier.fillMaxWidth().padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 16.dp)
                .background(MaterialTheme.colorScheme.background.copy(alpha = 0.8f),shape = RoundedCornerShape(10.dp))
                .padding(8.dp)
                .verticalScroll(rememberScrollState())
            ,
        ) {

            Spacer(Modifier.height(8.dp))

            Text(
                text = "Create Password",
                fontSize = 22.sp,
                fontWeight = FontWeight.Medium
            )

            Spacer(Modifier.height(16.dp))

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    "Employee Id or Email",
                    fontWeight = FontWeight.Bold
                )

                OutlinedTextField(
                    value = etEmail,
                    onValueChange = {
                        etEmail = it
                    },
                    modifier = Modifier.fillMaxWidth().padding(8.dp),
                    singleLine = true,
                    placeholder = { Text(text = "Enter your employee id or email.") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = "Employee id or email is invalid"
                        )
                    }
                )

                Spacer(Modifier.height(4.dp))

                Text("New Password", fontWeight = FontWeight.Bold)


                PasswordCompo(
                    "New Password",
                    "New Password",
                    etNewPassword,
                    onPasswordChanged = { etNewPassword = it },
                    ImeAction.Default
                )

                Text("Confirm Password", fontWeight = FontWeight.Bold)


                PasswordCompo(
                    "Confirm Password",
                    "Confirm Password",
                    etCPassword,
                    onPasswordChanged = { etCPassword = it },
                    ImeAction.Default
                )

                Spacer(Modifier.height(8.dp))

                Button(onClick = {}, modifier = Modifier.fillMaxWidth()) {
                    Text("Save", modifier = Modifier.padding(4.dp))
                }

                Spacer(Modifier.height(8.dp))

                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End){
                  Text("Already created profile?")
                    Spacer(modifier = Modifier.width(8.dp))
                  Text("Log In",modifier =Modifier.clickable {
//                                            navigator.push(route = "/login",
//
//                                                options = NavOptions(
//                                                    launchSingleTop = true,
//                                                    popUpTo = PopUpTo(
//                                                        route = "/login",
//                                                        inclusive = true,
//
//                                                    ),
//
//                                                )
//                                            )
                  }, color = MaterialTheme.colorScheme.primary)
                }

            }
        }

    }
}