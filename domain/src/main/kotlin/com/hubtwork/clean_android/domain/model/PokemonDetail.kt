package com.hubtwork.clean_android.domain.model

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
data class PokemonDetail (
    // identifiers
    val id: Int,
    val name: String,
    // base
    val experience: Int,
    val weight: Int,
    val height: Int,
    // stats
    val stats: Stats,
    // types
    val types: List<PokemonType>,
) {




    data class Stats(
        val hp: Stat,
        val speed: Stat,
        val attack: Stat,
        val defense: Stat,
        val specialAttack: Stat,
        val specialDefense: Stat,
    ) {
        companion object {
            fun Map<String, StatParam>.extractStats(): Stats {
                return Stats(
                    hp = get("hp") ?.let { Stat(it) } ?: Stat(),
                    speed = get("speed") ?.let { Stat(it) } ?: Stat(),
                    attack = get("attack") ?.let { Stat(it) } ?: Stat(),
                    defense = get("defense") ?.let { Stat(it) } ?: Stat(),
                    specialAttack = get("special-attack") ?.let { Stat(it) } ?: Stat(),
                    specialDefense = get("special-defense") ?.let { Stat(it) } ?: Stat(),
                )
            }
        }
    }
}