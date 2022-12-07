package com.hubtwork.clean_android.data.storage.util

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import javax.inject.Inject

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
interface JSONParser {
    fun <T> parse(json: String, type: Class<T>): T
    fun <T> parse(json: String, type: TypeReference<T>): T
    fun <T> stringify(data: T): String
}
class JacksonParser @Inject constructor(
    private val mapper: ObjectMapper
): JSONParser {
    override fun <T> parse(json: String, type: Class<T>): T {
        return mapper.readValue(json, type)
    }

    override fun <T> parse(json: String, type: TypeReference<T>): T {
        return mapper.readValue(json, type)
    }

    override fun <T> stringify(data: T): String {
        return mapper.writeValueAsString(data)
    }
}