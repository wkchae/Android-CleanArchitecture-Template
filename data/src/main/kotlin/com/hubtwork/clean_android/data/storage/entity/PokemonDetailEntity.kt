package com.hubtwork.clean_android.data.storage.entity

import androidx.room.Embedded
import androidx.room.PrimaryKey
import com.hubtwork.clean_android.domain.model.PokemonDetail
import com.hubtwork.clean_android.domain.model.PokemonType

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
data class PokemonDetailEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val experience: Int,
    val weight: Int,
    val height: Int,
    // stats
    @Embedded
    val stats: PokemonDetail.Stats,
    val types: List<PokemonType>,
)