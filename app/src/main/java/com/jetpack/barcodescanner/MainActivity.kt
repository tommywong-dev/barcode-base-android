package com.jetpack.barcodescanner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.jetpack.barcodescanner.constants.Routes

import com.jetpack.barcodescanner.ui.theme.BarcodeScannerTheme


@ExperimentalPermissionsApi
class MainActivity : ComponentActivity() {
    
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
                        composable("home") {
                            HomeView(navController = navController)
                        }
                        composable("login") {
                            LoginView(navController = navController)
                        }
                    }
                }
            }
        }
    }
}






















