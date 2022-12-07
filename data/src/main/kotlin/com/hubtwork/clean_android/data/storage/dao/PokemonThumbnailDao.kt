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

    @Query("select * from PokemonThumbnailEntity where groupId = :_groupId")
    suspend fun getByGroupId(_groupId: String): List<PokemonThumbnailEntity>

    @Query("select * from PokemonThumbnailEntity where groupId <= :_groupId")
    suspend fun getAll(_groupId: String): List<PokemonThumbnailEntity>
}