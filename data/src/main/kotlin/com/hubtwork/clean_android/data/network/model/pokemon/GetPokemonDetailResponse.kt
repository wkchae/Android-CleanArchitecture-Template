package com.hubtwork.clean_android.data.network.model.pokemon

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.hubtwork.clean_android.data.network.model.ResponseModel
import com.hubtwork.clean_android.domain.model.PokemonDetail
import com.hubtwork.clean_android.domain.model.PokemonDetail.Stats.Companion.extractStats
import com.hubtwork.clean_android.domain.model.PokemonType
import com.hubtwork.clean_android.domain.model.StatParam

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
data class GetPokemonDetailResponse(
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
    val statSlots: List<Stat>,
    @field:JsonProperty("types")
    val types: List<TypeSlot>,
): ResponseModel<PokemonDetail> {

    data class TypeSlot(
        @field:JsonProperty("slot")
        val slot: Int? = null,
        @field:JsonProperty("type")
        val type: TypeResponse? = null,
    ) {
        @Throws(NullPointerException::class)
        fun convert(): PokemonType {
            val name = type?.name ?: throw NullPointerException()
            return PokemonType from name
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        data class TypeResponse (
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

    override val isValid: Boolean
        get() = id != null && name != null
                && experience != null && weight != null && height != null

    override fun toDomain(): PokemonDetail {
        val stats = statSlots.map { it.convert() }
            .associate { it.first to StatParam(it.second, it.third) }
            .extractStats()
        val types = types.sortedBy { it.slot }.map { it.convert() }

        return PokemonDetail(
            id = id!!,
            name = name!!,
            experience = experience!!,
            weight = weight!!,
            height = height!!,
            stats = stats,
            types = types,
        )
    }
}