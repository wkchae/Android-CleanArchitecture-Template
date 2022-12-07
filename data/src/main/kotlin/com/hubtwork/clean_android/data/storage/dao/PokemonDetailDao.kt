package com.hubtwork.clean_android.data.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hubtwork.clean_android.data.storage.entity.PokemonDetailEntity

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
@Dao
interface PokemonDetailDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: PokemonDetailEntity)

    @Query("select * from PokemonDetailEntity where name = :_name")
    suspend fun getByName(_name: String): PokemonDetailEntity?
}