package com.jetpack.barcodescanner

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun LoginView(navController: NavController) {
    Button(onClick = { navController.navigate(Routes.HOME) }) {
        Text(text = "Login")
    }
}
