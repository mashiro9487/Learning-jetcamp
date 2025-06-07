package com.example.learning.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apollographql.apollo3.ApolloClient
import com.example.learning.LoginMutation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class AuthUiState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val isLoggedIn: Boolean = false
)

class AuthViewModel : ViewModel() {
    // 使用 Apollo Client 連接到 GraphQL API
    private val apolloClient = ApolloClient.Builder()
        .serverUrl("https://your-graphql-server.com/graphql") // 換成你的 GraphQL API URL
        .build()
    private val _uiState = MutableStateFlow(AuthUiState())
    val uiState: StateFlow<AuthUiState> = _uiState

    fun login(email: String, password: String) {
        viewModelScope.launch {
            try {
                _uiState.value = AuthUiState(isLoading = true)

                val response = apolloClient.mutation(LoginMutation(email, password)).execute()
                val message = response.data?.login

                if (message == "Login successful") {
                    _uiState.value = AuthUiState(isLoggedIn = true)
                } else {
                    _uiState.value = AuthUiState(error = message)
                }

            } catch (e: Exception) {
                _uiState.value = AuthUiState(error = "Network error")
            }
        }
    }

    fun register(email: String, password: String) {
        viewModelScope.launch {
            _uiState.value = AuthUiState(isLoading = true)

            if (email.isNotBlank() && password.length >= 4) {
                _uiState.value = AuthUiState(isLoggedIn = true)
            } else {
                _uiState.value = AuthUiState(error = "Invalid email or password")
            }
        }
    }
}

