package com.test.app.domain

import com.test.app.data.db.entity.RegistrationEntity
import com.test.app.data.network.Resource

interface AppRepository {

    suspend fun cars(): Resource<List<RegistrationEntity>?>
}