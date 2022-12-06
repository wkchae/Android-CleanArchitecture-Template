package com.hubtwork.clean_android.domain.repository

import com.hubtwork.clean_android.domain.model.PokemonThumbnail
import com.hubtwork.clean_android.domain.util.io.DataResult

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
interface PokemonRepository {
    suspend fun fetchPokemonList(
        groupId: Int
    ): DataResult<List<PokemonThumbnail>>
}