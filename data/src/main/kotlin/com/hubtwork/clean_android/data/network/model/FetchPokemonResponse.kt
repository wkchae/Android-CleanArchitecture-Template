package com.hubtwork.clean_android.data.network.model

import com.fasterxml.jackson.annotation.JsonProperty

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
    val results: List<FetchPokemonResponse>
)