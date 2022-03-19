package dev.tommywong.barcodebase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dev.tommywong.barcodebase.constants.Routes

import dev.tommywong.barcodebase.ui.theme.BarcodeScannerTheme
import dev.tommywong.barcodebase.views.HomeView
import dev.tommywong.barcodebase.views.LoginView


@ExperimentalPermissionsApi
class MainActivity : ComponentActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BarcodeScannerTheme {
                val navController = rememberNavController()

                Surface(color = MaterialTheme.colors.background) {
                    NavHost(
                        navController = navController,
                        startDestination = Routes.LOGIN
                    ) {
                        composable(Routes.HOME) {
                            HomeView(navController = navController)
                        }
                        composable(Routes.LOGIN) {
                            LoginView(navController = navController)
                        }
                    }
                }
            }
        }
    }
}






















