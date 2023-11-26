package com.contacts_app_ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.contacts_app_ui.R
import com.contacts_app_ui.componets.Contact
import com.contacts_app_ui.ui.theme.DarkerSecondaryColor
import com.contacts_app_ui.ui.theme.PrimaryColor
import com.contacts_app_ui.ui.theme.SecondaryColor
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalMaterial3Api::class)
@Destination
@Composable
fun ViewContactScreen(
    navigator: DestinationsNavigator,
    contact: Contact
){
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(PrimaryColor)
    ) {
        Scaffold(
            containerColor = PrimaryColor,
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.smallTopAppBarColors(
                        containerColor = PrimaryColor
                    ),
                    title = { /*TODO*/ },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                navigator.navigateUp()
                            }
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.back_arrow),
                                contentDescription = "Back Arrow "
                            )                            
                        }
                    }
                )
            },

            bottomBar = {
                BottomAppBar(
                    containerColor = PrimaryColor,
                    //contentColor = SecondaryColor,
                    contentPadding = PaddingValues(10.dp),
                ) {
                   Row(
                       modifier = Modifier.fillMaxWidth(),
                       horizontalArrangement = Arrangement.SpaceBetween,
                   ){
                       IconButton(
                           onClick = { /*TODO*/ }
                       ) {
                           Icon(
                               painter = painterResource(id = R.drawable.star),
                               contentDescription = "Favorites Icon",
                               tint = DarkerSecondaryColor,
                           )
                       }

                       IconButton(
                           onClick = { /*TODO*/ }
                       ) {
                           Icon(
                               painter = painterResource(id = R.drawable.edit),
                               contentDescription = "Edit Icon"
                           )
                       }

                       IconButton(
                           onClick = { /*TODO*/ }
                       ) {
                           Icon(
                               painter = painterResource(id = R.drawable.share),
                               contentDescription = "Share Icon"
                           )
                       }

                       IconButton(
                           onClick = { /*TODO*/ }
                       ) {
                           Icon(
                               painter = painterResource(id = R.drawable.options),
                               contentDescription = "More Options"
                           )
                       }

                   }

                }

            }

        ) {innerPadding ->
            Column(
                modifier = Modifier.padding(innerPadding)
            ) {
                Text(
                    text = contact.name
                )

                Text(
                    text = contact.number
                )

        }

        }

    }
}