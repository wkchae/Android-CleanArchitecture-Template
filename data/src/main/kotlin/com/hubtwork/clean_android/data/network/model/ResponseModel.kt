package com.hubtwork.clean_android.data.network.model

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
interface ResponseModel<out T> {
    val isValid: Boolean
    fun toDomain(): T
}