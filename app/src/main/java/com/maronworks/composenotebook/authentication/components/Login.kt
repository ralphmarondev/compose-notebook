package com.maronworks.composenotebook.authentication.components

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Password
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maronworks.composenotebook.authentication.LoginSignUpViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun Login(
    viewModel: LoginSignUpViewModel,
    snackbarHostState: SnackbarHostState,
    scope: CoroutineScope,
    onLogin: () -> Unit,
) {
    var username by rememberSaveable {
        mutableStateOf("")
    }
    var password by rememberSaveable {
        mutableStateOf("")
    }
    var checked by rememberSaveable {
        mutableStateOf(true)
    }
    // error dialog
    var showErrorDialog by rememberSaveable {
        mutableStateOf(false)
    }
    var errorCount by rememberSaveable {
        mutableIntStateOf(0)
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

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = checked,
                onCheckedChange = {
                    checked = !checked
                }
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = "Remember Me")
        }

        Button(
            onClick = {
                if (errorCount >= 3) {
                    showErrorDialog = !showErrorDialog
                }

                if (username.isNotEmpty() && password.isNotEmpty()) {
                    if (viewModel.onLogin(username, password)) {
                        onLogin()
                        Log.d("hello", "Logged in successfully.")
                    } else {
                        errorCount++
                        Log.d("hello", "Invalid username and password")

                        scope.launch {
                            // we assume that all username [including space] is a valid username [blank username doesn't
                            // exists in our database though]
                            snackbarHostState.showSnackbar("Invalid password. Please try again.")
                        }
                    }
                } else {
                    errorCount++
                    Log.d("hello", "Username or password is empty.")

                    scope.launch {
                        snackbarHostState.showSnackbar("Username or password is empty.")
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ) {
            Text(
                text = "LOGIN",
                fontSize = 18.sp,
                fontWeight = FontWeight.W500,
                fontFamily = FontFamily.Monospace,
            )
        }

        if (showErrorDialog) {
            // TODO: Implement this. Disable login/signup for a period of time
            ErrorDialog(
                onDismiss = { showErrorDialog = false },
                error = "You've reached maximum try. Please try again after {n} seconds."
            )
            errorCount = 0
        }
    }
}