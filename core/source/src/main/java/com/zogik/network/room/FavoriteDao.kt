package com.zogik.network.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.zogik.model.favorite.MovieFavoriteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {
    @Query("SELECT * FROM MovieFavoriteEntity")
    fun getFavorite(): Flow<List<MovieFavoriteEntity>>

    @Query("SELECT * FROM MovieFavoriteEntity WHERE id=:id")
    fun getFavoriteById(id: Int): MovieFavoriteEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setFavorite(data: MovieFavoriteEntity)

    @Delete
    fun deleteFavorite(data: MovieFavoriteEntity)
}
