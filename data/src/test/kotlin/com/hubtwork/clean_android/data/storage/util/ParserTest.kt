package com.hubtwork.clean_android.data.storage.util

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.fail

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ParserTest {
    private lateinit var mapper: ObjectMapper

    @BeforeAll
    fun setup() {
        mapper = jacksonObjectMapper()
    }

    @Test
    @DisplayName("List to JsonString")
    fun t1() {
        // test list mapper
        try{
            val stringList = listOf("a", "b", "c", "d", "e")
            val jsonString = mapper.writeValueAsString(stringList)
            assertThat(jsonString).isInstanceOf(String::class.java)
            assertThat(jsonString).isEqualTo(
                """
                    ["a","b","c","d","e"]
                """.trimIndent()
            )
        } catch(e: Throwable) {
            fail { "exception must not be occurred." }
        }
    }

    @Test
    @DisplayName("JsonString to List")
    fun t2() {
        try {
            val jsonString =
                """
                    ["a","b","c","d","e"]
                """.trimIndent()
            val stringList = mapper.readValue(jsonString, object: TypeReference<List<String>>() {})
            assertThat(stringList).hasOnlyElementsOfType(String::class.java)
            assertThat(stringList.getOrNull(3)).isEqualTo("d")
        } catch(e: Throwable) {
            fail { "exception must not be occurred." }
        }
    }

}