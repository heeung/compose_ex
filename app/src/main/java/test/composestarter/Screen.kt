package test.composestarter

import androidx.annotation.DrawableRes

sealed interface Screen {
    val isCenterTopBar: Boolean
    val route: String
    val isAppBarVisible: Boolean
    @get:DrawableRes
    val navigationIcon: Int?
    val navigationIconContentDescription: String?
    val onNavigationIconClick: (() -> Unit)?
    val title: String
    val actions: List<ActionMenuItem>
}