package com.pulica.features.connection.domain.use_case

import com.pulica.core.Resource
import com.pulica.core.UseCase
import com.pulica.features.connection.domain.model.HelloMessage
import com.pulica.features.connection.domain.repository.ConnectionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetHelloMessageUseCase @Inject constructor(
    private val repository: ConnectionRepository
) : UseCase<HelloMessage, Unit>() {

    override fun run(params: Unit): Flow<Resource<HelloMessage>> = flow {
        try {
            emit(Resource.Loading()) // Emit loading state
            val helloMessage = repository.getHelloMessage()
            emit(Resource.Success(helloMessage)) // Emit success state with data
        } catch (e: HttpException) {
            // Error from API (non-2xx response)
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            // Error from network connection (no internet, server down, etc.)
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}
