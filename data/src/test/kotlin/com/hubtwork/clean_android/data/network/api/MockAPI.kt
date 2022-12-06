package com.hubtwork.clean_android.data.network.api

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.hubtwork.clean_android.data.network.interceptor.RequestInterceptor
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.SocketPolicy
import okio.buffer
import okio.source
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.TestInstance
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import java.nio.charset.StandardCharsets
import java.util.concurrent.TimeUnit

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
/**
 * Mock API client for test retrofit services.
 *
 * @author hubtwork ( Alen Heo )
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class MockAPI<T> {
    private lateinit var mockServer: MockWebServer
    // for test check is mock server initialized
    val isMockServerInitialized get() = ::mockServer.isInitialized
    /** control Mock Server Lifecycle with Test class */
    @BeforeEach
    fun startMock() {
        mockServer = MockWebServer()
        mockServer.start()
    }
    @AfterEach
    fun endMock() {
        mockServer.shutdown()
    }
    /** Service Injector functions */
    fun createService(clazz: Class<T>): T {
        val jacksonFactory = JacksonConverterFactory.create(
            ObjectMapper()
                .configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false)
                .registerKotlinModule()
        )
        val client = OkHttpClient.Builder()
            .connectTimeout(2, TimeUnit.SECONDS)
            .readTimeout(2, TimeUnit.SECONDS)
            .addInterceptor(RequestInterceptor())
            .build()
        return Retrofit.Builder()
            .baseUrl(mockServer.url("/"))
            .addConverterFactory(jacksonFactory)
            .client(client)
            .build()
            .create(clazz)
    }
    /** mock function for enqueue response */
    fun enqueueNoResponse() { mockServer.enqueue(MockResponse().setSocketPolicy(SocketPolicy.NO_RESPONSE)) }
    fun enqueueResponse(fileName: String) { enqueueFileMockResponse(fileName = fileName, headers = emptyMap()) }
    fun enqueueStringResponse(data: String) { enqueueStringMockResponse(data = data, headers = emptyMap()) }
    private fun enqueueStringMockResponse(data: String, headers: Map<String, String>) {
        val response = MockResponse()
        headers.forEach { (key, value) -> response.addHeader(key, value) }
        mockServer.enqueue(response.setBody(body = data))
    }
    private fun enqueueFileMockResponse(fileName: String, headers: Map<String, String>) {
        val input = javaClass.classLoader!!.getResourceAsStream("responses/$fileName")
        val source = input.source().buffer()
        val response = MockResponse()
        headers.forEach { (key, value) -> response.addHeader(key, value) }
        mockServer.enqueue(response.setBody(body = source.readString(StandardCharsets.UTF_8)))
    }
}