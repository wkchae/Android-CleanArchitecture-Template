package com.hubtwork.clean_android.data.network.api

import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import retrofit2.Response
import retrofit2.http.GET

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */

data class TestModel(
    @field:JsonProperty("data")
    val data: String
)

interface TestApiService {
    @GET("/")
    suspend fun getTest(): Response<TestModel>
}

@OptIn(ExperimentalCoroutinesApi::class)
class MockApiTest: MockAPI<TestApiService>() {
    private lateinit var service: TestApiService
    @BeforeAll
    fun initService() { service = createService(TestApiService::class.java) }

    @Test
    @DisplayName("service created")
    fun t1() {
        assertThat(isMockServerInitialized).isEqualTo(true)
        assertThat(::service.isInitialized).isEqualTo(true)
    }
    @Test
    @DisplayName("response is successfully mocked")
    fun t2() = runTest {
        val mockData = """
            { "data": "test" }
        """.trimIndent()
        enqueueStringResponse(data = mockData)
        val response = service.getTest()
        assertThat(response.isSuccessful).isEqualTo(true)
        assertThat(response.body() != null && response.body() is TestModel).isEqualTo(true)
        val data = response.body()?.data
        assertThat(data).isEqualTo("test")
    }
}