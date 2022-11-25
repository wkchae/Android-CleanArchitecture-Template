package com.hubtwork.clean_android.domain.util.io

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
sealed interface DataError {


    sealed interface HttpError: DataError {
        object InternalError : HttpError

    }

    sealed interface ApiError: DataError {
        object Example: ApiError

    }

    object Unknown: HttpError, ApiError


    fun parseHttpError(httpStatusCode: Int): HttpError {
        return when(httpStatusCode) {
            500 -> HttpError.InternalError
            else -> Unknown
        }
    }
    fun parseApiError(apiStatusCode: Int): ApiError {
        return when(apiStatusCode) {
            -100 -> ApiError.Example
            else -> return Unknown
        }
    }
}