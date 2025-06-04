package com.example.learning.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class AuthUiState(
    val isLoading: Boolean = false,
    val error: String? = null
)

class AuthViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(AuthUiState())
    val uiState: StateFlow<AuthUiState> = _uiState

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _uiState.value = AuthUiState(isLoading = true)

            // 模擬登入邏輯（你可以呼叫 repository）
            if (email == "test@example.com" && password == "1234") {
                _uiState.value = AuthUiState()  // 登入成功，清除錯誤
            } else {
                _uiState.value = AuthUiState(error = "Invalid credentials")
            }
        }
    }
}
