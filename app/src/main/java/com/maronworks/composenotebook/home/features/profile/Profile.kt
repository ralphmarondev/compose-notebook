package com.maronworks.composenotebook.home.features.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddBox
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maronworks.composenotebook.R
import com.maronworks.composenotebook.home.features.profile.components.CardButtons
import com.maronworks.composenotebook.home.features.profile.domain.listOfCardButton
import com.maronworks.composenotebook.ui.theme.ComposeNotebookTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Profile(
    fullName: String,
    username: String,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Profile",
                        fontFamily = FontFamily.Monospace
                    )
                },
                actions = {
                    val actionIcon = listOf(
                        Icons.Outlined.AddBox,
                        Icons.Outlined.Menu
                    )

                    actionIcon.forEach {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = it,
                                contentDescription = ""
                            )
                        }
                    }
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(vertical = 15.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.cute_me),
                    contentDescription = "",
                    modifier = Modifier
                        .size(85.dp)
                        .border(
                            width = 2.dp,
                            brush = Brush.linearGradient(
                                listOf(
                                    Color.Magenta,
                                    Color.Blue
                                )
                            ),
                            shape = CircleShape
                        )
                        .padding(5.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(8.dp))
                Text(text = fullName)
                Text(text = username)

                Spacer(modifier = Modifier.height(15.dp))
                repeat(listOfCardButton.size) {
                    CardButtons(
                        modifier = Modifier
                            .padding(vertical = 5.dp, horizontal = 10.dp),
                        icon = listOfCardButton[it].icon,
                        text = listOfCardButton[it].text
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun Default() {
    ComposeNotebookTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Profile(
                fullName = "Ralph Maron Eda",
                username = "@ralphmaron"
            )
        }
    }
}