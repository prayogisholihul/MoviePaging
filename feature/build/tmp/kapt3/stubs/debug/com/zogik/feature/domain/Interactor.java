package com.zogik.feature.domain;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000b0\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001c\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J%\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\n2\u0006\u0010\u000e\u001a\u00020\u0014H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018J\u001c\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00110\n2\u0006\u0010\u001b\u001a\u00020\u0014H\u0016J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/zogik/feature/domain/Interactor;", "Lcom/zogik/feature/domain/UseCase;", "repo", "Lcom/zogik/feature/domain/Repository;", "(Lcom/zogik/feature/domain/Repository;)V", "deleteFavorite", "", "movieFavorite", "Lcom/zogik/entity/MovieFavorite;", "getFavorite", "Lkotlinx/coroutines/flow/Flow;", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFavoriteById", "id", "", "getNowPlaying", "Landroidx/paging/PagingData;", "Lcom/zogik/response/NowPlayingItem;", "genre", "", "movieDetail", "Lcom/zogik/network/Result;", "Lcom/zogik/response/MovieDetail;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchMovie", "Lcom/zogik/response/SearchItem;", "query", "setFavorite", "feature_debug"})
public final class Interactor implements com.zogik.feature.domain.UseCase {
    private final com.zogik.feature.domain.Repository repo = null;
    
    @javax.inject.Inject
    public Interactor(@org.jetbrains.annotations.NotNull
    com.zogik.feature.domain.Repository repo) {
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
}