package com.hubtwork.clean_android.data.network.service

import com.hubtwork.clean_android.data.network.util.handle
import com.hubtwork.clean_android.domain.model.Pokemon
import com.hubtwork.clean_android.domain.util.io.DataResult
import javax.inject.Inject

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
class PokemonClient @Inject constructor(
    private val service: PokeApiService
) {
    /**
     *
     * given parameter groupId is in (0..N)
     * ex) if want to fetch 0 group (1 ~ 20), offset = 0 and limit = 20.
     */
    suspend fun fetchPokemonList(
        groupId: Int
    ): DataResult<List<Pokemon>> {
        return handle {
            service.fetchPokemon(
                offset = groupId * PAGE_CHUNK_SIZE,
                limit = PAGE_CHUNK_SIZE
            )
        }
    }

    companion object {
        const val PAGE_CHUNK_SIZE = 20
    }
}