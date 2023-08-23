package test.composestarter.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ir.kaaveh.sdpcompose.sdp
import test.composestarter.ui.theme.Blue400
import test.composestarter.ui.theme.ComposeStarterTheme

@Composable
fun CustomCheckBox() {
    var checked = remember { mutableStateOf(false) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clickable(
                interactionSource = MutableInteractionSource(),
                indication = rememberRipple(color = Blue400),
            ) {
                checked.value = !checked.value
            }
            .fillMaxWidth()
    ) {
        Checkbox(
            checked = checked.value,
            onCheckedChange = {
                checked.value = !checked.value
            },
        )
        Text(text = "프로그래머입니까?")
        Spacer(modifier = Modifier.width(10.sdp))
    }
}

@Preview(showBackground = true)
@Composable
fun CheckBoxPreview() {
    ComposeStarterTheme {
        CustomCheckBox()
    }
}