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
): ResponseModel<List<Pokemon>> {
    override val isValid: Boolean
        get() = count != null
    @Throws(NullPointerException::class)
    override fun toDomain(): List<Pokemon> {
        return results.map { it.toDomain() }
    }

    data class BasePokemonResponse(
        @field:JsonProperty("name")
        val name: String? = null,
        @field:JsonProperty("url")
        val url: String? = null,
    ): ResponseModel<Pokemon> {
        override val isValid: Boolean
            get() = !name.isNullOrEmpty() && !url.isNullOrEmpty()
        override fun toDomain(): Pokemon {
            val id = url?.split("/")?.dropLast(1)?.last() ?: throw NullPointerException()
            val imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$id.png"
            return Pokemon(
                name = name ?: throw NullPointerException(),
                image = imageUrl,
            )
        }
    }
}
