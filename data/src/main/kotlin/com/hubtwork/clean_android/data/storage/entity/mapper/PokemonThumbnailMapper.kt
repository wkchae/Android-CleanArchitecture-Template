package com.hubtwork.clean_android.data.storage.entity.mapper

import com.hubtwork.clean_android.data.storage.entity.PokemonThumbnailEntity
import com.hubtwork.clean_android.domain.model.PokemonThumbnail

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
object PokemonThumbnailMapper: EntityMapper<PokemonThumbnail, PokemonThumbnailEntity> {
    override fun toEntity(domain: PokemonThumbnail): PokemonThumbnailEntity {
        return PokemonThumbnailEntity(
            name = domain.name,
            imageUrl = domain.image,
            groupId = domain.groupId,
        )
    }

    override fun toDomain(entity: PokemonThumbnailEntity): PokemonThumbnail {
        return PokemonThumbnail(
            name = entity.name,
            image = entity.imageUrl
        ).apply { markGroup(entity.groupId) }
    }
}
fun List<PokemonThumbnail>.toEntity(): List<PokemonThumbnailEntity> {
    return map { PokemonThumbnailMapper.toEntity(it) }
}
fun List<PokemonThumbnailEntity>.toDomain(): List<PokemonThumbnail> {
    return map { PokemonThumbnailMapper.toDomain(it) }
}