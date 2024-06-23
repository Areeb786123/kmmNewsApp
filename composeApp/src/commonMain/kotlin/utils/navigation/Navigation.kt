package utils.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ui.detailScreen.screen.DetailScreen
import ui.mainScreen.screen.App


val LocalNavHost = staticCompositionLocalOf<NavHostController> {
    error("No Parameter is available")
}

@Composable
fun Navigation() {
    val navController: NavHostController = rememberNavController()
    val backStackEntry = navController.currentBackStackEntryAsState()
    CompositionLocalProvider(LocalNavHost provides navController) {
        Scaffold {
            NavHost(
                navController = navController,
                startDestination = Screen.MainScreen.route,
                modifier = Modifier.fillMaxSize()
            ) {
                composable(route = Screen.MainScreen.route) {
                    App(navHostController = navController)
                }
                composable(route = Screen.DetailScreen.route) {
                    DetailScreen()
                }
            }
        }
    }
}