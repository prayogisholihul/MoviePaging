package com.zogik.network.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.zogik.entity.MovieFavorite

@Dao
interface FavoriteDao {
    @Query("SELECT * FROM MovieFavorite")
    fun getFavorite(): List<MovieFavorite>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setFavorite(data: MovieFavorite)

    @Delete
    fun deleteFavorite(data: MovieFavorite)
}
