package com.outcodesoftware.outcodesuite.features.login

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.outcodesoftware.outcodesuite.components.OutlinedTextFieldCompo
import com.outcodesoftware.outcodesuite.components.PasswordCompo
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource


data class LoginScreen(private val loginViewModel: LoginViewModel) : Screen {
    @Composable
    override fun Content() {
        LoginScreen(LocalNavigator.currentOrThrow, loginViewModel)
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun LoginScreen(
    navigator: Navigator,
    viewModel: LoginViewModel
) {


    val state by viewModel.uiStateUI.collectAsState()

    val onEvent: (LoginEvent) -> Unit = { viewModel.onHandleEvent(it) }

    val focusManager = LocalFocusManager.current

    Scaffold() {

        Box(
            modifier = Modifier.fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center,
        ) {

            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource("stars_galaxy.png"),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )

            Column(
                Modifier
                    .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 16.dp)
                    .background(
                        MaterialTheme.colorScheme.background.copy(alpha = 0.8f),
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(8.dp)
                    .pointerInput(Unit) {
                        detectTapGestures(onTap = {
                            focusManager.clearFocus()
                        })
                    }
                    .verticalScroll(rememberScrollState())
            ) {

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Welcome To",
                    fontSize = 26.sp,
                    textAlign = TextAlign.Center
                )

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
                Spacer(Modifier.height(8.dp))

                Text(
                    "Login",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.SemiBold
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

                    OutlinedTextFieldCompo(
                        placeholderText = "Enter your employee id or email",
                        value = state.etEmail.collectAsState().value,
                        onValueChanged = {
                            onEvent(LoginEvent.OnEmailChange(it))
                        },
                        imageVector = Icons.Default.Mail,
                        imeAction = ImeAction.Next,
                        leadingIcon = true,
                        keyboardType = KeyboardType.Email,
                        keyboardActions = KeyboardActions(onNext = {
                            focusManager.moveFocus(
                                FocusDirection.Down
                            )
                        })
                    )

                    Spacer(Modifier.height(4.dp))

                    Text("Password", fontWeight = FontWeight.Bold)


                    PasswordCompo(
                        label = "Password",
                        placeholderText = "Password",
                        password = state.etPassword.collectAsState().value,
                        onPasswordChanged = { onEvent(LoginEvent.OnPasswordChange(it)) },
                        ImeAction.Default,
                    )

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(
                            checked = state.rememberMe.collectAsState().value,
                            onCheckedChange = { onEvent(LoginEvent.OnRememberMe(!state.rememberMe.value)) },
                            enabled = true
                        )
                        Text("Remember Me?", modifier = Modifier.clickable {
                            onEvent(LoginEvent.OnRememberMe(!state.rememberMe.value))
                        }, fontWeight = FontWeight.Medium)
                    }

                    Spacer(Modifier.height(4.dp))

                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                        Button(onClick = {
                            onEvent(LoginEvent.OnLoginClick(navigator))
                        }, modifier = Modifier.fillMaxWidth()) {
                            Text("Login", modifier = Modifier.padding(4.dp))
                        }
                    }

                }

                Spacer(Modifier.height(6.dp))


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("")
                    Text(
                        "Forgot Password?",
                        modifier = Modifier.clickable {
                            onEvent(LoginEvent.OnForgotPasswordClick(navigator))
                        },
//                        color = colorResource(SharedRes.colors.darkPrimaryColor),
                        fontWeight = FontWeight.SemiBold,
                        textDecoration = TextDecoration.Underline
                    )
                }

                Spacer(Modifier.height(10.dp))

                Text(
                    text = "Problem while login.",
                    fontSize = 12.sp,
                    modifier = Modifier.padding(4.dp)
                )


            }
        }

    }

}





