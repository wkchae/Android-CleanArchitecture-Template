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
//        catch (e: UnknownHostException) {
//            /** If agent can't connect to internet, host will be not found */
//            throw IOException().apply { initCause(NotConnectedException(e)) }
//        } catch (e: SocketTimeoutException) {
//            /** If agent can't get response in timeout constraint, socket timeout exception will be occurred */
//            throw IOException().apply { initCause(RequestTimeoutException(e)) }
//        } catch (e: Exception) {
//            /** Not yet specified exception occurred */
//            throw IOException().apply { initCause(UnknownException(e)) }
//        }
    }
}