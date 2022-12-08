package com.hubtwork.clean_android.data.repository

import com.hubtwork.clean_android.data.network.service.PokemonClient
import com.hubtwork.clean_android.data.storage.PokemonStorage
import com.hubtwork.clean_android.domain.model.PokemonThumbnail
import com.hubtwork.clean_android.domain.repository.PokemonRepository
import com.hubtwork.clean_android.domain.util.io.*
import javax.inject.Inject

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
class PokemonRepositoryImpl @Inject constructor(
    private val service: PokemonClient,
    private val storage: PokemonStorage,
): PokemonRepository {

    override suspend fun fetchPokemonList(groupId: Int): DataResult<List<PokemonThumbnail>> {
        val pokemonList = storage.getPokemonList(groupId = groupId)
        return if (pokemonList.isEmpty()) {
            // launch api service
            service.fetchPokemonList(groupId = groupId)
                .onSuccess { data ->
                    data.forEach { it.markGroup(id = groupId) }
                    storage.savePokemonList(data = data)
                    DataResult.Success(data = data)
                }
                .onError { DataError(type = it) }
                .onException { DataException(type = it) }
        } else DataResult.Success(data = pokemonList)
    }


}