package com.hubtwork.clean_android.data.storage.database

import com.hubtwork.clean_android.domain.model.PokemonDetail
import com.hubtwork.clean_android.domain.model.PokemonThumbnail
import com.hubtwork.clean_android.domain.model.PokemonType
import com.hubtwork.clean_android.domain.model.Stat

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
object PokemonMockUtil {

    fun mockThumbnail() = PokemonThumbnail(
        name = "bulbasaur",
        image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png"
    ).apply { markGroup(1) }
    fun mockThumbnailList() = listOf<PokemonThumbnail>(mockThumbnail())

    fun mockDetail() = PokemonDetail(
        id = 1,
        name = "bulbasaur",
        experience = 64,
        weight = 69,
        height = 7,
        stats = PokemonDetail.Stats(
            hp = Stat(base = 45, effort = 0),
            speed = Stat(base = 45, effort = 0),
            attack = Stat(base = 49, effort = 0),
            defense = Stat(base = 49, effort = 0),
            specialAttack = Stat(base = 65, effort = 1),
            specialDefense = Stat(base = 65, effort = 0),
        ),
        types = listOf(PokemonType.Grass, PokemonType.Poison)
    )
}