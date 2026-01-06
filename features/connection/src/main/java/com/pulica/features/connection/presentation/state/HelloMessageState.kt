package com.pulica.features.connection.presentation.state

data class HelloMessageState(
    val isLoading: Boolean = false,
    val message: String = "",
    val error: String = ""
)
