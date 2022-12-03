package com.hubtwork.clean_android.data.network.util

import com.hubtwork.clean_android.data.network.model.ResponseModel
import com.hubtwork.clean_android.data.network.model.toDomainSafe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.fail

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
class DomainMapper {
    data class TestDomain (val test: Boolean)
    data class TestData (val test: Boolean?): ResponseModel<TestDomain> {
        override val isValid: Boolean get() = test != null
        override fun toDomain(): TestDomain {
            if (test != null && test) throw NullPointerException()
            return TestDomain(test = test!!)
        }
    }

    @DisplayName("Map Response To Domain")
    @Test
    fun t1() {
        val data = TestData(test = false)
        try {
            data.toDomainSafe()
        } catch(e: Throwable) {
            fail { "It must not be failed" }
        }
    }
    @DisplayName("If fail to validate")
    @Test
    fun t2() {
        val data = TestData(test = null)
        try {
            data.toDomainSafe()
        } catch(e: Throwable) {
            if (e is InvalidResponseException) assert(true)
            else fail { "Other responses must not be occurred."}
        }
    }
    @DisplayName("If on parse, NullPointerException occurred")
    @Test
    fun t3() {
        val data = TestData(test = true)
        try {
            data.toDomainSafe()
        } catch(e: Throwable) {
            if (e is InvalidResponseException) assert(true)
            else fail { "`toDomainSafe` must map all exceptions to `InvalidResponseException`"}
        }
    }
}