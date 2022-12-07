package com.hubtwork.clean_android.data.storage.di

import android.app.Application
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.hubtwork.clean_android.data.storage.database.PokemonDatabase
import com.hubtwork.clean_android.data.storage.util.JSONParser
import com.hubtwork.clean_android.data.storage.util.JacksonParser
import com.hubtwork.clean_android.data.storage.util.PokemonTypeConverter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */

@Module
@InstallIn(SingletonComponent::class)
object StorageModule {

    @Provides
    @Singleton
    fun provideJacksonObjectMapper(): ObjectMapper = jacksonObjectMapper()

    @Provides
    @Singleton
    fun provideJacksonParser(
        mapper: ObjectMapper
    ): JSONParser = JacksonParser(mapper)

    @Provides
    @Singleton
    fun providePokemonTypeConverter(
        parser: JSONParser
    ): PokemonTypeConverter = PokemonTypeConverter(parser = parser)

    @Provides
    @Singleton
    fun provideAppDatabase(
        application: Application,
        typeConverter: PokemonTypeConverter
    ): PokemonDatabase {
        return PokemonDatabase.build(
            applicationContext = application,
            typeConverter = typeConverter
        )
    }
}