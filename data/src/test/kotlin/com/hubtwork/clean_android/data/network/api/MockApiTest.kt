package com.hubtwork.clean_android.data.network.api

import com.fasterxml.jackson.annotation.JsonProperty
import com.hubtwork.clean_android.data.network.model.ResponseModel
import com.hubtwork.clean_android.data.network.util.handle
import com.hubtwork.clean_android.domain.util.io.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.runTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.fail
import retrofit2.Response
import retrofit2.http.GET

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
@OptIn(ExperimentalCoroutinesApi::class)
@DisplayName("Mocked API Test")
class MockApiTest: MockAPI<MockApiTest.TestApiService>() {
    private val mockData = """
            { "data": "test" }
        """.trimIndent()
    /** model for test MockAPI */
    data class TestModel(
        @field:JsonProperty("data")
        val data: String? = null
    ): ResponseModel<String> {
        override val isValid: Boolean get() = data != null
        override fun toDomain(): String = data!!
    }
    /** service interface for test MockAPI */
    interface TestApiService {
        @GET("/")
        suspend fun getTest(): Response<TestModel>
    }

    private lateinit var service: TestApiService
    @BeforeEach
    fun initService() { service = createService(TestApiService::class.java) }

    @Test
    @DisplayName("service created")
    fun t1() {
        assertThat(isMockServerInitialized).isEqualTo(true)
        assertThat(::service.isInitialized).isEqualTo(true)
    }
    @Test
    @DisplayName("exception occurs within api request")
    fun t2() = runTest {
        enqueueNoResponse()
        try {
            val response = handle { service.getTest() }
            assertThat(response).isInstanceOf(DataException::class.java)
            response
                .onSuccess { fail { "it must be treat as exception" } }
                .onError { fail { "it must be treat as exception" } }
                .onException { type -> assertThat(type).isInstanceOf(DataExceptionType.TimeOut::class.java) }
        } catch(e: Throwable) {
            fail { "throwable occurs in http request must be wrapped as DataException." }
        }
    }

    @Test
    @DisplayName("response is successfully mocked")
    fun t3() = runTest {
        enqueueStringResponse(data = mockData)
        val response = service.getTest()
        assertThat(response.isSuccessful).isEqualTo(true)
        assertThat(response.body() != null && response.body() is TestModel).isEqualTo(true)
        val data = response.body()?.data ?: fail { "it must be not null" }
        assertThat(data).isEqualTo("test")
    }

}