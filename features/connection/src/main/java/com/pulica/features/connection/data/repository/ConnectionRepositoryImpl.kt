package com.pulica.features.connection.data.repository

import com.pulica.features.connection.data.remote.ApiService
import com.pulica.features.connection.domain.model.toHelloMessage
import com.pulica.features.connection.domain.model.HelloMessage
import com.pulica.features.connection.domain.repository.ConnectionRepository
import javax.inject.Inject

class ConnectionRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : ConnectionRepository {

    override suspend fun getHelloMessage(): HelloMessage {
        return apiService.getHelloMessage().toHelloMessage()
    }
}
