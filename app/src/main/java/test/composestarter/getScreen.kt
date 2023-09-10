package test.composestarter

// TopBar 보여줄 요소에 따라 Route 지정
fun getScreen(route: String?): Screen? = when (route) {
    NavigationRouteName.MAIN_HOME -> HomeScreen
//    NavigationRouteName.MAIN_MY_PAGE -> SettingScreen
//    NavigationRouteName.MAIN_CATEGORY -> CommunityFreeScreen
//    NavigationRouteName.MAIN_LIKE_ITEM -> CommunityWithScreen
//    NavigationRouteName.COMMUNITY_REPORT -> CommunityReportScreen
//    NavigationRouteName.POINT_STORE -> PointStoreScreen
//    NavigationRouteName.PROFILE_EDIT -> ProfileEditScreen
//    NavigationRouteName.FIND_ID -> FindIDScreen
//    NavigationRouteName.FIND_PASSWORD -> FindPasswordScreen
//    BoardDetailNav.route -> BoardDetailScreen
//    NavigationRouteName.MISSION -> MissionScreen
//    NavigationRouteName.ENCYCLOPEDIA -> EncyclopediaScreen
//    NavigationRouteName.JOIN -> JoinScreen
//    NavigationRouteName.MAIN_CHATTING -> ChattingScreen
    ManyOptionsRoute -> ManyOptionsScreen
    else -> null
}