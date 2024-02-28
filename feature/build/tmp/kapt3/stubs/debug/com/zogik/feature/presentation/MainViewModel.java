package com.zogik.feature.presentation;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000bJ\u000e\u0010\u0012\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0019J\u0006\u0010!\u001a\u00020\u001fJ\u000e\u0010\"\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020#J\u0012\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\'0&0%J\u0012\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0&0%J\u000e\u0010*\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000bJ\u000e\u0010+\u001a\u00020\u001d2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010,\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u0019R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R*\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\r2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\r@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2 = {"Lcom/zogik/feature/presentation/MainViewModel;", "Landroidx/lifecycle/ViewModel;", "useCase", "Lcom/zogik/feature/domain/UseCase;", "(Lcom/zogik/feature/domain/UseCase;)V", "_getDetail", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/zogik/network/Result;", "Lcom/zogik/response/MovieDetail;", "_listFavorite", "", "Lcom/zogik/entity/MovieFavorite;", "favoriteDataPass", "Landroidx/compose/runtime/MutableState;", "getFavoriteDataPass", "()Landroidx/compose/runtime/MutableState;", "genre", "Lcom/zogik/feature/data/Genre;", "getDetail", "Lkotlinx/coroutines/flow/StateFlow;", "getGetDetail", "()Lkotlinx/coroutines/flow/StateFlow;", "listFavorite", "getListFavorite", "<set-?>", "", "query", "getQuery", "deleteFavorite", "", "movieFavorite", "Lkotlinx/coroutines/Job;", "id", "getFavorite", "getFavoriteById", "", "getNowPlaying", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "Lcom/zogik/response/NowPlayingItem;", "searchMovie", "Lcom/zogik/response/SearchItem;", "setFavorite", "setGenre", "setQuery", "feature_debug"})
public final class MainViewModel extends androidx.lifecycle.ViewModel {
    private final com.zogik.feature.domain.UseCase useCase = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState<com.zogik.entity.MovieFavorite> favoriteDataPass = null;
    private androidx.compose.runtime.MutableState<com.zogik.feature.data.Genre> genre;
    @org.jetbrains.annotations.NotNull
    private androidx.compose.runtime.MutableState<java.lang.String> query;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.zogik.network.Result<com.zogik.response.MovieDetail>> _getDetail = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.zogik.network.Result<com.zogik.response.MovieDetail>> getDetail = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.zogik.entity.MovieFavorite>> _listFavorite = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.zogik.entity.MovieFavorite>> listFavorite = null;
    
    @javax.inject.Inject
    public MainViewModel(@org.jetbrains.annotations.NotNull
    com.zogik.feature.domain.UseCase useCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.MutableState<com.zogik.entity.MovieFavorite> getFavoriteDataPass() {
        return null;
    }
    
    public final void setGenre(@org.jetbrains.annotations.NotNull
    com.zogik.feature.data.Genre genre) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.zogik.response.NowPlayingItem>> getNowPlaying() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.MutableState<java.lang.String> getQuery() {
        return null;
    }
    
    public final void setQuery(@org.jetbrains.annotations.NotNull
    java.lang.String query) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.zogik.response.SearchItem>> searchMovie() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.zogik.network.Result<com.zogik.response.MovieDetail>> getGetDetail() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job getDetail(@org.jetbrains.annotations.NotNull
    java.lang.String id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.zogik.entity.MovieFavorite>> getListFavorite() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job getFavorite() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.zogik.entity.MovieFavorite getFavoriteById(int id) {
        return null;
    }
    
    public final void setFavorite(@org.jetbrains.annotations.NotNull
    com.zogik.entity.MovieFavorite movieFavorite) {
    }
    
    public final void deleteFavorite(@org.jetbrains.annotations.NotNull
    com.zogik.entity.MovieFavorite movieFavorite) {
    }
}