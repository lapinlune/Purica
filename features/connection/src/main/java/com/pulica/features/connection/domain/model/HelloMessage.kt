package com.pulica.features.connection.domain.model

import com.pulica.features.connection.data.remote.dto.HelloResponse

data class HelloMessage(
    val text: String
)

fun HelloResponse.toHelloMessage(): HelloMessage {
    return HelloMessage(text = message)
}
