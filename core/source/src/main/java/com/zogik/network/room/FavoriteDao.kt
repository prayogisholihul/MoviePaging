package com.zogik.network.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.zogik.model.MovieFavorite
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {
    @Query("SELECT * FROM MovieFavorite")
    fun getFavorite(): Flow<List<com.zogik.model.MovieFavorite>>

    @Query("SELECT * FROM MovieFavorite WHERE id=:id")
    fun getFavoriteById(id: Int): com.zogik.model.MovieFavorite

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setFavorite(data: com.zogik.model.MovieFavorite)

    @Delete
    fun deleteFavorite(data: com.zogik.model.MovieFavorite)
}
