package com.contacts_app_ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun SearchContact(
    navigator: DestinationsNavigator
){
    Text(
        text = "Search Contacts Page"
    )

}