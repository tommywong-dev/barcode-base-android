package com.jetpack.barcodescanner

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jetpack.barcodescanner.constants.Routes
import com.jetpack.barcodescanner.layouts.Logo

@Composable
fun LoginView(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Logo(width = 250.dp)
        Text(
            text = stringResource(R.string.login_title),
            modifier = Modifier
                .padding(vertical = 16.dp),
            style = MaterialTheme.typography.subtitle2
        )
        Button(
            onClick = { navController.navigate(Routes.HOME) }) {
            Text(text = stringResource(R.string.login))
        }
    }
}
