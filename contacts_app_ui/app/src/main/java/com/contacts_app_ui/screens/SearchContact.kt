package com.contacts_app_ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.contacts_app_ui.R
import com.contacts_app_ui.componets.SearchedContactComponent
import com.contacts_app_ui.ui.theme.LighterSecondaryColor
import com.contacts_app_ui.ui.theme.PrimaryColor
import com.contacts_app_ui.ui.theme.SecondaryColor
import com.contacts_app_ui.ui.theme.TextColor
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalMaterial3Api::class)
@Destination
@Composable
fun SearchContact(
    navigator: DestinationsNavigator
){


    var namesList = listOf("Brian", "Danie", "Tafadzwa", "Natasha", "Eli", "Tobbie", "Shamiso","Brian", "Danie", "Tafadzwa",)
    var textValue by remember {mutableStateOf(" ")}
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(PrimaryColor)
    ){
        Scaffold(
            containerColor = PrimaryColor,
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.smallTopAppBarColors(
                        containerColor = SecondaryColor,
                    ),
                    title = {
                            TextField(
                                modifier = Modifier.clip(RoundedCornerShape(8)),
                                colors = TextFieldDefaults.textFieldColors(
                                    containerColor = LighterSecondaryColor,
                                    focusedIndicatorColor = SecondaryColor,
                                    cursorColor = SecondaryColor
                                ),
                                value = textValue,
                                onValueChange = {textValue = it},
                                placeholder = {Text("Search")},
                                singleLine = true,
                                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search)
                            )
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                navigator.navigateUp()
                            }) {
                            Icon(
                                painter = painterResource(id = R.drawable.back_arrow),
                                contentDescription = "Back Arrow",
                            )
                        }

                    },
                    actions = {
                        //voice search
                        IconButton(
                            onClick = { /*TODO*/ }
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.mic),
                                contentDescription = "Voice Search"
                            )
                        }
                        //search settings
                        IconButton(
                            onClick = { /*TODO*/ }
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.settings),
                                contentDescription = "Search Settings"
                            )
                        }
                    }

                )
            }

        ) {innerPadding ->
           Surface (
               modifier = Modifier.padding(innerPadding)
           ){
               Column(
                   modifier = Modifier.fillMaxSize().background(PrimaryColor)
               ){

                   Text(
                       text = "Recent Searches",
                       style = TextStyle(
                           fontSize = 15.sp,
                           color = TextColor,
                       )
                   )

                   Spacer(modifier = Modifier.height(5.dp))

                   LazyColumn(
                       modifier = Modifier.fillMaxWidth().padding(5.dp),
                       content = {
                           itemsIndexed(
                               //listOf("Brian", "Danie", "Tafadzwa", "Natasha", "Eli", "Tobbie", "Shamiso","Brian", "Danie", "Tafadzwa",)
                               namesList
                           ){
                                   index, string -> SearchedContactComponent(
                                            name = string,
                                            removeFunction = {
                                                
                                            }
                                   )
                           }
                       }
                   )
               }
           }
        }
    }

}