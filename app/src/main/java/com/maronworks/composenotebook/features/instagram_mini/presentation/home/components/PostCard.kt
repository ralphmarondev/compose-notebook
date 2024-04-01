package com.maronworks.composenotebook.features.instagram_mini.presentation.home.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddComment
import androidx.compose.material.icons.filled.BookmarkAdd
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.IosShare
import androidx.compose.material.icons.outlined.AddComment
import androidx.compose.material.icons.outlined.BookmarkAdd
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.IosShare
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maronworks.composenotebook.R
import com.maronworks.composenotebook.ui.theme.ComposeNotebookTheme

@Preview
@Composable
private fun Default() {
    ComposeNotebookTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                PostCard(
                    image = R.drawable.sample_image,
                    username = "cute_girl",
                    posts = listOf(
                        R.drawable.sample_image,
                        R.drawable.sample_image,
                        R.drawable.sample_image
                    ),
                    description = "So cute, aren't she? Really cute. the most cutest girl you'll ever see. want to know here name? it's you",
                    dateAndTime = "2024-04-01 * 5:11PM * from Earth"
                )
            }
        }
    }
}

@Composable
fun PostCard(
    modifier: Modifier = Modifier,
    @DrawableRes image: Int,
    username: String,
    @DrawableRes posts: List<Int>,
    description: String,
    dateAndTime: String
) {
    ElevatedCard(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            ImageName(image = image, username = username)

            PostHorizontalPager(posts = posts)

            ReactionRow()
            Divider(modifier = Modifier.padding(horizontal = 5.dp))
            DateTimeAndDescription(
                dateAndTime = dateAndTime,
                description = description
            )
        }
    }
}

@Composable
private fun DateTimeAndDescription(
    dateAndTime: String,
    description: String
) {
    var clicked by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 5.dp)
    ) {
        Text(
            text = dateAndTime,
            fontSize = 12.sp
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = description,
            maxLines = if (clicked) Int.MAX_VALUE else 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .clickable {
                    clicked = !clicked
                }
        )
    }
}

@Composable
private fun ReactionRow() {
    // refactor this later. Convert to data-class
    val defaultIcons = listOf(
        Icons.Outlined.FavoriteBorder,
        Icons.Outlined.AddComment,
        Icons.Outlined.IosShare,
        Icons.Outlined.BookmarkAdd
    )
    val selectedIcons = listOf(
        Icons.Filled.Favorite,
        Icons.Filled.AddComment,
        Icons.Filled.IosShare,
        Icons.Filled.BookmarkAdd
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        defaultIcons.forEachIndexed { index, defaultIcon ->
            IconButtonComp(
                defaultIcon = defaultIcon,
                selectedIcon = selectedIcons[index]
            )
        }
    }
}

@Composable
private fun IconButtonComp(
    defaultIcon: ImageVector,
    selectedIcon: ImageVector
) {
    var selected by rememberSaveable {
        mutableStateOf(false)
    }
    IconButton(
        onClick = {
            selected = !selected
        }
    ) {
        Icon(
            imageVector = if (selected) selectedIcon else defaultIcon,
            contentDescription = ""
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun PostHorizontalPager(
    @DrawableRes posts: List<Int>
) {
    val pagerState = rememberPagerState(
        pageCount = { posts.size }
    )

    HorizontalPager(
        state = pagerState,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        posts.forEachIndexed { _, i ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                Image(
                    painter = painterResource(id = i),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentScale = ContentScale.Crop
                )


                // the pager indicators will only show if the count of picture is greater than 1 [one]
                if (pagerState.pageCount > 1) {
                    Box(
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(vertical = 5.dp, horizontal = 10.dp)
                            .align(Alignment.TopEnd)
                            .clip(RoundedCornerShape(15.dp))
                            .background(MaterialTheme.colorScheme.onPrimaryContainer)
                    ) {
                        Text(
                            text = "${pagerState.currentPage + 1}/${pagerState.pageCount}",
                            modifier = Modifier
                                .padding(5.dp),
                            color = MaterialTheme.colorScheme.primaryContainer,
                            fontSize = 11.sp
                        )
                    }

                    Row(
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(15.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        repeat(pagerState.pageCount) { index ->
                            val color =
                                if (index == pagerState.currentPage) Color.Magenta else Color.White

                            Spacer(modifier = Modifier.width(2.dp))
                            Box(
                                modifier = Modifier
                                    .size(10.dp)
                                    .clip(CircleShape)
                                    .background(color)
                            )
                            Spacer(modifier = Modifier.width(2.dp))
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun ImageName(
    @DrawableRes image: Int,
    username: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = username,
            modifier = Modifier
                .size(55.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(15.dp))
        Text(
            text = username,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}