package com.pulica.features.connection.domain.repository

import com.pulica.features.connection.domain.model.HelloMessage

interface ConnectionRepository {
    suspend fun getHelloMessage(): HelloMessage
}
