package com.hubtwork.clean_android.domain.util.io

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
sealed class DataException: Exception {
    constructor(): super()
    constructor(msg: String): super(msg)
    constructor(msg: String, cause: Throwable?): super(msg, cause)
    constructor(cause: Throwable?): super(cause)
    // implementations
    object NoNetworkConnectionException: DataException()
    object RequestTimeOutException: DataException()
    object JSONParseException: DataException()
    class UnknownException(cause: Throwable?): DataException(msg = "Not specified exception occurred. Check cause of it", cause = cause)
}