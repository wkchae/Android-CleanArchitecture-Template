package com.hubtwork.clean_android.data.network.interceptor

import com.hubtwork.clean_android.domain.util.io.DataException
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
        try {
            return chain.proceed(chain.request())
        } catch (e: UnknownHostException) {
            /** If agent can't connect to internet, host will be not found */
            throw IOException().apply { initCause(DataException.NoNetworkConnectionException) }
        } catch (e: SocketTimeoutException) {
            /** If agent can't get response in timeout constraint, socket timeout exception will be occurred */
            throw IOException().apply { initCause(DataException.RequestTimeOutException) }
        } catch (e: Throwable) {
            /** Not yet specified exception occurred */
            throw IOException().apply { initCause(DataException.UnknownException(cause = e)) }
        }
    }
}