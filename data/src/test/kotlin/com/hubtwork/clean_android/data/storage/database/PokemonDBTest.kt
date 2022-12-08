package com.hubtwork.clean_android.data.storage.database

import com.hubtwork.clean_android.data.storage.dao.PokemonDetailDao
import com.hubtwork.clean_android.data.storage.dao.PokemonThumbnailDao
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [21])
class PokemonDBTest: MockDB() {

    private lateinit var thumbnailDao: PokemonThumbnailDao
    private lateinit var detailDao: PokemonDetailDao

    @Before
    fun setup() {
        thumbnailDao = db.thumbnailDao()
        detailDao = db.detailDao()
    }

    @Test
    fun `DAO call test - empty`() {
        val emptyListInDB = runBlocking { thumbnailDao.getAll(5) }
        assertThat(emptyListInDB).isEmpty()
    }

}