package com.contacts_app_ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.contacts_app_ui.R
import com.contacts_app_ui.componets.DrawerItem
import com.contacts_app_ui.ui.theme.LighterSecondaryColor
import com.contacts_app_ui.ui.theme.PrimaryColor
import com.contacts_app_ui.ui.theme.SecondaryColor
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(){

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
                                unselectedContainerColor = SecondaryColor
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
                                onClick = { /*TODO*/ }
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.search),
                                    contentDescription = "Search Icon"
                                )

                            }

                            //add more icon
                            IconButton(
                                onClick = { /*TODO*/ }
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.add),
                                    contentDescription = "Add more Icon"
                                )

                            }

                            //options icon
                            IconButton(
                                onClick = { /*TODO*/ }
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.options),
                                    contentDescription = "Options Icon"
                                )

                            }

                        }
                    )

                }
            ) {innerPadding ->
                Column(
                    modifier = Modifier.padding(innerPadding)
                ){}

            }

        }
    }


}

@Preview
@Composable
fun MainScreenPreview(){
    MainScreen()
}