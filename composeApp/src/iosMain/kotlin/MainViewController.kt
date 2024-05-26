import androidx.compose.ui.window.ComposeUIViewController
import androidx.navigation.compose.rememberNavController
import ui.mainScreen.screen.App

fun MainViewController() = ComposeUIViewController(configure = {
    KotlinInitializer().init()
}) {
    val navigation = rememberNavController()
    App(navigation)
}