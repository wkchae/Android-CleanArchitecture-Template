package com.hubtwork.clean_android.domain.util.io

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */

enum class NetworkError {
    NoInternet,
    TimeOut,
    JsonParseError,

    Unknown
}
sealed interface DataErrorType {
    data class HTTP(val statusCode: Int): DataErrorType

    data class Network(val e: NetworkError): DataErrorType

    object Unknown: DataErrorType
}