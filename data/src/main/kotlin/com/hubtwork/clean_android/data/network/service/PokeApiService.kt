package com.hubtwork.clean_android.data.network.service

import com.hubtwork.clean_android.data.network.model.pokemon.FetchPokemonListResponse
import com.hubtwork.clean_android.data.network.model.pokemon.GetPokemonDetailResponse
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
    suspend fun fetchPokemonList(
        @Query("offset") offset: Int = 0,
        @Query("limit") limit: Int = 20,
    ): Response<FetchPokemonListResponse>

    @GET(Endpoint.GetPokemonDetail)
    suspend fun getPokemonDetail(
        @Path("name") pokemonName: String
    ): Response<GetPokemonDetailResponse>

}