package com.hubtwork.clean_android.data.network

import com.hubtwork.clean_android.data.network.util.NetworkException
import com.hubtwork.clean_android.data.network.util.UnknownException
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.fail
import java.io.IOException

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
class Exceptions {

    inner class TestThrowable: Throwable("test")

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
                println("hi ${e.cause}")
                assert(true)
            }
            else fail("it can't be reached")
        }
    }
}