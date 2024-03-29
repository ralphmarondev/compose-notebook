package com.maronworks.composenotebook.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.maronworks.composenotebook.home.homeViewModel

@Composable
fun TopAboutCard() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(205.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .padding(10.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 10.dp, horizontal = 20.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Compose NoteBook",
                    fontWeight = FontWeight.W500
                )
                Text(text = "Version: 2024.03.28")
                Spacer(
                    modifier = Modifier
                        .padding(bottom = 20.dp)
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .clip(RoundedCornerShape(15.dp))
                .align(Alignment.BottomCenter)
                .background(Color.Transparent)
        ) {
            OutlinedTextField(
                value = homeViewModel.searchText.value,
                onValueChange = { value ->
                    homeViewModel.setSearchText(value)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 25.dp),
                placeholder = {
                    Text(text = "Search...")
                },
                colors = TextFieldDefaults.colors(
                    disabledContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White
                ),
                maxLines = 1
            )
        }
    }
}