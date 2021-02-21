package com.test.app.domain.usecases

import com.test.app.data.AppRepositoryImpl
import javax.inject.Inject

class CarsUseCase @Inject constructor(private val repository: AppRepositoryImpl) {

    suspend fun employees() = repository.cars()
}