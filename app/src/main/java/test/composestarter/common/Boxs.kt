package test.composestarter.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import ir.kaaveh.sdpcompose.sdp
import test.composestarter.ui.theme.ComposeStarterTheme

@Composable
fun CustomBox() {
    Box(
        modifier = Modifier
            .size(100.sdp)
            .shadow(
                elevation = 2.sdp,
                shape = RoundedCornerShape(10.sdp)
            )
//        shape = RoundedCornerShape(10.sdp)
    ) {
        Box(
            modifier = Modifier
                .size(70.sdp)
                .shadow(
                    elevation = 2.sdp,
                    shape = RoundedCornerShape(10.sdp)
                )
                .align(Alignment.Center)
        )
        Text(
            text = "커스텀 박스",
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BoxPreview() {
    ComposeStarterTheme {
        CustomBox()
    }
}