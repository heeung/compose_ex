package test.composestarter.common

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import test.composestarter.ui.theme.ComposeStarterTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar() {
    Column {
        TopAppBar(title = { Text("TopAppBar") })
    }
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    ComposeStarterTheme {
        CustomTopBar()
    }
}