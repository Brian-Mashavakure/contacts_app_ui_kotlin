package com.contacts_app_ui.componets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.contacts_app_ui.R
import com.contacts_app_ui.screens.destinations.CodeScannerDestination
import com.contacts_app_ui.ui.theme.BlueColor
import com.contacts_app_ui.ui.theme.DarkerSecondaryColor
import com.contacts_app_ui.ui.theme.DarkerTextColor
import com.contacts_app_ui.ui.theme.LighterPrimaryColor
import com.contacts_app_ui.ui.theme.LighterSecondaryColor
import com.contacts_app_ui.ui.theme.PeachColor
import com.contacts_app_ui.ui.theme.PrimaryColor
import com.contacts_app_ui.ui.theme.SecondaryColor
import com.contacts_app_ui.ui.theme.TextColor
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    label: String,
    prefixIcon: Painter,
    iconDescription: String
){
    var text by remember{mutableStateOf(" ")}

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(8))
            .width(50.dp),
        value = text,
        onValueChange = {text = it},
        placeholder = {Text(label)},
        maxLines = 1,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = PrimaryColor,
            focusedBorderColor = SecondaryColor,
            cursorColor = SecondaryColor,
            placeholderColor = SecondaryColor,
        ),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        singleLine = true,
        leadingIcon = { Icon(painter = prefixIcon, contentDescription = iconDescription, tint = SecondaryColor)}
        )

}


@Composable
fun PictureIcon(){
    Box(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(80))
            .background(PeachColor)
            .width(120.dp)
            .height(120.dp)
            .padding(4.dp),
        contentAlignment = Alignment.Center,
    ){
        Icon(
            modifier = Modifier.size(50.dp),
            painter = painterResource(id = R.drawable.photo_camera),
            contentDescription = "Camera icon",
            tint = Color.White
        )
    }
}


@Composable
fun SearchedContactComponent(
    name: String,
    removeFunction: () -> Unit,
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(DarkerSecondaryColor)
            .padding(20.dp)
            .clip(RoundedCornerShape(20)),
        horizontalArrangement = Arrangement.SpaceBetween,

    ){
        Text(
            text = name,
            style = TextStyle(
                fontSize = 15.sp,
                color = TextColor,
                
            )
        )
        
        IconButton(
            onClick = {
                removeFunction
            }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.close),
                contentDescription = "Remove contact icon",
                tint = DarkerTextColor
            )
            
        }
    }
}


@Composable
fun ContactComponent(
    modifier: Modifier,
    contactName: String
){
    Row (
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(40))
            .background(LighterPrimaryColor)
            .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Box (
            modifier = Modifier
                .clip(shape = RoundedCornerShape(80))
                .background(PeachColor)
                .width(50.dp)
                .height(50.dp)
                .padding(12.dp),
            contentAlignment = Alignment.Center,
        ){
            Icon(
                modifier = Modifier.size(18.dp),
                painter = painterResource(id = R.drawable.person),
                contentDescription =" Person icon",
                tint = Color.White
            )
        }

        Spacer(modifier = Modifier.width(15.dp))

        Text(
            modifier = Modifier.padding(12.dp),
            text = contactName,
            style = TextStyle(
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = TextColor
            )
        )


    }

}
