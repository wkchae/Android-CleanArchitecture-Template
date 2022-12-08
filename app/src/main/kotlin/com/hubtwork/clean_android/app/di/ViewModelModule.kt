package com.hubtwork.clean_android.app.di

import com.hubtwork.clean_android.data.network.service.PokemonClient
import com.hubtwork.clean_android.data.repository.PokemonRepositoryImpl
import com.hubtwork.clean_android.data.storage.PokemonStorage
import com.hubtwork.clean_android.domain.repository.PokemonRepository
import com.hubtwork.clean_android.domain.usecase.FetchPokemonListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
@Module
@InstallIn(ViewModelComponent::class)
class ViewModelModule {

    @Provides
    fun providePokemonRepository(
        service: PokemonClient,
        storage: PokemonStorage
    ): PokemonRepository = PokemonRepositoryImpl(service = service, storage = storage)


    @Provides
    fun provideFetchPokemon(repository: PokemonRepository) = FetchPokemonListUseCase(repository)
}