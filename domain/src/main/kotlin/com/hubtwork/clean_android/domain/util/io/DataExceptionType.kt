package com.hubtwork.clean_android.domain.util.io

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */

sealed interface DataExceptionType {
    object NoInternet: DataExceptionType
    object TimeOut: DataExceptionType
    object JsonParse: DataExceptionType

    data class Unknown(val ex: Throwable?): DataExceptionType
}