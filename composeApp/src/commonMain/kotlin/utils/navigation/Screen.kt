package utils.navigation

sealed class Screen(val route: String) {
    data object MainScreen : Screen("home")
    data object DetailScreen : Screen("detailScreen")
}