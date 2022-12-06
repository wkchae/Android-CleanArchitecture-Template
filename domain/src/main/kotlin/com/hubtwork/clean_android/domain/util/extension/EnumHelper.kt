package com.hubtwork.clean_android.domain.util.extension

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
abstract class EnumHelper<T, V>(private val valueMap: Map<T, V>) {

    @Throws(IllegalArgumentException::class)
    infix fun from(value: T): V = valueMap[value] ?: throw IllegalArgumentException()
}