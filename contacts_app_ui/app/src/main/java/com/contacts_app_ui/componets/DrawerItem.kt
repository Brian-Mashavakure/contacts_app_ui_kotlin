package com.contacts_app_ui.componets

import androidx.compose.ui.graphics.painter.Painter

data class DrawerItem(
    /*TODO: Add routes for navigation */
    val title: String,
    val icon: Painter,
    val badgeCount: Int? = null
)

