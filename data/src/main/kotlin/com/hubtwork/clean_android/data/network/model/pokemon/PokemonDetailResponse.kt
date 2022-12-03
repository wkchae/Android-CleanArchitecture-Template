package com.hubtwork.clean_android.data.network.model.pokemon

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
data class PokemonDetailResponse(
    @field:JsonProperty("id")
    val id: Int? = null,
    @field:JsonProperty("name")
    val name: String? = null,
    @field:JsonProperty("base_experience")
    val experience: Int? = null,
    @field:JsonProperty("height")
    val height: Int? = null,
    @field:JsonProperty("weight")
    val weight: Int? = null,

    @field:JsonProperty("stats")
    val stats: List<Stat>,
    @field:JsonProperty("types")
    val types: List<TypeSlot>,
) {



    data class TypeSlot(
        @field:JsonProperty("slot")
        val slot: Int? = null,
        @field:JsonProperty("type")
        val type: Type? = null,
    ) {
        @Throws(NullPointerException::class)
        fun convert(): Pair<Int, String> {
            return Pair(
                slot ?: throw NullPointerException(),
                type?.name ?: throw NullPointerException()
            )
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        data class Type(
            @field:JsonProperty("name")
            val name: String? = null,
        )
    }

    data class Stat(
        @field:JsonProperty("stat")
        val stat: StatName? = null,
        @field:JsonProperty("base_stat")
        val base: Int? = null,
        @field:JsonProperty("effort")
        val effort: Int? = null,
    ) {
        @Throws(NullPointerException::class)
        fun convert(): Triple<String, Int, Int> {
            return Triple(
                stat?.name ?: throw NullPointerException(),
                base ?: throw NullPointerException(),
                effort ?: throw NullPointerException()
            )
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        data class StatName(
            @field:JsonProperty("name")
            val name: String? = null,
        )
    }
}