package test.composestarter.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ir.kaaveh.sdpcompose.sdp
import test.composestarter.ui.theme.ComposeStarterTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PyeongToSquareMeter() {
    var pyeong by rememberSaveable {
        mutableStateOf("23")
    }
    var squaremeter by rememberSaveable {
        mutableStateOf((23 * 3.306).toString())
    }

//    Column(
//        modifier = Modifier.padding(16.sdp)
//    ) {
//        OutlinedTextField(
//            value = pyeong,
//            onValueChange = {
//                if (it.isBlank()) {
//                    pyeong = ""
//                    squaremeter = ""
//                    return@OutlinedTextField
//                }
//                val numericValue = it.toFloatOrNull() ?: return@OutlinedTextField
//                pyeong = it
//                squaremeter = (numericValue * 3.306).toString()
//            },
//            label = {
//                Text("평")
//            }
//        )
//        OutlinedTextField(
//            value = squaremeter,
//            onValueChange = {
//
//            },
//            label = {
//                Text("제곱미터")
//            }
//        )
//    }
    PyeongToSquareMeterStateless(pyeong = pyeong, squareMeter = squaremeter) {
        if (it.isBlank()) {
            pyeong = ""
            squaremeter = ""
            return@PyeongToSquareMeterStateless
        }
        val numericValue = it.toFloatOrNull() ?: return@PyeongToSquareMeterStateless
        pyeong = it
        squaremeter = (numericValue * 3.306).toString()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PyeongToSquareMeterStateless(
    pyeong: String,
    squareMeter: String,
    onPyeongChange: (String) -> Unit
) {
    Column(
        modifier = Modifier.padding(16.sdp)
    ) {
        OutlinedTextField(
            value = pyeong,
            onValueChange = onPyeongChange,
            label = {
                Text("평")
            }
        )
        OutlinedTextField(
            value = squareMeter,
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