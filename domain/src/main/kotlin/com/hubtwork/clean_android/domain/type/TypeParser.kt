package com.hubtwork.clean_android.domain.type

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
abstract class TypeParser <T>{
    protected abstract val typeId: String

    @Throws(IllegalArgumentException::class)
    open fun parse(data: String?): T {
        parseData(data)
            ?.let { return it }
            ?:run { throw IllegalArgumentException("$data is not applicable with $typeId") }
    }
    protected abstract fun parseData(data: String?): T?
}