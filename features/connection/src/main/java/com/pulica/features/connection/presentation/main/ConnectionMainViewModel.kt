package com.pulica.features.connection.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pulica.core.Resource
import com.pulica.features.connection.domain.use_case.GetHelloMessageUseCase
import com.pulica.features.connection.presentation.state.HelloMessageState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ConnectionMainViewModel @Inject constructor(
    private val getHelloMessageUseCase: GetHelloMessageUseCase
) : ViewModel() {

    private val _helloMessageState = MutableStateFlow(HelloMessageState())
    val helloMessageState: StateFlow<HelloMessageState> = _helloMessageState

    fun getHelloMessage() {
        getHelloMessageUseCase(Unit).onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _helloMessageState.value = HelloMessageState(isLoading = true)
                }
                is Resource.Success -> {
                    _helloMessageState.value = HelloMessageState(message = result.data?.text ?: "")
                }
                is Resource.Error -> {
                    _helloMessageState.value = HelloMessageState(error = result.message ?: "An unexpected error occurred")
                }
            }
        }.launchIn(viewModelScope)
    }
}
