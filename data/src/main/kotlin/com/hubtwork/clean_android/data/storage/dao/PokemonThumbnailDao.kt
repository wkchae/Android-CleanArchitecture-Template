package com.hubtwork.clean_android.data.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hubtwork.clean_android.data.storage.entity.PokemonThumbnailEntity

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
@Dao
interface PokemonThumbnailDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: List<PokemonThumbnailEntity>)

    @Query("select * from PokemonThumbnailEntity where groupId = :groupId_")
    suspend fun getByGroupId(groupId_: Int): List<PokemonThumbnailEntity>

    @Query("select * from PokemonThumbnailEntity where groupId <= :groupId_")
    suspend fun getAll(groupId_: Int): List<PokemonThumbnailEntity>
}