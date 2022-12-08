package com.hubtwork.clean_android.data.storage.entity.mapper

import com.hubtwork.clean_android.data.storage.entity.PokemonDetailEntity
import com.hubtwork.clean_android.domain.model.PokemonDetail

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
object PokemonDetailMapper: EntityMapper<PokemonDetail, PokemonDetailEntity> {
    override fun toEntity(domain: PokemonDetail): PokemonDetailEntity {
        return PokemonDetailEntity(
            id = domain.id,
            name = domain.name,
            experience = domain.experience,
            height = domain.height,
            weight = domain.weight,
            stats = domain.stats,
            types = domain.types,
        )
    }

    override fun toDomain(entity: PokemonDetailEntity): PokemonDetail {
        return PokemonDetail(
            id = entity.id,
            name = entity.name,
            experience = entity.experience,
            height = entity.height,
            weight = entity.weight,
            stats = entity.stats,
            types = entity.types,
        )
    }
}
fun PokemonDetail.toEntity(): PokemonDetailEntity {
    return PokemonDetailMapper.toEntity(this)
}
fun PokemonDetailEntity.toDomain(): PokemonDetail {
    return PokemonDetailMapper.toDomain(this)
}