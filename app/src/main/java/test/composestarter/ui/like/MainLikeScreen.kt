package test.composestarter.ui.like

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import test.composestarter.common.ToastButton

@Composable
fun MainLikeScreen() {
    Column {
        Text(
            text = "like",
            fontSize = 30.sp
        )
        ToastButton(onButtonClicked = { }, text = "얍")
    }
}