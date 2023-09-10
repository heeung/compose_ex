package test.composestarter

import android.util.Log
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp
import test.composestarter.ui.category.MainCategoryScreen
import test.composestarter.ui.home.MainHomeScreen
import test.composestarter.ui.like.MainLikeScreen
import test.composestarter.ui.mypage.MainMypageScreen
import test.composestarter.ui.theme.ExtraLightGreyColor
import test.composestarter.ui.theme.GreenColor
import test.composestarter.ui.theme.GreyColor
import test.composestarter.ui.theme.WhiteColor

//@OptIn(ExperimentalMaterial3Api::class)

private const val TAG = "메인"
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    type: String? = null,
    articleId: String? = null
) {
    val navController = rememberNavController()
    val appBarState = rememberAppBarState(navController = navController)
    val scope = rememberCoroutineScope()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        topBar = {
            if (appBarState.isVisible) {
                SharedTopAppBar(appBarState = appBarState)
            }
        },
        bottomBar = {
            if (MainNav.isMainRoute(currentRoute)) {
                CustomTabBar(navController = navController, currentRoute = currentRoute)
                Log.d(TAG, "MainScreen: ${currentRoute}")
            }
        },
    ) {
        MainNavigationScreen(
            innerPaddings = it,
            navController = navController,
//            showSnackBar = { message ->
//                scope.launch {
//                    snackBarHostState.showSnackbar(message)
//                }
//            }
        )
        LaunchedEffect(Unit) {
            if (type != null && articleId != null) {
                Log.d("TEST", "MainScreen: PendingIntent 호출")
//                navController.navigate("${BoardDetailNav.route}/${type.lowercase(Locale.getDefault())}/$articleId")
            }
        }
    }
}

@Composable
fun MainBottomNavigationBar(
    navController: NavHostController,
    currentRoute: String?
) {
    val bottomNavigationItems = listOf(
        MainNav.Home,
        MainNav.Category,
        MainNav.Like,
        MainNav.MyPage,
    )
    CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
        NavigationBar(
            tonalElevation = 0.dp,
            modifier = Modifier
                .graphicsLayer {
                    shape = RoundedCornerShape(
                        topStart = 16.dp,
                        topEnd = 16.dp
                    )
                    clip = true
                    shadowElevation = 20f
                               }
        ) {
            bottomNavigationItems.forEach { item ->
                NavigationBarItem(
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = GreenColor,
                        selectedTextColor = GreenColor,
                        unselectedIconColor = GreyColor,
                        unselectedTextColor = GreyColor,
                        indicatorColor = WhiteColor,
                    ),
                    label = { Text(text = item.title) },
                    icon = {
                        Icon(
                            painter = painterResource(id = item.icon),
                            item.route,
                            modifier = Modifier
                                .size(18.sdp)
                        ) },
                    selected = currentRoute == item.route,
                    onClick = {
                        Log.d(TAG, "MainBottomNavigationBar: 클릭했어용 ${item.route}")
                        NavigationUtils.navigate(
                            navController, item.route,
                            navController.graph.startDestinationRoute
                        )
                    }
                )
            }
        }
    }
}

@Composable
fun MainNavigationScreen(
    innerPaddings: PaddingValues,
    navController: NavHostController,
) {
    NavHost(
        modifier = Modifier.padding(innerPaddings),
        navController = navController,
        startDestination = MainNav.Home.route
    ) {
        composable(
            route = MainNav.Home.route,
            deepLinks = MainNav.Home.deepLinks
        ) {
            MainHomeScreen()
        }
        composable(
            route = MainNav.Category.route,
            deepLinks = MainNav.Category.deepLinks
        ) {
            MainCategoryScreen()
        }
        composable(
            route = MainNav.Like.route,
            deepLinks = MainNav.Like.deepLinks
        ) {
            MainLikeScreen()
        }
        composable(
            route = MainNav.MyPage.route,
            deepLinks = MainNav.MyPage.deepLinks
        ) {
            MainMypageScreen()
        }
    }
}

fun parseCommunityRoute(route: String): String {
    return route
}

// 바텀 네비 리플 색 없애기
private object NoRippleTheme : RippleTheme {
    @Composable
    override fun defaultColor() = Color.Unspecified

    @Composable
    override fun rippleAlpha(): RippleAlpha = RippleAlpha(0.0f,0.0f,0.0f,0.0f)
}

@Composable
fun CustomTabBar(
    navController: NavHostController,
    currentRoute: String?
) {
    val bottomNavigationItems = listOf(
        MainNav.Home,
        MainNav.Category,
        MainNav.Like,
        MainNav.MyPage,
    )
    val indicatorColor by rememberUpdatedState(GreenColor) // 선택된 탭의 indicator 색상

    CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
        TabRow(
            modifier = Modifier
                .graphicsLayer {
                    shape = RoundedCornerShape(
                        topStart = 16.dp,
                        topEnd = 16.dp,
                    )
                    clip = true
                    shadowElevation = 20f
                },
            selectedTabIndex = bottomNavigationItems.indexOfFirst { it.route == currentRoute },
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    color = indicatorColor,
                    modifier = Modifier
                        .customTabIndicatorOffset(
                            tabPositions[bottomNavigationItems.indexOfFirst { it.route == currentRoute }],
                            40.sdp
                        )
                        .graphicsLayer {
                            shape = RoundedCornerShape(
                                topStart = 16.dp,
                                topEnd = 16.dp,
                                bottomStart = 16.dp,
                                bottomEnd = 16.dp
                            )
                            clip = true
                        }
                )
            },
//        backgroundColor = Color.White, // 배경 색상
            contentColor = GreyColor, // 텍스트 색상
            containerColor = ExtraLightGreyColor
        ) {
            bottomNavigationItems.forEach { item ->
                val selected = currentRoute == item.route
                Tab(
                    modifier = Modifier.size(60.sdp),
                    icon = {
                        Icon(
                            painter = painterResource(id = item.icon),
                            item.route,
                            modifier = Modifier
                                .size(16.sdp)
                        )
                    },
                    selected = selected,
                    onClick = {
                        Log.d(TAG, "MainBottomNavigationBar: 클릭했어용 ${item.route}")
                        NavigationUtils.navigate(
                            navController, item.route,
                            navController.graph.startDestinationRoute
                        )
                    },
                    text = {
                        Text(
                            text = item.title,
                            fontSize = 9.ssp
                        )
                    },
                    selectedContentColor = GreenColor,
                    unselectedContentColor = GreyColor,
                )
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun MainPreview() {
//    ComposeStarterTheme {
//        CustomTabBar(navController = , currentRoute = )
//    }
//}

fun Modifier.customTabIndicatorOffset(
    currentTabPosition: TabPosition,
    tabWidth: Dp
): Modifier = composed(
    inspectorInfo = debugInspectorInfo {
        name = "customTabIndicatorOffset"
        value = currentTabPosition
    }
) {
    val currentTabWidth by animateDpAsState(
        targetValue = tabWidth,
        animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing), label = ""
    )
    val indicatorOffset by animateDpAsState(
        targetValue = ((currentTabPosition.left + currentTabPosition.right - tabWidth) / 2),
        animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing), label = ""
    )
    fillMaxWidth()
        .wrapContentSize(Alignment.TopStart) // 여기 수정
        .offset(x = indicatorOffset)
        .width(currentTabWidth)
}

//@Composable
//fun createTabContentTransition(): Transition<NavBackStackEntry>? {
//    val fadeIn = remember { Fade(Fade.IN) }
//    val fadeOut = remember { Fade(Fade.OUT) }
//
//    return remember {
//        TransitionSet<NavBackStackEntry>().apply {
//            ordering = TransitionSet.ORDERING_TOGETHER
//            addTransition(fadeIn)
//            addTransition(fadeOut)
//            duration = 300
//            interpolator = FastOutSlowInInterpolator()
//        }
//    }
//}