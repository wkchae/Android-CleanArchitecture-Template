package com.hubtwork.clean_android.data.storage.database

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.hubtwork.clean_android.data.storage.util.JSONParser
import com.hubtwork.clean_android.data.storage.util.JacksonParser
import com.hubtwork.clean_android.data.storage.util.PokemonTypeConverter
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
@RunWith(RobolectricTestRunner::class)
abstract class MockDB {
    lateinit var db: PokemonDatabase

    @Before
    fun startMock() {
        val parser: JSONParser = JacksonParser(mapper = jacksonObjectMapper())
        db = Room
            .inMemoryDatabaseBuilder(getApplicationContext(), PokemonDatabase::class.java)
            .allowMainThreadQueries()
            .addTypeConverter(PokemonTypeConverter(parser = parser))
            .build()
    }
    @After
    fun endMock() {
        db.close()
    }

}