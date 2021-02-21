package com.test.app.data

import com.test.app.data.network.CarsApi
import com.test.app.data.network.Resource
import com.test.app.data.network.ResponseHandler
import com.test.app.domain.AppRepository
import com.test.app.domain.model.ApiResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppRepositoryImpl @Inject constructor(private val api: CarsApi) : AppRepository {

    override suspend fun cars(): Resource<ApiResponse?> = try {
        ResponseHandler.handleSuccess(api.employees())
    } catch (e: Exception) {
        ResponseHandler.handleException(e)
    }
}