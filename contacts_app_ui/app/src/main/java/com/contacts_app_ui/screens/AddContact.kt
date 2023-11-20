package com.contacts_app_ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.contacts_app_ui.R
import com.contacts_app_ui.componets.CustomTextField
import com.contacts_app_ui.componets.PictureIcon
import com.contacts_app_ui.screens.destinations.MainScreenDestination
import com.contacts_app_ui.ui.theme.PrimaryColor
import com.contacts_app_ui.ui.theme.SecondaryColor
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalMaterial3Api::class)
@Destination
@Composable
fun AddContact(
    navigator: DestinationsNavigator
){
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(PrimaryColor)
    ) {
        Scaffold(
            bottomBar = {
                BottomAppBar(
                    containerColor = PrimaryColor,
                    contentColor = SecondaryColor,
                    contentPadding = PaddingValues(10.dp),
                    actions = {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly,
                        ){
                            TextButton(
                                modifier = Modifier.fillMaxHeight(),
                                onClick = {
                                    navigator.navigateUp()
                                }
                            ) {
                                Text(
                                    text = stringResource(id = R.string.cancel),
                                    style = TextStyle(
                                        color = SecondaryColor,
                                        fontSize = 23.sp,
                                    ),
                                )
                            }

                            TextButton(
                                modifier = Modifier.fillMaxHeight(),
                                onClick = {
                                    navigator.navigate(MainScreenDestination)
                                }
                            ) {
                                Text(
                                    text = stringResource(id = R.string.save),
                                    style = TextStyle(
                                        color = SecondaryColor,
                                        fontSize = 23.sp,
                                    )
                                )
                            }

                        }
                    }

                )
            }
        ){innerPadding ->
            Surface(
                modifier = Modifier.fillMaxWidth()
                    .fillMaxHeight()
                    .background(PrimaryColor)
                    .padding(innerPadding)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(PrimaryColor),
                    verticalArrangement = Arrangement.Center
                ){

                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center,
                    ){
                        PictureIcon()
                    }

                    Spacer(modifier = Modifier.height(25.dp))

                    CustomTextField(
                        label = stringResource(id = R.string.name),
                        prefixIcon = painterResource(id = R.drawable.person),
                        iconDescription = stringResource(id = R.string.name),
                    )

                    Spacer(modifier = Modifier.height(9.dp))


                    CustomTextField(
                        label = stringResource(id = R.string.phone),
                        prefixIcon = painterResource(id = R.drawable.phone),
                        iconDescription = stringResource(id = R.string.phone),
                    )

                    Spacer(modifier = Modifier.height(9.dp))

                    CustomTextField(
                        label = stringResource(id = R.string.email),
                        prefixIcon = painterResource(id = R.drawable.mail),
                        iconDescription = stringResource(id = R.string.email),
                    )

                    Spacer(modifier = Modifier.height(9.dp))

                    CustomTextField(
                        label = stringResource(id = R.string.groups),
                        prefixIcon = painterResource(id = R.drawable.groups),
                        iconDescription = stringResource(id = R.string.groups),
                    )

                    Spacer(modifier = Modifier.height(9.dp))
                }

            }

        }

    }

}

