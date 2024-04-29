package com.maronworks.composenotebook.authentication.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.maronworks.composenotebook.ui.theme.ComposeNotebookTheme

@Composable
fun ErrorDialog(
    onDismiss: () -> Unit,
    error: String,
) {
    Dialog(onDismissRequest = onDismiss) {
        ElevatedCard(
            modifier = Modifier
                .padding(10.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Error",
                        fontWeight = FontWeight.W500
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Outlined.Close,
                            contentDescription = ""
                        )
                    }
                }
                Divider(modifier = Modifier.padding(bottom = 5.dp))

                Text(
                    text = error,
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(2.dp, Color.LightGray, RoundedCornerShape(10.dp))
                        .padding(10.dp)
                )

                Divider(modifier = Modifier.padding(top = 5.dp, bottom = 5.dp))

                OutlinedButton(onClick = onDismiss) {
                    Text(
                        text = "CLOSE",
                        modifier = Modifier
                            .padding(horizontal = 15.dp),
                        fontWeight = FontWeight.W500
                    )
                }

            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun Default() {
    ComposeNotebookTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            var showDialog by remember { mutableStateOf(true) }

            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (showDialog) {
                    ErrorDialog(
                        onDismiss = { showDialog = !showDialog },
                        error = "No error. It's just that Ralph Maron Eda is so cute."
                    )
                }
            }
        }
    }
}
