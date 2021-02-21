package com.test.app.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.test.app.common.readJson
import com.test.app.data.network.Resource
import com.test.app.domain.model.ApiResponse
import com.test.app.domain.usecases.CarsUseCase
import com.test.app.ui.cars.CarsListViewModel
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class EmployeesListViewModelTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var carsUseCase: CarsUseCase

    private lateinit var carsViewModel: CarsListViewModel
    private lateinit var apiResponse: ApiResponse

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        carsViewModel = CarsListViewModel(carsUseCase)
        apiResponse = readJson("response.json")
    }

    @Test
    fun testEmployees() {
        runBlocking {
            Mockito.`when`(carsUseCase.employees()).thenReturn(Resource.success(apiResponse))
            carsViewModel.employees.observeForever {
                if (it.status == Resource.Status.SUCCESS) {
                    Assert.assertEquals(apiResponse, it.data)
                }
            }
        }
    }
}