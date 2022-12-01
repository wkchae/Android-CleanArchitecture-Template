package com.hubtwork.clean_android.data.network.model.pokemon

import com.fasterxml.jackson.annotation.JsonProperty
import com.hubtwork.clean_android.data.network.model.ResponseModel
import com.hubtwork.clean_android.domain.model.Pokemon

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
data class FetchPokemonResponse(
    @field:JsonProperty("count")
    val count: Int? = null,
    @field:JsonProperty("next")
    val next: String? = null,
    @field:JsonProperty("previous")
    val previous: String? = null,
    @field:JsonProperty("results")
    val results: List<BasePokemonResponse>,
) {
    @Throws(NullPointerException::class)
    fun toDomain(groupId: Int): List<Pokemon> {
        count ?: throw NullPointerException()
        return results.map { it.toDomain(groupId) }
    }

    data class BasePokemonResponse(
        @field:JsonProperty("name")
        val name: String? = null,
        @field:JsonProperty("url")
        val url: String? = null,
    ) {
        fun toDomain(groupId: Int): Pokemon {
            val id = url?.split("/")?.dropLast(1)?.last() ?: throw NullPointerException()
            val imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$id.png"
            return Pokemon(
                name = name ?: throw NullPointerException(),
                image = imageUrl,
                groupId = groupId,
            )
        }
    }
}