package com.contacts_app_ui.componets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.contacts_app_ui.screens.destinations.CodeScannerDestination
import com.contacts_app_ui.ui.theme.PrimaryColor
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
            .clip(shape = RoundedCornerShape(8)),
        value = text,
        onValueChange = {text = it},
        label = {Text(label)},
        maxLines = 1,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = PrimaryColor,
            focusedBorderColor = PrimaryColor,
            cursorColor = PrimaryColor
        ),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        singleLine = true,
        leadingIcon = { Icon(painter = prefixIcon, contentDescription = iconDescription)}
        )

}
