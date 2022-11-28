package com.hubtwork.clean_android.domain.util.io

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */

suspend fun <T: Any> DataResult<T>.onSuccess(
    handler: suspend (T) -> Unit
): DataResult<T> = apply {
    // Smart Cast to success
    if (this is DataResult.Success<T>) handler(data)
}
suspend fun <T: Any> DataResult<T>.onError(
    handler: suspend (error: DataError) -> Unit
): DataResult<T> = apply {
    // Smart Cast to error
    if (this is DataResult.Failure.Error) handler(error)
}
suspend fun <T: Any> DataResult<T>.onException(
    handler: suspend (cause: DataException) -> Unit
): DataResult<T> = apply {
    // Smart Cast to exception
    if (this is DataResult.Failure.Exception) handler(cause)
}

suspend fun <T: Any> DataResult<T>.onFinally(
    handler: suspend () -> Unit
): DataResult<T> = apply {
    handler()
}