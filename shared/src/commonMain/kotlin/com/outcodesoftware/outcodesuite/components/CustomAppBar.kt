package com.outcodesoftware.outcodesuite.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomAppBar(
    label : String? = "",
    isBackIcon: Boolean = false,
    onClick: () -> Unit
){

    TopAppBar(
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor =Color.Transparent),
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = label!!, color = MaterialTheme.colorScheme.primary)
            }
        },

        navigationIcon = {
            if(isBackIcon){
                IconButton(onClick = { onClick() },){
                    Icon(imageVector = Icons.Default.ArrowBackIosNew, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                }
            }
        },
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomAppBar(
    title: String = "",
    buttonIcon: ImageVector,
    onButtonClicked: () -> Unit
){
    TopAppBar(
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor =Color.Transparent),
        title = {
            Text(
                text = title,
                color = MaterialTheme.colorScheme.primary
            )
        },
        navigationIcon = {
            IconButton(onClick = { onButtonClicked() } ) {
                Icon(buttonIcon, contentDescription = "",tint = MaterialTheme.colorScheme.primary)
            }
        },


    )
}


//TopAppBarColors(
//containerColor = MaterialTheme.colorScheme.background,
//scrolledContainerColor = Color.Transparent,
//navigationIconContentColor = Color.Transparent,
//titleContentColor = MaterialTheme.colorScheme.onBackground,
//actionIconContentColor = Color.Transparent
//)