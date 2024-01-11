package com.outcodesoftware.outcodesuite.features.drawers

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector


sealed class DrawerScreenItem (val title: String, val route: String, val imageVector: ImageVector){
    object Home: DrawerScreenItem("Home", "/homepage", Icons.Default.Home)
    object Leave: DrawerScreenItem("Leave","/leave",Icons.Default.Fingerprint)
    object Attendance: DrawerScreenItem("Attendance","/attendance",Icons.Default.Timer)
    object Remarks: DrawerScreenItem("Remarks","/remarks",Icons.Default.Chat)
    object Profile: DrawerScreenItem("Profile","/profile",Icons.Default.Person)
}
