package test.composestarter

import androidx.navigation.NavHostController

object NavigationUtils {

    fun navigate(
        controller: NavHostController,
        routeName: String,
        backStackRouteName: String? =null,
        isLaunchSingleTop: Boolean= true,
        needToRestoreState: Boolean= true
    ) {
        controller.navigate(routeName) {
            if(backStackRouteName != null) {
                popUpTo(backStackRouteName) { saveState = true}
            }
            launchSingleTop = isLaunchSingleTop
            restoreState = needToRestoreState
        }
    }

    fun findDestination(route : String?) : Destination {
        return when(route) {
            NavigationRouteName.MAIN_MY_PAGE -> MainNav.MyPage
            NavigationRouteName.MAIN_HOME -> MainNav.Home
            NavigationRouteName.MAIN_CATEGORY -> MainNav.Category
            NavigationRouteName.MAIN_LIKE_ITEM -> MainNav.Like

            else -> MainNav.Home
        }
    }
}