package test.composestarter.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp
import test.composestarter.ui.theme.Blue400
import test.composestarter.ui.theme.ComposeStarterTheme

@Composable
fun CustomCard() {
    Surface(
        color = Color.LightGray,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Box(
            modifier = Modifier
                .padding(10.sdp)
//                .background(Color.White)
                .wrapContentHeight()
                .clip(shape = RoundedCornerShape(10.sdp))
                .background(Color.White)
                .clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = rememberRipple(color = Blue400),
                ) { },
        ) {
            Row(
                modifier = Modifier
                    .padding(10.sdp)
                    .wrapContentHeight()
            ) {
                AsyncImage(
                    modifier = Modifier
                        .weight(2f)
                        .clip(CircleShape),
                    model = "https://velog.velcdn.com/images/heeung/post/fe5cf97c-19f7-4dad-92f6-7ff5bc163d8e/image.png",
                    contentDescription = "아이콘"
                )
                Spacer(Modifier.width(10.sdp))
                Column(
                    modifier = Modifier.weight(7f),
                ) {
                    Text(
                        text = "뭉게뭉게 도화지",
                        fontSize = 20.ssp,
                        fontWeight = FontWeight.Bold,
                    )
                    Text(
                        text = "D101 어플리케이션",
                        fontSize = 14.ssp,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardPreview() {
    ComposeStarterTheme {
        CustomCard()
    }
}