package com.maronworks.composenotebook.onboarding.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TitleDescription(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight.W500
        )

        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = description,
            minLines = 2
        )
    }
}