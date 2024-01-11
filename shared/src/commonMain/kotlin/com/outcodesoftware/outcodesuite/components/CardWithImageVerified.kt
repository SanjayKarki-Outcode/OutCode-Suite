package com.outcodesoftware.outcodesuite.components

import androidx.compose.runtime.Composable
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.seiko.imageloader.rememberImagePainter
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun CardWithImageVerified(
    name: String? = "",
    mobileNumber: String? = "",
    imageUrl: String? = "",
    email: String? = "",
    status: Boolean? = false,
    designation: String? = ""
) {

    var statusColor =CardDefaults.cardColors(Color.Gray)

    if (status == true) {
        statusColor = CardDefaults.cardColors(Color.Green)
    }

    Card(
        modifier = Modifier
            .fillMaxWidth().alpha(0.85f)
            .padding(0.dp)
            .padding(top = 30.dp),
    ) {

        Box(
            modifier = Modifier.padding(top = 8.dp),
            contentAlignment = Alignment.Center
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Box(
                    modifier = Modifier.wrapContentSize(),
                    contentAlignment = Alignment.BottomCenter
                ) {

                    if (imageUrl.toString().isEmpty() || imageUrl.toString().equals("null", true)) {
                        Image(
                            modifier = Modifier
                                .size(150.dp)
                                .border(0.dp, MaterialTheme.colorScheme.secondary, CircleShape)
                                .clip(CircleShape),
                            painter = painterResource("ic_profile"),
                            contentDescription = "avatar",
                            contentScale = ContentScale.Crop,
                        )
                    } else {
                        Image(
                            modifier = Modifier
                                .size(150.dp)
                                .clip(CircleShape),
                            painter = rememberImagePainter(imageUrl!!),
                            contentDescription = "avatar",
                            contentScale = ContentScale.Crop,
                        )


                    }

                    Card(

                        shape = RoundedCornerShape(5.dp),
                        colors = statusColor

                    ) {

                        Row(
                            modifier = Modifier
                                .wrapContentSize()
                                .padding(vertical = 4.dp, horizontal = 4.dp),
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            if (status == true) {
                                Icon(
                                    modifier = Modifier
                                        .size(16.dp),
                                    imageVector = Icons.Default.CheckCircle,
                                    contentDescription = "Status",
//                                    tint = reso(SharedRes.colors.success_color)

                                )
                            } else {
                                Icon(
                                    modifier = Modifier
                                        .size(16.dp),
                                    imageVector = Icons.Default.Warning,
                                    contentDescription = "Status",
//                                    tint = colorResource(SharedRes.colors.warning_color)
                                )
                            }

                            Text(
                                text = if (status == true) "Verified" else "Processing",
                                color = Color.White,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        }

                    }
                }





                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Spacer(modifier = Modifier
                        .fillMaxWidth()
                        .height(10.dp))

                    Text(text = name.toString(), fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier
                        .fillMaxWidth()
                        .height(5.dp))

                    Text(
                        text = mobileNumber.toString(),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Spacer(modifier = Modifier
                        .fillMaxWidth()
                        .height(5.dp))

                    Text(text = email.toString(), fontSize = 14.sp, fontWeight = FontWeight.Medium)

                    Spacer(modifier = Modifier
                        .fillMaxWidth()
                        .height(10.dp))


                    Row() {
                        Icon(
                            imageVector =Icons.Default.DeveloperMode,
                            contentDescription = "icon",
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                        Spacer(modifier = Modifier.padding(4.dp))
                        Text(
                            text = designation ?: "Unknown",
                            color = MaterialTheme.colorScheme.onBackground,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold
                        )

                    }
                    Spacer(modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp))


                }
            }


        }
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(22.dp))


    }


}
