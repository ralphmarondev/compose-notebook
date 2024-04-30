package com.maronworks.composenotebook.home.features.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maronworks.composenotebook.R

@Composable
fun FeatureCard(
    modifier: Modifier = Modifier,
    containerColor: Color,
    textColor: Color,
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = containerColor,
            contentColor = textColor
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(minHeight = 120.dp)
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.cute_me),
                contentDescription = "",
                modifier = Modifier
                    .size(75.dp)
                    .border(2.dp, Color.Magenta, CircleShape)
                    .padding(5.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 15.dp)
            ) {
                Text(
                    text = "Ralph Maron Eda",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W500
                )
                Text(
                    text = "Computer Engineering",
                    fontSize = 14.sp
                )
                Text(
                    text = "Mobile Developer",
                    fontSize = 14.sp
                )
                Text(
                    text = "Web Developer",
                    fontSize = 14.sp
                )
            }
        }
    }
}
