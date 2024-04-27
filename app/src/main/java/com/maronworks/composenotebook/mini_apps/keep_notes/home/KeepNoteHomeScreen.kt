package com.maronworks.composenotebook.mini_apps.keep_notes.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.NoteAdd
import androidx.compose.material.icons.outlined.ArrowBackIosNew
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maronworks.composenotebook.mini_apps.keep_notes.KeepNotesViewModel
import com.maronworks.composenotebook.mini_apps.keep_notes.home.components.NoteCard
import com.maronworks.composenotebook.ui.theme.ComposeNotebookTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KeepNoteHomeScreen(
    viewModel: KeepNotesViewModel,
    addNewNote: () -> Unit,
    exitApp: () -> Unit,
) {
    LaunchedEffect(key1 = true) {
        viewModel.getAllNotes()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Keep Notes",
                        fontFamily = FontFamily.Monospace
                    )
                },
                navigationIcon = {
                    IconButton(onClick = exitApp) {
                        Icon(
                            imageVector = Icons.Outlined.ArrowBackIosNew,
                            contentDescription = ""
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { viewModel.getAllNotes() }) {
                        Icon(
                            imageVector = Icons.Outlined.Refresh,
                            contentDescription = ""
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                    navigationIconContentColor = MaterialTheme.colorScheme.primary,
                    actionIconContentColor = MaterialTheme.colorScheme.primary
                )
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(onClick = addNewNote) {
                Icon(
                    imageVector = Icons.AutoMirrored.Outlined.NoteAdd,
                    contentDescription = ""
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "New",
                    fontFamily = FontFamily.Monospace,
                    fontSize = 18.sp
                )
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = if (viewModel.notes.size == 0) Arrangement.Center else Arrangement.Top
        ) {
            item {
                Spacer(modifier = Modifier.height(10.dp))
            }
            item {
                AnimatedVisibility(visible = viewModel.notes.size == 0) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Empty Note",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.W600
                        )
                    }
                }
                repeat(viewModel.notes.size) { index ->
                    NoteCard(
                        modifier = Modifier
                            .padding(horizontal = 10.dp, vertical = 5.dp),
                        note = viewModel.notes[index]
                    )
                }
            }
            item {
                Spacer(modifier = Modifier.height(100.dp))
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun HomeScreenPreview() {
    ComposeNotebookTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            KeepNoteHomeScreen(
                viewModel = KeepNotesViewModel(LocalContext.current),
                addNewNote = { }) {

            }
        }
    }
}
