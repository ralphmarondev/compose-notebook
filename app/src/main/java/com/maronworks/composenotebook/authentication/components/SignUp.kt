package com.maronworks.composenotebook.authentication.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Password
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SignUp(
    onSignUp: () -> Unit,
) {
    var username by rememberSaveable {
        mutableStateOf("")
    }
    var password by rememberSaveable {
        mutableStateOf("")
    }
    var password2 by rememberSaveable {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .padding(vertical = 10.dp)
    ) {
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp, horizontal = 15.dp),
            label = {
                Text(text = "Username")
            },
            textStyle = TextStyle(
                fontFamily = FontFamily.Monospace
            ),
            singleLine = true,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.AccountCircle,
                    contentDescription = ""
                )
            },
            trailingIcon = {
                if (username.isNotEmpty()) {
                    IconButton(onClick = { username = "" }) {
                        Icon(
                            imageVector = Icons.Outlined.Clear,
                            contentDescription = ""
                        )
                    }
                }
            }
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp, horizontal = 15.dp),
            label = {
                Text(text = "Password")
            },
            textStyle = TextStyle(
                fontFamily = FontFamily.Monospace
            ),
            singleLine = true,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Password,
                    contentDescription = ""
                )
            },
            visualTransformation = PasswordVisualTransformation()
        )

        OutlinedTextField(
            value = password2,
            onValueChange = { password2 = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp, horizontal = 15.dp),
            label = {
                Text(text = "Confirm Password")
            },
            textStyle = TextStyle(
                fontFamily = FontFamily.Monospace
            ),
            singleLine = true,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Password,
                    contentDescription = ""
                )
            },
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(15.dp))

        Button(
            onClick = onSignUp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ) {
            Text(
                text = "REGISTER",
                fontSize = 18.sp,
                fontWeight = FontWeight.W500,
                fontFamily = FontFamily.Monospace,
            )
        }
    }
}