package com.maronworks.composenotebook.mini_apps.instagram.home.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Send
import androidx.compose.material.icons.outlined.AddComment
import androidx.compose.material.icons.outlined.BookmarkAdd
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maronworks.composenotebook.R
import com.maronworks.composenotebook.mini_apps.instagram.home.domain.post.PostModel
import com.maronworks.composenotebook.mini_apps.instagram.ui.theme.InstagramTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImageCard(
    modifier: Modifier = Modifier.padding(10.dp),
    onMoreClick: () -> Unit,
    post: PostModel,
) {
    val pagerState = rememberPagerState {
        post.images.size
    }

    ElevatedCard(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = 10.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, bottom = 5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = post.profilePicture),
                    contentDescription = post.profileName,
                    modifier = Modifier
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
                        .clip(CircleShape)
                        .size(50.dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.padding(start = 10.dp))
                Text(text = post.profileName)

                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = onMoreClick) {
                    Icon(
                        imageVector = Icons.Outlined.MoreVert,
                        contentDescription = ""
                    )
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                HorizontalPager(
                    state = pagerState,
                    modifier = Modifier
                        .wrapContentSize()
                ) { index ->
                    Image(
                        painter = painterResource(id = post.images[index]),
                        contentDescription = "",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(250.dp),
                        contentScale = ContentScale.Crop
                    )
                }

                Row(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(15.dp)
                ) {
                    repeat(pagerState.pageCount) { index ->
                        val color =
                            if (pagerState.currentPage == index) MaterialTheme.colorScheme.primary else Color.LightGray

                        Spacer(modifier = Modifier.width(2.dp))
                        Box(
                            modifier = Modifier
                                .size(12.dp)
                                .clip(CircleShape)
                                .background(color)
                        )
                        Spacer(modifier = Modifier.width(2.dp))
                    }
                }
            }

            ReactionButtons()

            Divider()
            Column(
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .padding(top = 5.dp)
            ) {
                Text(text = post.description)
                Text(text = post.datePosted)
            }
        }
    }
}

@Composable
private fun ReactionButtons() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val listOfIcons = listOf(
            Icons.Outlined.FavoriteBorder,
            Icons.Outlined.AddComment,
            Icons.AutoMirrored.Outlined.Send
        )
        repeat(listOfIcons.size) { index ->
            IconButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = listOfIcons[index],
                    contentDescription = ""
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Outlined.BookmarkAdd,
                contentDescription = ""
            )
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun Default() {
    val samplePost = PostModel(
        profilePicture = R.drawable.profile1,
        profileName = "Hello World",
        images = listOf(
            R.drawable.photo1,
            R.drawable.photo2,
            R.drawable.photo3,
            R.drawable.photo4,
        ),
        description = "Sample Post",
        datePosted = "April 29, 2024"
    )

    InstagramTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                ImageCard(
                    modifier = Modifier
                        .padding(10.dp),
                    onMoreClick = { /*TODO*/ },
                    post = samplePost
                )
            }
        }
    }
}
