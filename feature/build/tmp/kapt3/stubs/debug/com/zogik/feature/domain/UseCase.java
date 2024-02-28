package com.zogik.feature.domain;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001d\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\b0\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH&J\u001c\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u00072\u0006\u0010\u0010\u001a\u00020\u0011H&J%\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00072\u0006\u0010\u000b\u001a\u00020\u0011H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J\u001c\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u000e0\u00072\u0006\u0010\u0018\u001a\u00020\u0011H&J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001a"}, d2 = {"Lcom/zogik/feature/domain/UseCase;", "", "deleteFavorite", "", "movieFavorite", "Lcom/zogik/entity/MovieFavorite;", "getFavorite", "Lkotlinx/coroutines/flow/Flow;", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFavoriteById", "id", "", "getNowPlaying", "Landroidx/paging/PagingData;", "Lcom/zogik/response/NowPlayingItem;", "genre", "", "movieDetail", "Lcom/zogik/network/Result;", "Lcom/zogik/response/MovieDetail;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchMovie", "Lcom/zogik/response/SearchItem;", "query", "setFavorite", "feature_debug"})
public abstract interface UseCase {
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.zogik.response.NowPlayingItem>> getNowPlaying(@org.jetbrains.annotations.NotNull
    java.lang.String genre);
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.zogik.response.SearchItem>> searchMovie(@org.jetbrains.annotations.NotNull
    java.lang.String query);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object movieDetail(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.zogik.network.Result<com.zogik.response.MovieDetail>>> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getFavorite(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<com.zogik.entity.MovieFavorite>>> continuation);
    
    public abstract void setFavorite(@org.jetbrains.annotations.NotNull
    com.zogik.entity.MovieFavorite movieFavorite);
    
    @org.jetbrains.annotations.NotNull
    public abstract com.zogik.entity.MovieFavorite getFavoriteById(int id);
    
    public abstract void deleteFavorite(@org.jetbrains.annotations.NotNull
    com.zogik.entity.MovieFavorite movieFavorite);
}