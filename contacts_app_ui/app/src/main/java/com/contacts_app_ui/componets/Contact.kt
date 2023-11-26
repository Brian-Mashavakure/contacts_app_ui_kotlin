package com.contacts_app_ui.componets

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Contact(
    val name: String,
    val number: String,
):Parcelable