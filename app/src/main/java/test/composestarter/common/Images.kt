package test.composestarter.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import ir.kaaveh.sdpcompose.sdp
import test.composestarter.ui.theme.ComposeStarterTheme

@Composable
fun CoilImage() {
//    val painter = rememberImagePainter(data = "https://velog.velcdn.com/images/heeung/post/fe5cf97c-19f7-4dad-92f6-7ff5bc163d8e/image.png")
//    Image(
//        painter = painter,
//        contentDescription = "아이콘"
//    )
    Row (
        modifier = Modifier.fillMaxWidth()
    ) {
        AsyncImage(
            model = "https://velog.velcdn.com/images/heeung/post/fe5cf97c-19f7-4dad-92f6-7ff5bc163d8e/image.png",
            contentDescription = "아이콘",
            modifier = Modifier.weight(1f)
        )
        AsyncImage(
            model = "https://velog.velcdn.com/images/heeung/post/fe5cf97c-19f7-4dad-92f6-7ff5bc163d8e/image.png",
            contentDescription = "아이콘",
            modifier = Modifier.weight(1f)
        )
        AsyncImage(
            model = "https://velog.velcdn.com/images/heeung/post/fe5cf97c-19f7-4dad-92f6-7ff5bc163d8e/image.png",
            contentDescription = "아이콘",
            modifier = Modifier.weight(1f)
        )
        AsyncImage(
            model = "https://velog.velcdn.com/images/heeung/post/fe5cf97c-19f7-4dad-92f6-7ff5bc163d8e/image.png",
            contentDescription = "아이콘",
            modifier = Modifier.weight(1f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ImagePreview() {
    ComposeStarterTheme {
        CoilImage()
    }
}