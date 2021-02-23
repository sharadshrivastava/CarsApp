package com.test.app.data.network

import com.test.app.domain.model.ApiResponse
import retrofit2.http.GET

interface RegistrationsApi {

    @GET(EMPLOYEES_PATH)
    suspend fun registrations(): ApiResponse?

    companion object {
        const val BASE_URL = "https://dl.dropboxusercontent.com/"
        private const val EMPLOYEES_PATH = "s/wcp5aajrrx533bp/snsw_registrations_api.json"
    }
}