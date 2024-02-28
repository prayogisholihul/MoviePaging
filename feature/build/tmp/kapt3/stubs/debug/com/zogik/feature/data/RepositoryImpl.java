package com.zogik.feature.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0001 B\u0017\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u000e0\rH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001c\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J%\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\r2\u0006\u0010\u0011\u001a\u00020\u0017H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bJ\u001c\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u00140\r2\u0006\u0010\u001e\u001a\u00020\u0017H\u0016J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006!"}, d2 = {"Lcom/zogik/feature/data/RepositoryImpl;", "Lcom/zogik/feature/domain/Repository;", "Lcom/zogik/network/BaseCall;", "api", "Lcom/zogik/feature/data/ApiClient;", "local", "Lcom/zogik/network/room/DatabaseApp;", "(Lcom/zogik/feature/data/ApiClient;Lcom/zogik/network/room/DatabaseApp;)V", "deleteFavorite", "", "movieFavorite", "Lcom/zogik/entity/MovieFavorite;", "getFavorite", "Lkotlinx/coroutines/flow/Flow;", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFavoriteById", "id", "", "getNowPlaying", "Landroidx/paging/PagingData;", "Lcom/zogik/response/NowPlayingItem;", "genre", "", "movieDetail", "Lcom/zogik/network/Result;", "Lcom/zogik/response/MovieDetail;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchMovie", "Lcom/zogik/response/SearchItem;", "query", "setFavorite", "Companion", "feature_debug"})
public final class RepositoryImpl extends com.zogik.network.BaseCall implements com.zogik.feature.domain.Repository {
    private final com.zogik.feature.data.ApiClient api = null;
    private final com.zogik.network.room.DatabaseApp local = null;
    @org.jetbrains.annotations.NotNull
    public static final com.zogik.feature.data.RepositoryImpl.Companion Companion = null;
    private static final int PAGE_SIZE = 10;
    
    @javax.inject.Inject
    public RepositoryImpl(@org.jetbrains.annotations.NotNull
    com.zogik.feature.data.ApiClient api, @org.jetbrains.annotations.NotNull
    com.zogik.network.room.DatabaseApp local) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.zogik.response.NowPlayingItem>> getNowPlaying(@org.jetbrains.annotations.NotNull
    java.lang.String genre) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.zogik.response.SearchItem>> searchMovie(@org.jetbrains.annotations.NotNull
    java.lang.String query) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object movieDetail(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.zogik.network.Result<com.zogik.response.MovieDetail>>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object getFavorite(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<com.zogik.entity.MovieFavorite>>> continuation) {
        return null;
    }
    
    @java.lang.Override
    public void setFavorite(@org.jetbrains.annotations.NotNull
    com.zogik.entity.MovieFavorite movieFavorite) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.zogik.entity.MovieFavorite getFavoriteById(int id) {
        return null;
    }
    
    @java.lang.Override
    public void deleteFavorite(@org.jetbrains.annotations.NotNull
    com.zogik.entity.MovieFavorite movieFavorite) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/zogik/feature/data/RepositoryImpl$Companion;", "", "()V", "PAGE_SIZE", "", "feature_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}