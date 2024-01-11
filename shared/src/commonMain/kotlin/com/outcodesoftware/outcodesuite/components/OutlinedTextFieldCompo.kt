package com.outcodesoftware.outcodesuite.components


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutlinedTextFieldCompo(
    placeholderText: String,
    value: String,
    imageVector: ImageVector,
    onValueChanged: (String) -> Unit,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    keyboardActions: KeyboardActions = KeyboardActions { },
    keyboardCapitalization: KeyboardCapitalization = KeyboardCapitalization.None,
    paddingTop: Dp = 8.dp,
    paddingBottom: Dp = 8.dp,
    paddingStart: Dp = 8.dp,
    paddingEnd: Dp = 8.dp,
    enable: Boolean = true,
    leadingIcon : Boolean = true,
) {

        OutlinedTextField(
            value = value,
            onValueChange = { onValueChanged(it) },
            //   label = { Text(text = label) },
            placeholder = { Text(text = placeholderText) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                capitalization = keyboardCapitalization,
                keyboardType = keyboardType,
                imeAction = imeAction
            ),
            leadingIcon =  {
                if(leadingIcon) {

                    Icon(
                        imageVector = imageVector,
                        contentDescription = "icon",
                    )

                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = paddingTop,
                    start = paddingStart,
                    end = paddingEnd,
                    bottom = paddingBottom
                ),

            keyboardActions = keyboardActions,
            enabled = enable,
//        colors = TextFieldDefaults.outlinedTextFieldColors(
//            focusedBorderColor = colorResource(SharedRes.colors.primaryColor),
//            unfocusedBorderColor = colorResource(SharedRes.colors.border),
//            disabledBorderColor = colorResource(SharedRes.colors.white),
//        ),

        )




}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutlinedTextFieldCompo(
    placeholderText: String,
    value: String,
    onValueChanged: (String) -> Unit,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    keyboardActions: KeyboardActions = KeyboardActions { },
    keyboardCapitalization: KeyboardCapitalization = KeyboardCapitalization.None,
    paddingTop: Dp = 8.dp,
    paddingBottom: Dp = 8.dp,
    paddingStart: Dp = 8.dp,
    paddingEnd: Dp = 8.dp,
    enable: Boolean = true,
) {

    OutlinedTextField(
        value = value,
        onValueChange = { onValueChanged(it) },
        //   label = { Text(text = label) },
        placeholder = { Text(text = placeholderText) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            capitalization = keyboardCapitalization,
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = paddingTop,
                start = paddingStart,
                end = paddingEnd,
                bottom = paddingBottom
            ),

        keyboardActions = keyboardActions,
        enabled = enable,
//        colors = TextFieldDefaults.outlinedTextFieldColors(
//            focusedBorderColor = colorResource(SharedRes.colors.primaryColor),
//            unfocusedBorderColor = colorResource(SharedRes.colors.border),
//            disabledBorderColor = colorResource(SharedRes.colors.white),
//        ),

    )




}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutlinedTextFieldCompo(
    placeholderText: String,
    value: String,
    onValueChanged: (String) -> Unit,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    keyboardActions: KeyboardActions = KeyboardActions { },
    keyboardCapitalization: KeyboardCapitalization = KeyboardCapitalization.None,
    paddingTop: Dp = 8.dp,
    paddingBottom: Dp = 8.dp,
    paddingStart: Dp = 8.dp,
    paddingEnd: Dp = 8.dp,
    enable: Boolean = true,
    maxText : Int,
) {
        OutlinedTextField(
            value = value,
            onValueChange = { if(it.length <= maxText) onValueChanged(it) },
            //   label = { Text(text = label) },
            placeholder = { Text(text = placeholderText, maxLines = 1) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                capitalization = keyboardCapitalization,
                keyboardType = keyboardType,
                imeAction = imeAction
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = paddingTop,
                    start = paddingStart,
                    end = paddingEnd,
                    bottom = paddingBottom
                ),

            keyboardActions = keyboardActions,
            enabled = enable,
//            colors = TextFieldDefaults.outlinedTextFieldColors(
//                focusedBorderColor = colorResource(SharedRes.colors.primaryColor),
//                unfocusedBorderColor = colorResource(SharedRes.colors.white),
//                disabledBorderColor = colorResource(SharedRes.colors.white),
//            ),
        )
        Text(
            text = "${value.length} / $maxText",
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 16.dp),
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.headlineMedium,
        )

}

