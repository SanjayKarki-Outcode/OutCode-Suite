package com.outcodesoftware.outcodesuite.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordCompo(
    label: String = "Password",
    placeholderText: String = "Password",
    password: String,
    onPasswordChanged: (String) -> Unit,
    imeAction: ImeAction = ImeAction.Next,
    keyboardActions: KeyboardActions = KeyboardActions { },
) {

    var passwordVisibility: Boolean by remember { mutableStateOf(false) }
    OutlinedTextField(
        value = password,
        onValueChange = { onPasswordChanged(it) },
//      label = { Text(text = label) },
        singleLine = true,
        placeholder = { Text(text = placeholderText) },
        visualTransformation =
        if (passwordVisibility) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = imeAction
        ),
        keyboardActions = keyboardActions,
        leadingIcon = {
                Icon(
                    imageVector = Icons.Default.VpnKey,
                    contentDescription = "password icon"
                )
        },
        trailingIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                val image = if (passwordVisibility) {
                    Icons.Default.Visibility
                } else {
                    Icons.Default.VisibilityOff
                }
                IconButton(onClick = {
                    passwordVisibility = !passwordVisibility
                }) {
                    Icon(
                        imageVector = image,
                        contentDescription = "password icon"
                    )
                }
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),

//        colors = TextFieldDefaults.outlinedTextFieldColors(
//            focusedBorderColor = Color.Red,
//            unfocusedBorderColor = Color.Blue,
//        )
        )

}

