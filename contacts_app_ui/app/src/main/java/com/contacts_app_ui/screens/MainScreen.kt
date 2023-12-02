package com.contacts_app_ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.contacts_app_ui.R
import com.contacts_app_ui.componets.Contact
import com.contacts_app_ui.componets.ContactComponent
import com.contacts_app_ui.componets.DrawerItem
import com.contacts_app_ui.screens.destinations.AddContactDestination
import com.contacts_app_ui.screens.destinations.CodeScannerDestination
import com.contacts_app_ui.screens.destinations.SearchContactDestination
import com.contacts_app_ui.screens.destinations.ViewContactScreenDestination
import com.contacts_app_ui.ui.theme.LighterSecondaryColor
import com.contacts_app_ui.ui.theme.PrimaryColor
import com.contacts_app_ui.ui.theme.SecondaryColor
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.launch


@Destination(start = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navigator: DestinationsNavigator
){

    //list of contact names
    val contactNames = listOf(
        Contact(
            name = " Amai ", 
            number = " 0772676611"
        ),

        Contact(
            name = " Amelia ",
            number = " 0772676611"
        ),

        Contact(
            name = " Anakin ",
            number = " 0772676611"
        ),

        Contact(
            name = " Anesu ",
            number = " 0772676611"
        ),

        Contact(
            name = " Ban ",
            number = " 0772676611"
        ),

        Contact(
            name = " Brian ",
            number = " 0772676611"
        ),

        Contact(
            name = " Cillian ",
            number = " 0772676611"
        ),

        Contact(
            name = " Darth Vader ",
            number = " 0772676611"
        ),

        Contact(
            name = " Dazai ",
            number = " 0772676611"
        ),

        Contact(
            name = " Eriksen ",
            number = " 0772676611"
        ),

        Contact(
            name = " Emiya ",
            number = " 0772676611"
        ),

        Contact(
            name = " Fagioli ",
            number = " 0772676611"
        ),

        Contact(
            name = " Goku ",
            number = " 0772676611"
        ),

        Contact(
            name = " Grandmaster Zeno ", 
            number = " 0772676611"
        ),

        Contact(
            name = " Kakarot ",
            number = " 0772676611"
        ),

        Contact(
            name = " Lucas ", 
            number = " 0772676611"
        ),
        
        Contact(
            name = " Maximus ", 
            number = " 0772676611"
        ),

    )


    //list of navigation bar items
    val drawerItems = listOf(
        DrawerItem(
            title = stringResource(id = R.string.contacts),
            icon = painterResource(id = R.drawable.contacts),
            badgeCount = 20
        ),
        DrawerItem(
            title = stringResource(id = R.string.groups),
            icon = painterResource(id = R.drawable.groups),
        ),
        DrawerItem(
            title = stringResource(id = R.string.sim),
            icon = painterResource(id = R.drawable.sim_card),
        ),
        DrawerItem(
            title = stringResource(id = R.string.manage),
            icon = painterResource(id = R.drawable.manage),
        ),
        DrawerItem(
            title = stringResource(id = R.string.recycle_bin),
            icon = painterResource(id = R.drawable.delete),
        ),
        DrawerItem(
            title = stringResource(id = R.string.settings),
            icon = painterResource(id = R.drawable.settings),
        )
    )


    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = PrimaryColor
    ){
        ModalNavigationDrawer(
            modifier = Modifier.background(SecondaryColor),

            drawerContent = {
                
                ModalDrawerSheet(
                    drawerShape = MaterialTheme.shapes.extraSmall,
                    drawerContainerColor = SecondaryColor,
                    drawerTonalElevation = 4.dp,
                ) {
                    Spacer(modifier = Modifier.height(20.dp))

                    drawerItems.forEachIndexed { index, item ->
                        NavigationDrawerItem(
                            label = {
                                Text(text = item.title)
                            },

                            selected = index == selectedItemIndex,

                            onClick = {
                                selectedItemIndex = index
                                scope.launch{
                                    drawerState.close()
                                }
                            },

                            icon = {
                                Icon(
                                    painter = item.icon,
                                    contentDescription = item.title
                                )
                            },

                            badge = {
                                item.badgeCount?.let{
                                    Text(text = item.badgeCount.toString())
                                }
                            },

                            modifier = Modifier
                                .padding(NavigationDrawerItemDefaults.ItemPadding),
                            colors = NavigationDrawerItemDefaults.colors(
                                selectedContainerColor = LighterSecondaryColor,
                                unselectedContainerColor = SecondaryColor,
                                unselectedTextColor = Color.Black,
                            )

                        )
                    }
                }
            },
            drawerState = drawerState
        ) {
            Scaffold(
                containerColor = PrimaryColor,
                topBar = {
                    TopAppBar(
                        colors = TopAppBarDefaults.smallTopAppBarColors(
                            containerColor = SecondaryColor,
                        ),
                        title = {
                            Text(
                                text = stringResource(id = R.string.appbar_title),

                                )
                        },
                        navigationIcon = {
                            //menu icon
                            IconButton(
                                onClick = {
                                    scope.launch{
                                        drawerState.open()
                                    }
                                }
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.menu),
                                    contentDescription = "Menu Icon",
                                )

                            }
                        },
                        actions = {
                            //search icon
                            IconButton(
                                onClick = {
                                    navigator.navigate(SearchContactDestination)
                                }
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.search),
                                    contentDescription = "Search Icon"
                                )

                            }

                            //add more icon
                            IconButton(
                                onClick = {
                                    navigator.navigate(AddContactDestination)
                                }
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.add),
                                    contentDescription = "Add more Icon"
                                )

                            }

                            //options icon
                            IconButton(
                                onClick = {
                                    
                                }
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.qr_code),
                                    contentDescription = "QR Code Icon"
                                )

                            }

                        }
                    )

                }
            ) {innerPadding ->
                Surface(
                    modifier = Modifier.fillMaxWidth().padding(innerPadding),
                    color = PrimaryColor
                ){
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth(),
                        content = {
                            itemsIndexed(
                                contactNames
                            ){
                                    index, contactName -> ContactComponent(
                                modifier = Modifier.padding(5.dp).clickable {
                                    navigator.navigate(
                                        ViewContactScreenDestination(
                                            Contact(
                                                name = contactName.name,
                                                number = contactName.number
                                            )
                                        )
                                    )
                                },
                                contactName = contactName.name
                            )
                            }
                        }
                    )
                }

            }

        }
    }


}

