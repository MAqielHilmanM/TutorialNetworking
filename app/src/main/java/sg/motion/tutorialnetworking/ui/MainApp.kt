package sg.motion.tutorialnetworking.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import sg.motion.tutorialnetworking.core.routes.AppRoutes
import sg.motion.tutorialnetworking.ui.home.HomeScreen
import sg.motion.tutorialnetworking.ui.splash.SplashScreen

// Main Navigation Component
@Composable
fun AppNavigation() {
    val context = LocalContext.current
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppRoutes.Splash.route
    ) {
        // Splash Screen
        composable(AppRoutes.Splash.route) {
            SplashScreen(navController)
        }

        // Home Screen
        composable(AppRoutes.Home.route) {
            HomeScreen(navController)
        }
    }
}