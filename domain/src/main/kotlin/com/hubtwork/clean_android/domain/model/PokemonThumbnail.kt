package com.hubtwork.clean_android.domain.model

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
/**
 * @property name [String] pokemon's name
 * @property image [String] pokemon's imageUrl
 * @property groupId [String] pokemon's included groupId
 */
data class PokemonThumbnail(
    val name: String,
    val image: String,
) {
    private var _groupId: Int = 0
    val groupId: Int get() = _groupId
    fun markGroup(id: Int) { _groupId = id }
}