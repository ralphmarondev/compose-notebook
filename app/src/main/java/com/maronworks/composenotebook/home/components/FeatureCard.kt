package com.maronworks.composenotebook.home.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maronworks.composenotebook.mainViewModel
import com.maronworks.composenotebook.ui.theme.ComposeNotebookTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeatureCard(
    modifier: Modifier = Modifier,
    @DrawableRes image: Int,
    title: String,
    subTitle: String,
    onClick: () -> Unit
) {
    ElevatedCard(
        onClick = {
            mainViewModel.toggleShowBottomBar()
            onClick()
        },
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = title,
                modifier = Modifier
                    .width(100.dp)
                    .height(65.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .padding(2.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = title,
                fontWeight = FontWeight.W500
            )
            Text(
                text = subTitle,
                fontWeight = FontWeight.W500,
                color = Color.LightGray
            )
        }
    }
}

@Preview
@Composable
private fun Default() {
    ComposeNotebookTheme {
//        Box(
//            modifier = Modifier.fillMaxSize(),
//            contentAlignment = Alignment.Center
//        ) {
//            FeatureCard(
//                image = R.drawable.sample_image,
//                title = "Engineering",
//                subTitle = "is fun"
//            )
//        }
    }
}