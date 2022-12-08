package com.hubtwork.clean_android.data.storage.database

import com.hubtwork.clean_android.data.storage.dao.PokemonDetailDao
import com.hubtwork.clean_android.data.storage.dao.PokemonThumbnailDao
import com.hubtwork.clean_android.data.storage.entity.mapper.PokemonDetailMapper
import com.hubtwork.clean_android.data.storage.entity.mapper.toDomain
import com.hubtwork.clean_android.data.storage.entity.mapper.toEntity
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.fail
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
@RunWith(RobolectricTestRunner::class)
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
    @Test
    fun `Thumbnail - Insert & Get`() {
        runBlocking {
            val initialData = thumbnailDao.getByGroupId(0)
            assertThat(initialData).isEmpty()
            val mockedThumbnailList = PokemonMockUtil.mockThumbnailList()
            thumbnailDao.insert(data = mockedThumbnailList.toEntity())
            val savedThumbnails = thumbnailDao.getByGroupId(0)
            assertThat(savedThumbnails).isNotEmpty
            val domainList = savedThumbnails.toDomain()
            assertThat(domainList.toString()).isEqualTo(mockedThumbnailList.toString())
        }
    }
    @Test
    fun `Detail - Insert & Get`() {
        runBlocking {
            val initialData = detailDao.getByName("bulbasaur")
            assertThat(initialData).isNull()
            val mockedDetail = PokemonMockUtil.mockDetail()
            detailDao.insert(data = PokemonDetailMapper.toEntity(domain = mockedDetail))
            val savedDetail = detailDao.getByName("bulbasaur")
            assertThat(savedDetail).isNotNull
            val domainDetail = PokemonDetailMapper.toDomain(
                entity = savedDetail ?: fail { "it must not be null" }
            )
            assertThat(domainDetail.height).isEqualTo(mockedDetail.height)
            assertThat(domainDetail.stats).isEqualTo(mockedDetail.stats)
            assertThat(domainDetail.types).isEqualTo(mockedDetail.types)
        }
    }

}