package sg.motion.tutorialnetworking.core.routes

sealed class AppRoutes(val route: String) {
    object Splash : AppRoutes("splash")
    object Home : AppRoutes("home")
}