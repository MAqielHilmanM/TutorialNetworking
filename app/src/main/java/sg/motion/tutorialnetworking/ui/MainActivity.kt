package sg.motion.tutorialnetworking.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import sg.motion.tutorialnetworking.ui.theme.TutorialNetworkingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            TutorialNetworkingTheme {
                AppNavigation()
            }
        }
    }
}