package test.composestarter.common

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
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
fun ScaffoldEx() {
    var checked by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                                 IconButton(onClick = { /*TODO*/ }) {
                                     Image(
                                         imageVector = Icons.Filled.ArrowBack,
                                         contentDescription = "뒤로가기"
                                     )
                                 }
                },
                title = {
                    Text(text = "Scaffold App")
                }
            )
        }
    ) { paddings ->
        Surface(
            modifier = Modifier.padding(paddings).fillMaxWidth(),
        ) {
            CheckboxWithText(
                checked = checked,
                onCheckedChanged = { checked = !checked },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "컴포즈를 좋아합니다.")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScaffoldPreview() {
    ComposeStarterTheme {
        ScaffoldEx()
    }
}