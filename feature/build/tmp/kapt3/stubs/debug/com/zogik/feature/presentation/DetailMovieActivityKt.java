package com.zogik.feature.presentation;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u001a(\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u001a\b\u0010\r\u001a\u00020\u0001H\u0007\u001a\b\u0010\u000e\u001a\u00020\u0001H\u0007\u00a8\u0006\u000f"}, d2 = {"Content", "", "data", "Lcom/zogik/response/MovieDetail;", "padding", "Landroidx/compose/foundation/layout/PaddingValues;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "DetailScreen", "viewModel", "Lcom/zogik/feature/presentation/MainViewModel;", "movieId", "", "GreetingPreview3", "Loading", "feature_debug"})
public final class DetailMovieActivityKt {
    
    @androidx.compose.runtime.Composable
    public static final void DetailScreen(@org.jetbrains.annotations.NotNull
    com.zogik.feature.presentation.MainViewModel viewModel, @org.jetbrains.annotations.NotNull
    androidx.compose.foundation.layout.PaddingValues padding, @org.jetbrains.annotations.NotNull
    java.lang.String movieId, @org.jetbrains.annotations.NotNull
    androidx.lifecycle.Lifecycle lifecycle) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void Loading() {
    }
    
    @androidx.compose.runtime.Composable
    @kotlin.OptIn(markerClass = {com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi.class})
    public static final void Content(@org.jetbrains.annotations.NotNull
    com.zogik.response.MovieDetail data, @org.jetbrains.annotations.NotNull
    androidx.compose.foundation.layout.PaddingValues padding, @org.jetbrains.annotations.NotNull
    androidx.lifecycle.Lifecycle lifecycle) {
    }
    
    @androidx.compose.runtime.Composable
    @androidx.compose.ui.tooling.preview.Preview(showBackground = true)
    public static final void GreetingPreview3() {
    }
}