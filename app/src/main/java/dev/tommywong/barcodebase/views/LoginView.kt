package dev.tommywong.barcodebase.views

import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dev.tommywong.barcodebase.R
import dev.tommywong.barcodebase.constants.Routes
import dev.tommywong.barcodebase.layouts.Logo
import dev.tommywong.barcodebase.utils.readString
import dev.tommywong.barcodebase.viewmodels.LoginViewModel

@Composable
fun LoginView(navController: NavController) {
    val context = LocalContext.current
    val loginViewModel = LoginViewModel()
    val token = stringResource(R.string.default_web_client_id)

    val launcher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.StartActivityForResult()) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(it.data)
            try {
                val account = task.getResult(ApiException::class.java)!!
                val credential = GoogleAuthProvider.getCredential(account.idToken!!, null)
                loginViewModel.signWithCredential(credential, navController)
            } catch (e: ApiException) {
                Log.e(readString(R.string.tag), "Google sign in failed", e)
            }
        }

    fun handleLogin() {
        // Configure Google Sign In
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(token)
            .requestEmail()
            .build()

        val googleSignInClient = GoogleSignIn.getClient(context, gso)
        val signInIntent = googleSignInClient.signInIntent
        launcher.launch(signInIntent)
    }

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
            onClick = { handleLogin() }) {
            Text(text = stringResource(R.string.login))
        }
    }
}
