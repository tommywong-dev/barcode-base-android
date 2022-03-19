package dev.tommywong.barcodebase.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dev.tommywong.barcodebase.constants.Routes
import dev.tommywong.barcodebase.enums.LoadingState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class LoginViewModel(): ViewModel() {
    private val loadingState = MutableStateFlow(LoadingState.IDLE)

    fun signWithCredential(credential: AuthCredential, navController: NavController) = viewModelScope.launch {
        try {
            loadingState.emit(LoadingState.LOADING)
            Firebase.auth.signInWithCredential(credential)
            loadingState.emit(LoadingState.LOADED)
            navController.navigate(Routes.HOME)
        } catch (e: Exception) {
            loadingState.emit(LoadingState.error(e.localizedMessage))
        }
    }
}
