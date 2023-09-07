package test.composestarter

import androidx.annotation.DrawableRes
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDeepLink
import androidx.navigation.navDeepLink
import test.composestarter.NavigationRouteName.DEEP_LINK_SCHEME
import test.composestarter.NavigationRouteName.MAIN_CATEGORY
import test.composestarter.NavigationRouteName.MAIN_HOME
import test.composestarter.NavigationRouteName.MAIN_LIKE_ITEM
import test.composestarter.NavigationRouteName.MAIN_MY_PAGE

sealed class MainNav(
    override val route: String,
    @DrawableRes val icon: Int,
    override val title: String
)  : Destination {

    override val deepLinks: List<NavDeepLink> = listOf(
        navDeepLink { uriPattern = "$DEEP_LINK_SCHEME$route" }
    )

    object Home : MainNav(MAIN_HOME, R.drawable.ic_home, NavigationTitle.MAIN_HOME)
    object Category : MainNav(MAIN_CATEGORY, R.drawable.ic_category, NavigationTitle.MAIN_CATEGORY)
    object Like : MainNav(MAIN_LIKE_ITEM, R.drawable.ic_like, NavigationTitle.MAIN_LIKE_ITEM)
    object MyPage : MainNav(MAIN_MY_PAGE, R.drawable.ic_mypage, NavigationTitle.MAIN_MY_PAGE)

    companion object {
        fun isMainRoute(route: String?): Boolean {
            return when (route) {
                MAIN_HOME, MAIN_MY_PAGE, MAIN_CATEGORY, MAIN_LIKE_ITEM -> true

                else -> false
            }
        }
    }
}

interface Destination {
    val route: String
    val title: String
    val deepLinks: List<NavDeepLink>
}

interface DestinationArg<T> : Destination {
    val argName: String
    val arguments: List<NamedNavArgument>

    fun routeWithArgName() = "$route/{$argName}"
    fun navigateWithArg(item: T): String
    fun findArgument(navBackStackEntry: NavBackStackEntry): T?
}

object NavigationRouteName {
    const val DEEP_LINK_SCHEME = "composestarter://"
    const val MAIN_HOME = "main_home"
    const val MAIN_MY_PAGE = "main_my_page"
    const val MAIN_CATEGORY = "main_category"
    const val MAIN_LIKE_ITEM = "main_like"
}

object NavigationTitle {
    const val MAIN_HOME = "홈"
    const val MAIN_MY_PAGE = "프로필"
    const val MAIN_CATEGORY = "카테고리"
    const val MAIN_LIKE_ITEM = "찜"
}