package com.maronworks.composenotebook.authentication

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maronworks.composenotebook.authentication.components.Login
import com.maronworks.composenotebook.authentication.components.SignUp
import com.maronworks.composenotebook.ui.theme.ComposeNotebookTheme
import kotlinx.coroutines.CoroutineScope

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun Default() {
    ComposeNotebookTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = MaterialTheme.colorScheme.secondary
        ) {
            LoginSignUpActivity(
                onLogin = {}
            )
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoginSignUpActivity(
    context: Context = LocalContext.current,
    scope: CoroutineScope = rememberCoroutineScope(),
    onLogin: () -> Unit,
) {
    val viewModel = LoginSignUpViewModel(context)
    var selectedIndex by rememberSaveable {
        mutableIntStateOf(1)
    }

    val snackBarState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackBarState)
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            ElevatedCard(
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .defaultMinSize(minHeight = 400.dp)
                        .padding(10.dp)
                ) {
                    TabRow(
                        selectedTabIndex = selectedIndex,
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
                    ) {
                        val listOfTabs = listOf(
                            "Sign Up",
                            "Login"
                        )

                        listOfTabs.forEachIndexed { index, text ->
                            Tab(
                                selected = selectedIndex == index,
                                onClick = { selectedIndex = index },
                                modifier = Modifier
                                    .padding(vertical = 8.dp)
                            ) {
                                Text(
                                    text = text,
                                    modifier = Modifier
                                        .padding(vertical = 5.dp),
                                    fontWeight = FontWeight.W500
                                )
                            }
                        }
                    }

                    when (selectedIndex) {
                        0 -> SignUp(
                            viewModel = viewModel,
                            onSignUp = {
                                selectedIndex = 1 // back to login
                            }
                        )

                        1 -> Login(
                            viewModel = viewModel,
                            onLogin = onLogin,
                            scope = scope,
                            snackbarHostState = snackBarState
                        )
                    }
                }
            }
        }
    }
}