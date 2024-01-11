package com.outcodesoftware.outcodesuite.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ExpandCircleDown
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.outcodesoftware.outcodesuite.features.home.ItemEvent

@Composable
fun CardUpComingEvents(
    eventList: ItemEvent
) {

    Row(
        modifier = Modifier.fillMaxSize()
            .background(
                color = MaterialTheme.colorScheme.tertiaryContainer.copy(alpha = 0.7f),
                shape = RoundedCornerShape(10.dp)
            )
            .padding(horizontal = 8.dp,vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {

        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            Icon(
                imageVector = eventList.icon,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.tertiary
            )

            Text(text = eventList.name, textAlign = TextAlign.Start)
        }


        Icon(
            imageVector = Icons.Outlined.ExpandCircleDown,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.tertiary
        )


    }


}