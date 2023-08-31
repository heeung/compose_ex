package test.composestarter.common

import android.content.res.Resources.Theme
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch
import test.composestarter.ui.theme.ComposeStarterTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomAppBarEx() {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        bottomBar = {
            BottomAppBar() {
                Text("헬로")
                Button(onClick = {
                    coroutineScope.launch {
                        scaffoldState.snackbarHostState.showSnackbar("안녕하세요")
                    }
                }) {
                    Text(text = "인사하기")
                }
            }
        }
    ) {
        it
        Text("")
    }
}

@Preview(showBackground = true)
@Composable
fun BottomAppBarPreview() {
    ComposeStarterTheme {
        BottomAppBarEx()
    }
}