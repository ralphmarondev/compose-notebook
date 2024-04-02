package com.maronworks.composenotebook.features.about_her.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
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
                SwitchImpl {

                }
            }
        }
    }
}

@Composable
fun SwitchImpl(
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit
) {
    var checked by rememberSaveable {
        mutableStateOf(false)
    }
    val textColor =
        if (checked) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.primary
    val cardColor =
        if (checked) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onPrimary

    Dialog(onDismissRequest = onDismiss) {
        ElevatedCard(
            modifier = modifier,
            colors = CardDefaults.elevatedCardColors(
                containerColor = cardColor
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .defaultMinSize(minHeight = 120.dp)
                    .padding(vertical = 20.dp, horizontal = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "You always",
                    fontSize = 18.sp,
                    color = textColor
                )

                Spacer(modifier = Modifier.height(10.dp))

                Switch(
                    checked = checked,
                    onCheckedChange = {
                        checked = !checked
                    },
                    colors = SwitchDefaults.colors(
                        uncheckedThumbColor = Color.LightGray,
                        uncheckedTrackColor = Color.White,
                        checkedBorderColor = Color.White,
                    )
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = if(checked) "Pretty Mode" else "Still on Pretty Mode",
                    fontSize = 18.sp,
                    color = textColor
                )
            }
        }
    }
}