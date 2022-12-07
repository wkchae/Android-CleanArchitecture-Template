package com.hubtwork.clean_android.data.storage.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.hubtwork.clean_android.data.storage.dao.PokemonDetailDao
import com.hubtwork.clean_android.data.storage.dao.PokemonThumbnailDao
import com.hubtwork.clean_android.data.storage.entity.PokemonDetailEntity
import com.hubtwork.clean_android.data.storage.entity.PokemonThumbnailEntity
import com.hubtwork.clean_android.data.storage.util.PokemonTypeConverter

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */

@Database(
    entities = [PokemonThumbnailEntity::class, PokemonDetailEntity::class],
    version = 1,
    exportSchema = true,
)
@TypeConverters(value = [PokemonTypeConverter::class])
abstract class PokemonDatabase: RoomDatabase() {
    abstract fun thumbnailDao() : PokemonThumbnailDao
    abstract fun detailDao() : PokemonDetailDao

    companion object {
        fun build(
            applicationContext: Application,
            typeConverter: PokemonTypeConverter
        ): PokemonDatabase {
            return Room
                .databaseBuilder(applicationContext, PokemonDatabase::class.java, "Pokemon.db")
                .fallbackToDestructiveMigration()
                .addTypeConverter(typeConverter)
                .build()
        }
    }
}