package com.hubtwork.clean_android.data.network.api

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import java.nio.charset.StandardCharsets

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
/**
 * Mock API client for test retrofit services.
 *
 */

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class MockAPI<T> {
    private lateinit var mockServer: MockWebServer
    // for test check is mock server initialized
    val isMockServerInitialized get() = ::mockServer.isInitialized
    /** control Mock Server Lifecycle with Test class */
    @BeforeAll
    fun startMock() {
        mockServer = MockWebServer()
    }
    @AfterAll
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
        return Retrofit.Builder()
            .baseUrl(mockServer.url("/"))
            .addConverterFactory(jacksonFactory)
            .build()
            .create(clazz)
    }
    /** mock function for enqueue response */
    fun enqueueResponse(fileName: String) { enqueueMockResponse(fileName = fileName, headers = emptyMap()) }
    fun enqueueStringResponse(data: String) { enqueueMockStringResponse(data = data, headers = emptyMap()) }
    private fun enqueueMockStringResponse(data: String, headers: Map<String, String>) {
        val response = MockResponse()
        headers.forEach { (key, value) -> response.addHeader(key, value) }
        mockServer.enqueue(response.setBody(body = data))
    }
    private fun enqueueMockResponse(fileName: String, headers: Map<String, String>) {
        val input = javaClass.classLoader!!.getResourceAsStream("responses/$fileName")
        val source = input.source().buffer()
        val response = MockResponse()
        headers.forEach { (key, value) -> response.addHeader(key, value) }
        mockServer.enqueue(response.setBody(body = source.readString(StandardCharsets.UTF_8)))
    }
}