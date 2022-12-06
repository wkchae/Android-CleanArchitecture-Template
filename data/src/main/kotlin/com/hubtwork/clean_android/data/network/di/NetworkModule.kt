package com.hubtwork.clean_android.data.network.di

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.hubtwork.clean_android.data.BuildConfig
import com.hubtwork.clean_android.data.network.interceptor.RequestInterceptor
import com.hubtwork.clean_android.data.network.service.Endpoint
import com.hubtwork.clean_android.data.network.service.PokeApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val client = OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .addInterceptor(RequestInterceptor())
        if (!BuildConfig.DEBUG) return client.build()
        return client
            .addInterceptor(
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            )
            .build()
    }

    @Provides
    @Singleton
    fun provideJacksonMapper(): JacksonConverterFactory {
        return JacksonConverterFactory.create(
            ObjectMapper()
                .configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false)
                .registerKotlinModule()
        )
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        jacksonConverterFactory: JacksonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(Endpoint.base)
            .addConverterFactory(jacksonConverterFactory)
            .build()
    }

    @Provides
    @Singleton
    fun providePokeApiService(retrofit: Retrofit): PokeApiService {
        return retrofit.create(PokeApiService::class.java)
    }


}