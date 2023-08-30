package test.composestarter.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ir.kaaveh.sdpcompose.sdp
import test.composestarter.ui.theme.ComposeStarterTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PyeongToSquareMeter() {
    var pyeong by remember {
        mutableStateOf("23")
    }
    var squaremeter by remember {
        mutableStateOf((23 * 3.306).toString())
    }

    Column(
        modifier = Modifier.padding(16.sdp)
    ) {
        OutlinedTextField(
            value = "",
            onValueChange = {

            },
            label = {
                Text("평")
            }
        )
        OutlinedTextField(
            value = "",
            onValueChange = {

            },
            label = {
                Text("제곱미터")
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HoistingPreview() {
    ComposeStarterTheme {
        PyeongToSquareMeter()
    }
}