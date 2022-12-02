package com.hubtwork.clean_android.data.network.util

import com.hubtwork.clean_android.data.BuildConfig
import com.hubtwork.clean_android.domain.util.io.*
import java.io.IOException
import java.net.SocketTimeoutException

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
private suspend fun <Domain: Any> exceptionHandler (
    handler: suspend () -> DataResult<Domain>
): DataResult<Domain> {
    return try {
        handler()
    } catch (ex: Throwable) {
        if (BuildConfig.DEBUG) ex.printStackTrace()
        when(ex) {
            is NetworkException -> {
                when (val cause = ex.cause) {
                    is NotConnectedException -> DataException(type = DataExceptionType.NoInternet)
                    is SocketTimeoutException -> DataException(type = DataExceptionType.TimeOut)
                    else -> DataException(type = DataExceptionType.Unknown(cause))
                }
            }
            // Exception occurred during parse response,
            // Response is successfully sent from server but some elements are wrong formats
            is DataException.JSONParseException -> DataResult.Failure.Exception(cause = DataException.JSONParseException)
            is HttpException -> ApiError(code = ERROR.parse(ex.code().toString()))
            else -> ApiException(code = ApiExceptionCode.UNKNOWN)
        }
    }
}