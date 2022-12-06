package com.hubtwork.clean_android.data.network.util

import com.hubtwork.clean_android.data.BuildConfig
import com.hubtwork.clean_android.data.network.model.ResponseModel
import com.hubtwork.clean_android.data.network.model.toDomainSafe
import com.hubtwork.clean_android.domain.util.io.*
import retrofit2.Response
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
//        if (BuildConfig.DEBUG) ex.printStackTrace()
        when(ex) {
            is NetworkException -> ex.result
            else -> DataException(type = DataExceptionType.Unknown(ex))
        }
    }
}

suspend fun <T: ResponseModel<V>, V: Any> handle (
    response: suspend () -> Response<T>
): DataResult<V> {
    return exceptionHandler {
        response().let {
            val body = it.body()
            // Retrofit Request Layer
            if (it.isSuccessful && body != null) {
                DataSuccess(body.toDomainSafe())
            } else {
                DataError(type = DataErrorType.HTTP(it.code()))
            }
        }
    }
}