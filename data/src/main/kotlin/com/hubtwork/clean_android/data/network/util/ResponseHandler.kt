package com.hubtwork.clean_android.data.network.util
//
//import com.hubtwork.clean_android.domain.util.io.DataResult
//import java.io.IOException
//
///**
// * @author hubtwork (alenheo)
// * @contacts hubtwork@gmail.com
// */
//suspend fun <Domain: Any> exceptionHandler (
//    handler: suspend () -> DataResult<Domain>
//): DataResult<Domain> {
//    return try {
//        handler()
//    } catch (ex: Throwable) {
//        ex.printStackTrace()
//        when(ex) {
//            is IOException -> {
//                when (val cause = ex.cause) {
//                    is DataException -> DataResult.Failure.Exception(cause = cause)
//                    else -> DataResult.Failure.Exception(cause = DataException.UnknownException(cause))
//                }
//            }
//            // Exception occurred during parse response,
//            // Response is successfully sent from server but some elements are wrong formats
//            is DataException.JSONParseException -> DataResult.Failure.Exception(cause = DataException.JSONParseException)
//            is HttpException -> ApiError(code = ERROR.parse(ex.code().toString()))
//            else -> ApiException(code = ApiExceptionCode.UNKNOWN)
//        }
//    }
//}
