package com.hubtwork.clean_android.domain.util.io

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
sealed class DataException: Exception {
    constructor(): super()
    constructor(msg: String): super(msg)
    constructor(msg: String, cause: Throwable): super(msg, cause)
    constructor(cause: Throwable): super(cause)

    class NoInternet: DataException()
    class TimeOut: DataException()
    class JSONParse: DataException()

    class Unknown(cause: Throwable): DataException(msg = "Not specified exception occurred. Check cause of it", cause = cause)
}