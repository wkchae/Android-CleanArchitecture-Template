package com.hubtwork.clean_android.domain.usecase

import com.hubtwork.clean_android.domain.repository.PokemonRepository

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
class FetchPokemonListUseCase(private val repository: PokemonRepository) {
    suspend operator fun invoke(groupId: Int) =
        repository.fetchPokemonList(groupId)
}