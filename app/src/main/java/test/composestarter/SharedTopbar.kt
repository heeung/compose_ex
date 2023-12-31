package test.composestarter

import androidx.compose.foundation.background
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SharedTopAppBar(
    appBarState: AppBarState,
    modifier: Modifier = Modifier,
//    notificationViewModel: NotificationViewModel = hiltViewModel()
) {
//    val notificationList = notificationViewModel.notificationList.collectAsStateWithLifecycle()
//    Log.d("TEST", "SharedTopAppBar: ${notificationList.value.size}")
    // 메뉴창을 위한?
    var menuExpanded by remember {
        mutableStateOf(false)
    }

    if (appBarState.isCenterTopBar) {
        CenterAlignedTopAppBar(
            modifier = modifier
                .background(color = White)
                .graphicsLayer {
                    shadowElevation = 10f
                },
            navigationIcon = {
                val icon = appBarState.navigationIcon
                val callback = appBarState.onNavigationIconClick
                if (icon != null) {
                    IconButton(onClick = { callback?.invoke() }) {
                        Icon(
                            painter = painterResource(id = icon),
                            contentDescription = appBarState.navigationIconContentDescription
                        )
                    }
                }
            },
            title = {
                val title = appBarState.title
                if (title.isNotEmpty()) {
                    Text(text = title)
                }
            },
            actions = {
                val items = appBarState.actions
                if (items.isNotEmpty()) {
                    ActionsMenu(
                        items = items,
//                        isOpen = menuExpanded,
                        isOpen = true,
                        onToggleOverflow = { menuExpanded = !menuExpanded },
                        maxVisibleItems = 3,
//                        notificationList.value.size
                    )
                }
            },
        )
    } else {
        TopAppBar(
            modifier = modifier
                .background(color = White)
                .graphicsLayer {
                    shadowElevation = 5f
                },
            navigationIcon = {
                val icon = appBarState.navigationIcon
                val callback = appBarState.onNavigationIconClick
                if (icon != null) {
                    IconButton(onClick = { callback?.invoke() }) {
                        Icon(
                            painter = painterResource(id = icon),
                            contentDescription = appBarState.navigationIconContentDescription
                        )
                    }
                }
            },
            title = {
                val title = appBarState.title
                if (title.isNotEmpty()) {
                    Text(text = title)
                }
            },
            actions = {
                val items = appBarState.actions
                if (items.isNotEmpty()) {
                    ActionsMenu(
                        items = items,
                        isOpen = menuExpanded,
                        onToggleOverflow = { menuExpanded = !menuExpanded },
                        maxVisibleItems = 3,
//                        notificationList.value.size
                    )
                }
            },
        )
    }
}