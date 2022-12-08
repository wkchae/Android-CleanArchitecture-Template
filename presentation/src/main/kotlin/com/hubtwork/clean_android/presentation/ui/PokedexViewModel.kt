package com.hubtwork.clean_android.presentation.ui

import androidx.lifecycle.ViewModel
import com.hubtwork.clean_android.domain.usecase.FetchPokemonListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
@HiltViewModel
class PokedexViewModel @Inject constructor(
    private val fetchPokemon: FetchPokemonListUseCase

): ViewModel() {

    fun fetch() {

    }
}