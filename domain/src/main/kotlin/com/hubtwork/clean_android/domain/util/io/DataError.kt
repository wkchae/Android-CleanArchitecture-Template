package com.hubtwork.clean_android.domain.util.io

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */

enum class HttpError {

    InternalServerError
}
sealed interface DataError {
    data class HTTP(val e: HttpError): DataError

    object Unknown: DataError

    fun parseHttpError(httpStatusCode: Int): DataError {
        val e: HttpError? = when(httpStatusCode) {
            500 -> HttpError.InternalServerError
            else -> null
        }
        return e?.let { HTTP(it) } ?:run { Unknown }
    }
}