package test.composestarter.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import test.composestarter.ui.theme.ComposeStarterTheme

@Composable
fun CheckboxWithText(
    checked: MutableState<Boolean>,
    content: @Composable () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable {
            checked.value = !checked.value
        }
    ) {
        Checkbox(
            checked = checked.value,
            onCheckedChange = { checked.value = it }
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
    val checked1 = remember { mutableStateOf(false) }
    val checked2 = remember { mutableStateOf(false) }

    Column() {
        CheckboxWithText(checked1) {
            Text(
                text = "텍스트 1",
            )
        }
        CheckboxWithText(checked2) {
            Text(
                text = "텍스트 2",
            )
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