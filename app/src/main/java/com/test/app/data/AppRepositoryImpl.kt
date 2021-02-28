package com.test.app.data

import com.test.app.data.db.AppDao
import com.test.app.data.db.entity.RegistrationEntity
import com.test.app.data.network.RegistrationsApi
import com.test.app.data.network.Resource
import com.test.app.data.network.ResponseHandler
import com.test.app.domain.AppRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppRepositoryImpl @Inject constructor(
    private val api: RegistrationsApi,
    private val dao: AppDao?
) : AppRepository {

    /**
     * Making network call only for first time when DB is empty.
     * Next time onwards, getting data from DB.
     */
    override suspend fun cars(): Resource<List<RegistrationEntity>?> = try {
        if (dao?.entryCount() == 0) {
            api.registrations()?.registrations?.forEach {
                dao.insert(it?.toRegistrationEntity())
            }
        }
        ResponseHandler.handleSuccess(dao?.registrations())
    } catch (e: Exception) {
        ResponseHandler.handleException(e)
    }
}