package test.composestarter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import ir.kaaveh.sdpcompose.sdp
import test.composestarter.common.CoilImage
import test.composestarter.common.CustomCard
import test.composestarter.common.CustomCheckBox
import test.composestarter.common.CustomOutlinedTextField
import test.composestarter.common.CustomText
import test.composestarter.common.CustomTextField
import test.composestarter.common.ToastButton
import test.composestarter.common.TossButton
import test.composestarter.ui.theme.ComposeStarterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStarterTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White),
                ) {
//                    Surface(
//                        modifier = Modifier
//                            .wrapContentSize()
//                            .padding(10.sdp)
////                                ,
//                            .weight(1f),
//                        color = MaterialTheme.colorScheme.background
//                    ) {
//                        ToastButton(
//                            onButtonClicked = {
//                                Toast.makeText(this@MainActivity, "aaa", Toast.LENGTH_SHORT).show()
//                            },
//                            text = "",
//                        )
//                    }
                    Box (
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(10.sdp),
//                        color = Color.White,
//                        contentAlignment = Alignment.BottomCenter
                    ) {
                        TossButton()
                    }
                    Box (
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(10.sdp),
                    ) {
                        CoilImage()
                    }
                    CustomCard()
                    CustomCheckBox()
                    CustomTextField()
                    Spacer(modifier = Modifier.width(10.sdp))
                    CustomOutlinedTextField()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CustomPreview() {
    ComposeStarterTheme {
        CustomText("World")
    }
}

@Preview
@Composable
fun CustomButtonPreview() {
    ComposeStarterTheme {
        ToastButton(onButtonClicked = { }, text = "토스트 버튼")
    }
}