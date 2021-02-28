package com.test.app.data

import com.test.app.BaseTest
import com.test.app.common.readJson
import com.test.app.data.db.entity.RegistrationEntity
import com.test.app.data.network.Resource
import com.test.app.domain.model.ApiResponse
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class AppRepositoryTest : BaseTest() {

    private lateinit var apiResponse: ApiResponse

    @Before
    fun before() {

        apiResponse = readJson("response.json")
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testSuccessResponse() {
        setResponse("response.json")
        runBlocking {
            Assert.assertTrue(
                repository.cars().status == Resource.Status.SUCCESS
            )
        }
    }

    @Test
    fun testFailResponse() {
        setErrorResponse()
        runBlocking {
            Assert.assertTrue(
                repository.cars().status == Resource.Status.ERROR
            )
        }
    }

    @Test
    fun testEmployeeItems() {
        setResponse("response.json")
        runBlocking {
            val list = mutableListOf<RegistrationEntity>()
            apiResponse.registrations?.forEach {
                list.add(it?.toRegistrationEntity()!!)
            }
            Mockito.`when`(dao?.registrations()).thenReturn(list)

            val expectedItems = 4 //in local json file, we have 4 items.
            Assert.assertTrue(
                repository.cars().data?.size == expectedItems
            )
        }
    }

    //In this way we can test other functionality as well, using mock webserver and dummy responses.
}