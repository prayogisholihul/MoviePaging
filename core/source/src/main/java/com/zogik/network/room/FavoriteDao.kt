package com.zogik.network.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.zogik.entity.MovieFavorite
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {
    @Query("SELECT * FROM MovieFavorite")
    fun getFavorite(): Flow<List<MovieFavorite>>

    @Query("SELECT * FROM MovieFavorite WHERE id=:id")
    fun getFavoriteById(id: Int): MovieFavorite

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setFavorite(data: MovieFavorite)

    @Delete
    fun deleteFavorite(data: MovieFavorite)
}
