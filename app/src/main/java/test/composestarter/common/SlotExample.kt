package test.composestarter.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import ir.kaaveh.sdpcompose.ssp
import test.composestarter.ui.theme.ComposeStarterTheme

@Composable
fun CheckboxWithText(
    modifier: Modifier = Modifier,
    checked: Boolean,
    onCheckedChanged: () -> Unit,
    content: @Composable RowScope.() -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable {
            onCheckedChanged()
        }
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = { onCheckedChanged() }
        )
        content()
//        Text(
//            text = text,
//            modifier = Modifier.clickable { checked.value = !checked.value }
//        )
    }
}

@Composable
fun SlotEx() {
    var checked1 by remember { mutableStateOf(false) }
    val checked2 = remember { mutableStateOf(false) }

    Column() {
//        CheckboxWithText(checked1) {
//            Text(
//                text = "텍스트 1",
//                modifier = Modifier.align(Alignment.CenterVertically)
//            )
//        }
//        CheckboxWithText(checked2) {
//            Text(
//                text = "텍스트 2",
//            )
//        }
        CheckboxWithText(
            checked = checked1,
            onCheckedChanged = { checked1 = !checked1 },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("텍스트 1")
        }
        CheckboxWithText(
            checked = checked2.value,
            onCheckedChanged = { checked2.value = !checked2.value },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("텍스트 2")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SlotExPreview() {
    ComposeStarterTheme {
        SlotEx()
    }
}