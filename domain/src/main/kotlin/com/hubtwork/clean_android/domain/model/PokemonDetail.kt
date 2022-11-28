package com.hubtwork.clean_android.domain.model

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
data class PokemonDetail(
    val name: String,

    val stat: Stat,
) {




    data class Stat(
        val hp: Int,
        val speed: Int,
        val attack: Int,
        val defense: Int,
        val specialAttack: Int,
        val specialDefense: Int,
    ) {
        val maxStat: Int = 300
    }
}