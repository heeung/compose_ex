package test.composestarter

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

object HomeScreen : Screen {
    override val isCenterTopBar: Boolean = false

    override val route: String = ManyOptionsRoute
    override val isAppBarVisible: Boolean = true
    override val navigationIcon: Int = R.drawable.ic_back
    override val onNavigationIconClick: () -> Unit = {
        HomeScreen._buttons.tryEmit(HomeScreen.AppBarIcons.NavigationIcon)
    }
    override val navigationIconContentDescription: String? = null
    override val title: String = "Many Options"

    override val actions: List<ActionMenuItem> =
        listOf(
            ActionMenuItem.IconMenuItem.AlwaysShown(
                title = "Search",
                onClick = {
                    HomeScreen._buttons.tryEmit(HomeScreen.AppBarIcons.Search)
                },
                icon = R.drawable.ic_search,
                contentDescription = null,
            ),
            ActionMenuItem.IconMenuItem.AlwaysShown(
                title = "Favorite",
                onClick = {
                    HomeScreen._buttons.tryEmit(HomeScreen.AppBarIcons.Favorite)
                },
                icon = R.drawable.ic_like,
                contentDescription = null,
            ),
//            ActionMenuItem.NeverShown(
//                title = "Settings",
//                onClick = {
//                    _buttons.tryEmit(AppBarIcons.Settings)
//                },
//            ),
//            ActionMenuItem.NeverShown(
//                title = "About",
//                onClick = {
//                    _buttons.tryEmit(AppBarIcons.About)
//                },
//            ),
        )

    private val _buttons = MutableSharedFlow<AppBarIcons>(extraBufferCapacity = 1)
    val buttons: Flow<AppBarIcons> = _buttons.asSharedFlow()

    enum class AppBarIcons {
        NavigationIcon,
        Search,
        Favorite,
        Settings,
        About,
//        Alarm,
    }
}