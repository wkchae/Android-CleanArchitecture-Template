package com.hubtwork.clean_android.data.storage

import com.hubtwork.clean_android.data.storage.database.PokemonDatabase
import com.hubtwork.clean_android.data.storage.entity.mapper.toDomain
import com.hubtwork.clean_android.data.storage.entity.mapper.toEntity
import com.hubtwork.clean_android.domain.model.PokemonDetail
import com.hubtwork.clean_android.domain.model.PokemonThumbnail
import javax.inject.Inject

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */

class PokemonStorage @Inject constructor(
    database: PokemonDatabase
) {
    private val thumbnailDao by lazy { database.thumbnailDao() }
    private val detailDao by lazy { database.detailDao() }

    suspend fun getPokemonList(groupId: Int = 0): List<PokemonThumbnail> {
        return thumbnailDao.getByGroupId(groupId).toDomain()
    }

    suspend fun savePokemonList(data: List<PokemonThumbnail>) {
        thumbnailDao.insert(data = data.toEntity())
    }

    suspend fun getPokemonDetail(name: String): PokemonDetail? {
        val result = detailDao.getByName(name) ?: return null
        return result.toDomain()
    }

    suspend fun savePokemonDetail(data: PokemonDetail) {
        detailDao.insert(data = data.toEntity())
    }

}