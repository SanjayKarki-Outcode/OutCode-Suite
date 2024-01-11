package com.outcodesoftware.outcodesuite.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CardWithImageText(
    modifier: Modifier = Modifier,
    painter: ImageVector,
    title: String,
    borderColor: Color = Color.Gray
) {

    OutlinedCard(
        modifier = modifier.padding(3.dp),
        border = BorderStroke(width = 1.dp,color = borderColor)

        ) {

        Row(
            modifier = Modifier.fillMaxWidth().height(75.dp).padding(start = 2.dp),
            horizontalArrangement = Arrangement.spacedBy(2.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                imageVector = painter,
                contentDescription = null,
                modifier = Modifier.size(35.dp),
                tint = MaterialTheme.colorScheme.tertiary
            )

            Text(
                text = title,
                softWrap =true,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )
        }


    }


}
