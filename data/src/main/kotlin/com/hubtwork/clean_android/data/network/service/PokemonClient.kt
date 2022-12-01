package com.hubtwork.clean_android.data.network.service

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
    suspend fun fetchPokemonList(
        offset: Int,
        limit: Int,
    ): DataResult<List<Pokemon>> {
        service.fetchPokemon(

        )
    }
}