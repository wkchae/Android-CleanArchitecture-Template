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
data class Pokemon(
    val name: String,
    val image: String,
    val groupId: Int,
)