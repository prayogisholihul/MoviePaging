package com.zogik.network.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.zogik.model.favorite.MovieFavoriteEntity

@Database(
    entities = [MovieFavoriteEntity::class],
    version = 1,
    exportSchema = false,
)
abstract class DatabaseApp : RoomDatabase() {
    abstract fun favoriteDao(): FavoriteDao
}
