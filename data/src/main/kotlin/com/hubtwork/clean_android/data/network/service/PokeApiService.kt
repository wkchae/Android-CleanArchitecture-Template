package com.hubtwork.clean_android.data.network.service

import com.hubtwork.clean_android.data.network.model.pokemon.FetchPokemonResponse
import com.hubtwork.clean_android.data.network.model.pokemon.PokemonDetailResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
interface PokeApiService {
    @GET(Endpoint.GetPokemonList)
    suspend fun fetchPokemon(
        @Query("offset") offset: Int = 0,
        @Query("limit") limit: Int = 20,
    ): Response<FetchPokemonResponse>

    @GET(Endpoint.GetPokemonDetail)
    suspend fun getPokemonDetail(
        @Path("name") pokemonName: String
    ): Response<PokemonDetailResponse>

}