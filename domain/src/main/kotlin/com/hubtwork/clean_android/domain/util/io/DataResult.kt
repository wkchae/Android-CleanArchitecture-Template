package com.hubtwork.clean_android.domain.util.io

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
sealed interface DataResult<out T: Any> {
    data class Success<T: Any>(val data: T): DataResult<T>
    sealed interface Failure: DataResult<Nothing> {
        data class Error(val error: DataError): Failure
        data class Exception(val cause: DataException): Failure
    }
}
