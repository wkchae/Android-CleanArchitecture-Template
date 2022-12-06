package com.hubtwork.clean_android.data.network.util

import com.hubtwork.clean_android.domain.util.io.DataException
import com.hubtwork.clean_android.domain.util.io.DataExceptionType
import java.io.IOException

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
/**
 * CustomNetworkException.
 *
 * in internal running for [okhttp3] call request,
 * (1) non-[IOException] throwable : throws re-wrapped by [IOException] with add as suppressed.
 * (2) [IOException] throwable : throws as exception itself.
 *
 * To treat as custom exceptions, [NetworkException] extends [IOException]
 *
 * @author hubtwork ( Alen Heo )
 * @see [okhttp3.internal.connection.RealCall]
 */
abstract class NetworkException: IOException {
    constructor() : super()
    constructor(msg: String) : super(msg)
    constructor(msg: String, cause: Throwable) : super(msg, cause)
    constructor(cause: Throwable?) : super(cause)

    /**
     * mapped value as [DataException]
     */
    abstract val result: DataException
}

/**
 * Invalid Response Exception from api server.
 *
 * It means failure during parsing JSON response from API.
 * @author hubtwork ( Alen Heo )
 * */
data class InvalidResponseException(
    val e: Throwable,
    override val result: DataException = DataException(type = DataExceptionType.JsonParse)
): NetworkException(e)
/**
 * Unknown Host Exception from api server.
 *
 * Client request some http connection, but no internet supported or host is incorrect
 * @author hubtwork ( Alen Heo )
 * */
data class NotConnectedException(
    val e: Throwable,
    override val result: DataException = DataException(type = DataExceptionType.NoInternet)
): NetworkException(e)
/**
 * Socket Timeout Exception.
 *
 * Client didn't receive response from server in timeout constraint
 * @author hubtwork ( Alen Heo )
 * */
data class RequestTimeoutException(
    val e: Throwable,
    override val result: DataException = DataException(type = DataExceptionType.TimeOut)
): NetworkException(e)
/**
 * Unknown Exception
 *
 * Not mapped exception occurred, so pass exception as cause.
 * @author hubtwork ( Alen Heo )
 * */
data class UnknownException(
    val e: Throwable?,
    override val result: DataException = DataException(type = DataExceptionType.Unknown(e))
): NetworkException(e)

