package com.hubtwork.clean_android.data.network.interceptor

import com.hubtwork.clean_android.data.network.util.NetworkException
import com.hubtwork.clean_android.data.network.util.NotConnectedException
import com.hubtwork.clean_android.data.network.util.RequestTimeoutException
import com.hubtwork.clean_android.data.network.util.UnknownException
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
class RequestInterceptor: Interceptor {
    @Throws(NetworkException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        try {
            return chain.proceed(chain.request())
        } catch (e: IOException) {
            throw when(val cause = e.cause) {
                is UnknownHostException -> NotConnectedException(cause)
                is SocketTimeoutException -> RequestTimeoutException(cause)
                else -> UnknownException(cause)
            }
        }
    }
}