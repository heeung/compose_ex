package test.composestarter.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import test.composestarter.common.ToastButton

@Composable
fun MainHomeScreen() {
    Column {
        Text (
            text = "home",
            fontSize = 30.sp
        )
        ToastButton(onButtonClicked = { }, text = "얍")
    }
}