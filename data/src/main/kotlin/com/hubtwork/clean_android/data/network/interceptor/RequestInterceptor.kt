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
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        try {
            return chain.proceed(request)
        } catch (e: Throwable) {
            throw when (e) {
                is UnknownHostException -> NotConnectedException(e)
                is SocketTimeoutException -> RequestTimeoutException(e)
                else -> UnknownException(e)
            }
        }
    }
}