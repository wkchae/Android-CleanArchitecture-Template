package com.hubtwork.clean_android.domain.util.io

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */

typealias DataSuccess<Domain> = DataResult.Success<Domain>
typealias DataError = DataResult.Failure.Error
typealias DataException = DataResult.Failure.Exception

sealed interface DataResult<out T> {
    data class Success<T: Any>(val data: T): DataResult<T>

    sealed interface Failure: DataResult<Nothing> {
        data class Error(val type: DataErrorType): Failure
        data class Exception(val type: DataExceptionType): Failure
    }
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
suspend fun <T: Any> DataResult<T>.onException(
    handler: suspend (error: DataExceptionType) -> Unit
): DataResult<T> = apply {
    // Smart Cast to error
    if (this is DataException) handler(type)
}
suspend fun <T: Any> DataResult<T>.onFinally(
    handler: suspend () -> Unit
): DataResult<T> = apply {
    handler()
}