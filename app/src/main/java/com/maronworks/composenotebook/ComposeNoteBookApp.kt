package com.maronworks.composenotebook

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.maronworks.composenotebook.navigation.AppNavigation
import com.maronworks.composenotebook.ui.theme.ComposeNoteBookTheme

@Composable
fun ComposeNoteBookApp(modifier: Modifier = Modifier) {
    ComposeNoteBookTheme {
        Surface(
            modifier = modifier,
            color = MaterialTheme.colorScheme.background
        ) {
            AppNavigation()
        }
    }
}