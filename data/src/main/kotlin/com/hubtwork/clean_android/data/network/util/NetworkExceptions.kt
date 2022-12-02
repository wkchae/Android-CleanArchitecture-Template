package com.hubtwork.clean_android.data.network.util

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */

open class NetworkException: Exception {
    constructor() : super()
    constructor(msg: String) : super(msg)
    constructor(msg: String, cause: Throwable) : super(msg, cause)
    constructor(cause: Throwable?) : super(cause)
}

/** Received invalid response.  */
class InvalidResponseException(msg: String): NetworkException(msg)
/** Client request some http connection, but no internet supported or host is incorrect */
data class NotConnectedException(val e: Exception): NetworkException(e)
/** Client didn't receive response from server in timeout constraint */
data class RequestTimeoutException(val e: Exception): NetworkException(e)
/** Unknown Exception */
data class UnknownException(val e: Throwable?): NetworkException(e)