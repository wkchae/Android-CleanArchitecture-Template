package com.hubtwork.clean_android.data.storage.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
@Entity
data class PokemonThumbnailEntity(
    @PrimaryKey
    val name: String,
    val imageUrl: String,
    val groupId: Int,
)