package com.hubtwork.clean_android.data.network.model

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
data class BasePokemonResponse(
    @field:JsonProperty("name")
    val name: String? = null,
    @field:JsonProperty("url")
    val url: String? = null,
) {

}