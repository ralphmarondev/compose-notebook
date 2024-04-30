package com.maronworks.composenotebook.home.features.home.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp

@Composable
fun SearchField(
    modifier: Modifier = Modifier,
    textColor: Color,
) {
    var query by remember { mutableStateOf("") }

    OutlinedTextField(
        modifier = modifier,
        value = query,
        onValueChange = {
            query = it
        },
        placeholder = {
            Text(
                text = "Search...",
                color = textColor
            )
        },
        textStyle = TextStyle(
            fontFamily = FontFamily.Monospace,
            color = textColor,
            fontSize = 16.sp
        ),
        trailingIcon = {
            Icon(
                imageVector = Icons.Outlined.Search,
                contentDescription = "",
                tint = textColor
            )
        },
        singleLine = true
    )
}