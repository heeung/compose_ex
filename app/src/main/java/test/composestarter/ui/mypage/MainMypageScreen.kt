package test.composestarter.ui.mypage

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import test.composestarter.common.ToastButton

@Composable
fun MainMypageScreen() {
    Column {
        Text(
            text = "mypage",
            fontSize = 30.sp
        )
        ToastButton(onButtonClicked = { }, text = "얍")
    }
}