package com.maronworks.composenotebook.features.todo_app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.maronworks.composenotebook.features.todo_app.presentation.home.HomeScreen
import com.maronworks.composenotebook.features.todo_app.presentation.new_note.NewNoteScreen
import com.maronworks.composenotebook.ui.theme.ComposeNotebookTheme

val todoAppVM = TodoAppViewModel()

@Preview
@Composable
private fun Default() {
    ComposeNotebookTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            TodoApp {

            }
        }
    }
}

@Composable
fun TodoApp(
    exitApp: () -> Unit
) {
    when (todoAppVM.getSelectedScreen()) {
        0 -> {
            HomeScreen(exitApp = exitApp)
            todoAppVM.readNotes(LocalContext.current)
        }

        1 -> NewNoteScreen(onBack = { todoAppVM.resetSelectedScreen() })
    }
}