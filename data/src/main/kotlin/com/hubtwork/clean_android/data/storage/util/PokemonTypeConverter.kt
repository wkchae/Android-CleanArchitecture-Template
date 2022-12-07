package com.hubtwork.clean_android.data.storage.util

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.fasterxml.jackson.core.type.TypeReference
import com.hubtwork.clean_android.domain.model.PokemonType
import javax.inject.Inject

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
@ProvidedTypeConverter
class PokemonTypeConverter @Inject constructor(
    private val parser: JSONParser
) {
    @TypeConverter
    fun toTypeEntity(data: List<PokemonType>): String {
        val transformed = data.map { it.name.lowercase() }
        return parser.stringify(transformed)
    }
    @TypeConverter
    fun fromTypeEntity(data: String): List<PokemonType> {
        val listType = object : TypeReference<List<String>>() { }
        return parser.parse(
            json = data,
            type = listType,
        ).map { PokemonType from it }
    }
}