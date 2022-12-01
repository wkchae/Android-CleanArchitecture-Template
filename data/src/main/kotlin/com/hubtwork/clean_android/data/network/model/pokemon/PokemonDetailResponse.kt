package com.hubtwork.clean_android.data.network.model.pokemon

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
data class PokemonDetailResponse(
    @field:JsonProperty("name")
    val name: String? = null,

)