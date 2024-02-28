package com.zogik.feature.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J%\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0001\u0010\f\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ%\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\u0010\u001a\u00020\u00072\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/zogik/feature/data/ApiClient;", "", "getNowPlaying", "Lcom/zogik/response/NowPlaying;", "page", "", "genre", "", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "movieDetail", "Lretrofit2/Response;", "Lcom/zogik/response/MovieDetail;", "id", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchMovie", "Lcom/zogik/response/SearchMovie;", "search", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "feature_debug"})
public abstract interface ApiClient {
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.GET(value = "discover/movie")
    public abstract java.lang.Object getNowPlaying(@retrofit2.http.Query(value = "page")
    int page, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "with_genres")
    java.lang.String genre, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.zogik.response.NowPlaying> continuation);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.GET(value = "search/movie")
    public abstract java.lang.Object searchMovie(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "query")
    java.lang.String search, @retrofit2.http.Query(value = "page")
    int page, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.zogik.response.SearchMovie> continuation);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.GET(value = "movie/{movie_id}")
    public abstract java.lang.Object movieDetail(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Path(value = "movie_id")
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.zogik.response.MovieDetail>> continuation);
}