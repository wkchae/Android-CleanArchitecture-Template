package com.hubtwork.clean_android.data.storage.entity.mapper

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
interface EntityMapper<T, V> {
    fun toEntity(domain: T): V
    fun toDomain(entity: V): T
}