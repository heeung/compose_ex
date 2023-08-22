package test.composestarter.common

import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomText(name: String, modifier: Modifier = Modifier) {
    Text(
        // 원하는 텍스트
        text = "Hello $name!",
        // 원하는 컬러
//        color = Color(0xffff9944),
        color = Color.Blue,
        // 원하는 사이즈
        fontSize = 30.sp,
        // 원하는 굵기
        fontWeight = FontWeight.Bold,
        // 원하는 글씨체
        fontFamily = FontFamily.Cursive,
        // 자간letterSpacing = 2.sp
        maxLines = 2,
        textDecoration = TextDecoration.Underline,
        textAlign = TextAlign.Center,
        modifier = modifier.width(300.dp),
    )
}

@Composable
fun ToastButtonText(name: String) {
    Text(
        // 원하는 텍스트
        text = name,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
    )
}