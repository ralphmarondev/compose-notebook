package com.maronworks.composenotebook.mini_apps.keep_notes.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.EditNote
import androidx.compose.material.icons.outlined.KeyboardArrowUp
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maronworks.composenotebook.mini_apps.keep_notes.core.model.note.NoteModel
import com.maronworks.composenotebook.ui.theme.ComposeNotebookTheme

@Preview
@Composable
private fun Default() {
    ComposeNotebookTheme {
        Surface(
            modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                NoteCard(
                    modifier = Modifier.padding(10.dp), note = NoteModel(
                        title = "Hello World this is a very long title, so long u see? more more more longer than you expected",
                        content = "This is some content lol...",
                        dateAdded = "2024-04-03 at 6:37PM"
                    )
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteCard(
    modifier: Modifier = Modifier, note: NoteModel,
) {
    var expanded by rememberSaveable {
        mutableStateOf(false)
    }

    ElevatedCard(
        onClick = {
            expanded = !expanded
        }, modifier = modifier, colors = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.tertiary,
            contentColor = MaterialTheme.colorScheme.onTertiary
        )
    ) {
        Box {
            if (expanded) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Magenta)
                            .padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = note.dateAdded, fontSize = 12.sp
                        )
                        Spacer(modifier = Modifier.padding(5.dp))
                        IconButton(
                            onClick = { }, modifier = Modifier
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.EditNote, contentDescription = ""
                            )
                        }
                        IconButton(
                            onClick = { }, modifier = Modifier
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.Delete, contentDescription = ""
                            )
                        }
                        IconButton(
                            onClick = { expanded = !expanded }, modifier = Modifier
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.KeyboardArrowUp,
                                contentDescription = ""
                            )
                        }
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(10.dp)
                    ) {
                        var showFullText by rememberSaveable {
                            mutableStateOf(false)
                        }
                        Text(text = note.title,
                            maxLines = if (showFullText) Int.MAX_VALUE else 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.clickable { showFullText = !showFullText })

                        Divider(modifier = Modifier.padding(vertical = 10.dp))

                        Text(text = note.content)
                    }
                }
            } else {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .defaultMinSize(minHeight = 50.dp)
                        .padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier.weight(7f)
                    ) {
                        Text(
                            text = note.title, maxLines = 1, overflow = TextOverflow.Ellipsis
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            text = note.dateAdded, fontSize = 12.sp
                        )
                    }

                    IconButton(
                        onClick = { expanded = !expanded }, modifier = Modifier.weight(1f)
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.ArrowDropDown, contentDescription = ""
                        )
                    }
                }
            }
        }
    }
}