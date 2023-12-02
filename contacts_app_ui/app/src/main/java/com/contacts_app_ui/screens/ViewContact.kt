package com.contacts_app_ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.contacts_app_ui.R
import com.contacts_app_ui.componets.Contact
import com.contacts_app_ui.componets.PictureIcon
import com.contacts_app_ui.ui.theme.DarkerSecondaryColor
import com.contacts_app_ui.ui.theme.LighterPrimaryColor
import com.contacts_app_ui.ui.theme.LighterSecondaryColor
import com.contacts_app_ui.ui.theme.PeachColor
import com.contacts_app_ui.ui.theme.PrimaryColor
import com.contacts_app_ui.ui.theme.SecondaryColor
import com.contacts_app_ui.ui.theme.TextColor
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
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(PrimaryColor)
                    .padding(innerPadding)
            ){
                Column(
                    modifier = Modifier.fillMaxSize().background(PrimaryColor),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ){

                   Box(
                       modifier = Modifier.fillMaxWidth(),
                       contentAlignment = Alignment.Center
                   ){
                       PictureIcon(
                           painterResource = painterResource(id = R.drawable.photo_camera),
                           backgroundColor = LighterSecondaryColor,
                       )
                   }

                    Spacer(modifier = Modifier.height(25.dp))

                    Text(
                        text = contact.name,
                        style = TextStyle(
                            fontSize = 23.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextColor
                        )
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = contact.number,
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextColor
                        )
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ){

                        Box(
                            modifier = Modifier
                                .clip(shape = RoundedCornerShape(80))
                                .background(LighterSecondaryColor)
                                .width(55.dp)
                                .height(55.dp)
                                .padding(4.dp),
                            contentAlignment = Alignment.Center
                        ){
                            IconButton(
                                onClick = { /*TODO*/ }
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.phone),
                                    contentDescription = "Make phone call"
                                )
                            }
                        }

                        Box(
                            modifier = Modifier
                                .clip(shape = RoundedCornerShape(80))
                                .background(LighterSecondaryColor)
                                .width(55.dp)
                                .height(55.dp)
                                .padding(4.dp),
                            contentAlignment = Alignment.Center
                        ){
                            IconButton(
                                onClick = { /*TODO*/ }
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.sms),
                                    contentDescription = "Send sms"
                                )
                            }
                        }


                       Box(
                           modifier = Modifier
                               .clip(shape = RoundedCornerShape(80))
                               .background(LighterSecondaryColor)
                               .width(55.dp)
                               .height(55.dp)
                               .padding(4.dp),
                           contentAlignment = Alignment.Center
                       ){
                           IconButton(
                               onClick = { /*TODO*/ }
                           ) {
                               Icon(
                                   painter = painterResource(id = R.drawable.video_call),
                                   contentDescription = "Make video call"
                               )
                           }
                       }

                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(60))
                            .background(LighterPrimaryColor)
                            .width(200.dp),
                        contentAlignment = Alignment.Center,
                    ){
                        Text(
                            modifier = Modifier.padding(10.dp),
                            text = stringResource(id = R.string.history),
                            style = TextStyle(
                                fontSize = 18.sp,
                                color = TextColor
                            )
                        )
                    }

                    Spacer(modifier = Modifier.height(15.dp))

                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(60))
                            .background(LighterPrimaryColor)
                            .width(200.dp),
                        contentAlignment = Alignment.Center,
                    ){
                        Text(
                            modifier = Modifier.padding(10.dp),
                            text = stringResource(id = R.string.storage_locations),
                            style = TextStyle(
                                fontSize = 18.sp,
                                color = TextColor
                            )
                        )
                    }



                }

            }

        }

    }
}