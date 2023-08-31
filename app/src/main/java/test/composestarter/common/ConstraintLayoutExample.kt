package test.composestarter.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import ir.kaaveh.sdpcompose.sdp
import test.composestarter.ui.theme.ComposeStarterTheme

@Composable
fun ConstraintLayoutEx() {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (redBox, magentaBox, greenBox, yellowBox) = createRefs()

        Box(
            modifier = Modifier
                .size(40.sdp)
                .background(Color.Red)
                .constrainAs(redBox) {
                    bottom.linkTo(parent.bottom)
                }
        ) {

        }
        Box(
            modifier = Modifier
                .size(40.sdp)
                .background(Color.Magenta)
        ) {

        }
        Box(
            modifier = Modifier
                .size(40.sdp)
                .background(Color.Green)
        ) {

        }
        Box(
            modifier = Modifier
                .size(40.sdp)
                .background(Color.Yellow)
        ) {

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ConstraintLayoutPreview() {
    ComposeStarterTheme {
        ConstraintLayoutEx()
    }
}

