package com.hubtwork.clean_android.data.network.util

import com.hubtwork.clean_android.domain.util.io.DataException
import com.hubtwork.clean_android.domain.util.io.DataExceptionType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.fail
import java.io.IOException
import java.net.SocketTimeoutException

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
class HandleExceptionTest {

    inner class TestThrowable: Throwable("test")
    inner class TestNetworkException: NetworkException() {
        override val result: DataException
            get() = DataException(type = DataExceptionType.Unknown(ex = TestThrowable()))
    }

    @Test
    @DisplayName("In Nested try-catch")
    fun t1() {
        @Throws(IOException::class)
        fun proceed() {
            throw IOException().apply { initCause(TestThrowable()) }
        }
        @Throws(IOException::class, NetworkException::class)
        fun wrap() {
            try {
                proceed()
            } catch(e: IOException) {
                if (e.cause is TestThrowable) throw UnknownException(e.cause)
                else throw IOException().apply { initCause(e) }
            }
        }
        try {
            wrap()
        } catch(e : Throwable) {
            if (e is NetworkException) {
                assert(true)
            }
            else fail("it must not be reached")
        }
    }

    @Test
    @DisplayName("simulation for okhttp3..RealCall#run()")
    fun t2() {
        @Throws(IOException::class)
        fun proceed() {
            throw SocketTimeoutException()
        }
        @Throws(IOException::class)
        fun enqueue() {
            try {
                proceed()
            } catch(e: IOException) {
                throw RequestTimeoutException(e)
            } catch(e: Throwable) {
                fail { "it must not be reached!!!" }
            }
        }
        @Throws(IOException::class, NetworkException::class)
        fun realCall() {
            try {
                enqueue()
            } catch(e: IOException) {
                throw(e)
            }
        }
        try {
            realCall()
        } catch(e : Throwable) {
            if (e is NetworkException) assert(true)
            else fail("it must not be reached")
        }
    }

}