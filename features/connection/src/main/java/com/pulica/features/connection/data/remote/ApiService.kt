package com.pulica.features.connection.data.remote

import com.pulica.features.connection.data.remote.dto.HelloResponse
import retrofit2.http.GET

interface ApiService {

    @GET("/hello")
    suspend fun getHelloMessage(): HelloResponse

}
