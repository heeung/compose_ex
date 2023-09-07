package test.composestarter.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ir.kaaveh.sdpcompose.sdp
import test.composestarter.R
import test.composestarter.ui.theme.Blue700
import test.composestarter.ui.theme.ComposeStarterTheme

@Composable
fun ToastButton(onButtonClicked: () -> Unit, text: String) {
    Button(
        onClick = onButtonClicked,
        modifier = Modifier.wrapContentSize(),
        enabled = true,
//        border = BorderStroke(10.dp, Color.Gray)
//        shape = RoundedCornerShape(20.dp)
        shape = CircleShape,
        contentPadding = PaddingValues(20.dp, 0.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
            containerColor = Blue700,
        ),
        elevation = ButtonDefaults.buttonElevation(2.sdp)
    ) {
        Icon(
            imageVector = Icons.Filled.Send,
            contentDescription = null,
        )
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        ToastButtonText(name = text)
    }
}

@Composable
fun TossButton() {
    Button(
        onClick = { },
        modifier = Modifier
            .wrapContentSize()
            .padding(4.sdp)
            .height(60.sdp),
        enabled = true,
        colors = ButtonDefaults.buttonColors(Color.White),
        elevation = ButtonDefaults.buttonElevation(4.sdp),
//        elevation =
    ) {
        Image(
//            modifier =
            painter = painterResource(id = R.drawable.toss_logo),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BottonPreview() {
    ComposeStarterTheme {
        TossButton()
    }
}