package test.composestarter.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import ir.kaaveh.sdpcompose.sdp
import test.composestarter.ui.theme.Blue400
import test.composestarter.ui.theme.ComposeStarterTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField() {
    var name by remember { mutableStateOf("Tom") }
    Column(
        modifier = Modifier.padding(10.sdp)
    ) {
        TextField(
            value = name,
            onValueChange = { name = it },
            label = {
                Text("이름")
            }
        )
        Text(
            text = "Hello $name"
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomOutlinedTextField() {
    var name by remember { mutableStateOf("Tom") }
    Column(
        modifier = Modifier.padding(10.sdp)
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = {
                Text("이름")
            },
            modifier = Modifier
                .background(Color.White),
            singleLine = true,
            trailingIcon = {
                Icon(
                    Icons.Outlined.ArrowForward,
                    "",
                    modifier = Modifier.clickable(
                        interactionSource = MutableInteractionSource(),
                        indication = rememberRipple(color = Blue400, radius = 10.sdp),
                    ) {

                    }
                )
            },
            shape = RoundedCornerShape(10.sdp),
        )
        Text(
            text = "Hello $name"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TextFieldPreview() {
    ComposeStarterTheme {
        CustomOutlinedTextField()
    }
}