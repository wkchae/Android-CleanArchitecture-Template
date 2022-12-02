package com.hubtwork.clean_android.data.network.model

import com.hubtwork.clean_android.data.network.util.InvalidResponseException

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
interface ResponseModel<out T> {
    val isValid: Boolean
    fun toDomain(): T
}
@Throws(InvalidResponseException::class)
fun <T> ResponseModel<T>.toDomainSafe(): T {
    try {
        if (!isValid) throw IllegalArgumentException()
        return toDomain()
    } catch (e: Throwable) {
        throw InvalidResponseException(e)
    }
}