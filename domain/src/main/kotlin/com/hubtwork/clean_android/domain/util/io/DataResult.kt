package com.hubtwork.clean_android.domain.util.io

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */

typealias DataSuccess<Domain> = DataResult.Success<Domain>
typealias DataError = DataResult.Error

sealed interface DataResult<out T: Any> {
    data class Success<T: Any>(val data: T): DataResult<T>
    data class Error(val type: DataErrorType): DataResult<Nothing>
}

suspend fun <T: Any> DataResult<T>.onSuccess(
    handler: suspend (T) -> Unit
): DataResult<T> = apply {
    // Smart Cast to success
    if (this is DataSuccess<T>) handler(data)
}
suspend fun <T: Any> DataResult<T>.onError(
    handler: suspend (error: DataErrorType) -> Unit
): DataResult<T> = apply {
    // Smart Cast to error
    if (this is DataError) handler(type)
}
suspend fun <T: Any> DataResult<T>.onFinally(
    handler: suspend () -> Unit
): DataResult<T> = apply {
    handler()
}