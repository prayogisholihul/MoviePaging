package com.zogik.network.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.zogik.entity.MovieFavorite

@Database(
    entities = [MovieFavorite::class],
    version = 1,
    exportSchema = false,
)
abstract class DatabaseApp : RoomDatabase() {
    abstract fun favoriteDao(): FavoriteDao
}
