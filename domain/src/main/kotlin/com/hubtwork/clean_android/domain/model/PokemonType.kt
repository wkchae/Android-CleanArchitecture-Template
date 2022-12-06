package com.hubtwork.clean_android.domain.model

import com.hubtwork.clean_android.domain.util.extension.EnumHelper

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
enum class PokemonType {
    Normal, Fighting, Flying, Poison, Ground,
    Rock, Bug, Ghost, Steel, Fire,
    Water, Grass, Electric, Psychic, Ice,
    Dragon, Dark, Fairy, Unknown, Shadow;

    companion object : EnumHelper<String, PokemonType>(valueMap = PokemonType.values().associateBy { it.name.lowercase() })
}