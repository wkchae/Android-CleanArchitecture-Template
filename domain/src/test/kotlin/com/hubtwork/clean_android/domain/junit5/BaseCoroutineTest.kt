package com.hubtwork.clean_android.domain.junit5

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
@OptIn(ExperimentalCoroutinesApi::class)
@DisplayName("Basic Coroutine Test")
class BaseCoroutineTest {

    @Nested
    @DisplayName("runTest")
    inner class BaseRunTest {
        @Test
        @DisplayName("success")
        fun success() = runTest {
            var num = 4
            suspend fun sync() {
                num = 1
                println(num)
                delay(100L)
                num = 2
                println(num)
                delay(100L)
                num = 3
                println(num)
                delay(100L)
                num = 5
                println(num)
            }
            launch { sync() }
            // move virtual time forward given millisecond
            advanceTimeBy(350)
            assert(num == 5)

        }
    }

    @Nested
    @DisplayName("UnconfinedDispatcher")
    inner class UnconfinedDispatcherTest {
        @Test
        @DisplayName("success")
        fun success() = runTest(UnconfinedTestDispatcher()) {
            assert(true)
        }
    }


}