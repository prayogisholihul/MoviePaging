package com.zogik.network.room

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): DatabaseApp =
        Room.databaseBuilder(appContext, DatabaseApp::class.java, "Movie.db")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
}
