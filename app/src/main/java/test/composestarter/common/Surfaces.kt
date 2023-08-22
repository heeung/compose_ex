package test.composestarter.common

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ir.kaaveh.sdpcompose.sdp
import test.composestarter.ui.theme.Blue700
import test.composestarter.ui.theme.ComposeStarterTheme

@Composable
fun CustomSurface(text: String) {
    Surface(
        modifier = Modifier.padding(20.sdp),
        shadowElevation = 4.sdp,
        shape = RoundedCornerShape(10.sdp),
        color = Blue700,
        contentColor = Color.White,
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(20.sdp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SurfacePreview() {
    ComposeStarterTheme {
        CustomSurface("toss")
    }
}