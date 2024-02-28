package com.zogik.feature.detailmovie.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidViewBinding
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.zogik.designsystem.theme.MovieTheme
import com.zogik.designsystem.theme.Purple80
import com.zogik.feature.detailmovie.databinding.YoutubeViewBinding
import com.zogik.model.detail.MovieReview
import com.zogik.network.Result
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers

@AndroidEntryPoint
class DetailMovieActivity : ComponentActivity() {
    companion object {
        const val MOVIE_ID = "movie_id"
        const val MOVIE_NAME = "movie_name"
    }

    @OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val movieId = intent.getStringExtra(MOVIE_ID)
        val movieTitle = intent.getStringExtra(MOVIE_NAME)

        setContent {
            val viewModel = hiltViewModel<DetailViewModel>()
            val favIcon: MutableState<ImageVector> =
                remember { mutableStateOf(Icons.Filled.FavoriteBorder) }
            viewModel.getDetail(movieId.orEmpty())

            MovieTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                colors = TopAppBarDefaults.largeTopAppBarColors(Purple80),
                                title = {
                                    Text(
                                        movieTitle.orEmpty(),
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis,
                                        modifier = Modifier.padding(end = 12.dp),
                                    )
                                },
                                navigationIcon = {
                                    Icon(
                                        modifier = Modifier.padding(end = 24.dp)
                                            .clickable {
                                                onBackPressedDispatcher.onBackPressed()
                                            },
                                        imageVector = Icons.Default.ArrowBack,
                                        contentDescription = "BACK",
                                        tint = Color.Black,
                                    )
                                },
                                actions = {
//                                    val favorite = movieId?.toInt()
//                                        ?.let { viewModel.getFavoriteById(it) }
//
//                                    if (favorite != null) {
//                                        favIcon.value = Icons.Filled.Favorite
//                                    }
//
//                                    Icon(
//                                        imageVector = favIcon.value,
//                                        contentDescription = "Favorite",
//                                        tint = if (favorite != null) {
//                                            Color.Red
//                                        } else {
//                                            Color.Black
//                                        },
//                                        modifier = Modifier.clickable {
//                                            if (favorite == null) {
//                                                viewModel.favoriteDataPass.value?.let {
//                                                    viewModel.setFavorite(it)
//                                                    favIcon.value = Icons.Filled.Favorite
//                                                }
//                                            } else {
//                                                viewModel.favoriteDataPass.value?.let {
//                                                    viewModel.deleteFavorite(it)
//                                                    favIcon.value = Icons.Filled.FavoriteBorder
//                                                }
//                                            }
//                                        },
//                                    )
                                },
                            )
                        },
                        content = { innerPadding ->
                            DetailScreen(
                                viewModel,
                                movieId.orEmpty(),
                                innerPadding,
                                lifecycle,
                            )
                        },
                    )
                }
            }
        }
    }
}

@Composable
fun DetailScreen(
    viewModel: DetailViewModel,
    movieId: String,
    padding: PaddingValues,
    lifecycle: Lifecycle,
) {
    val reviewItem = viewModel.getMovieReview(movieId).collectAsLazyPagingItems(Dispatchers.Main)
    Column(Modifier.padding(padding)) {
        when (val state = viewModel.getDetail.collectAsState().value) {
            Result.Idle -> {}
            Result.Loading -> CircularProgressIndicator(color = Color.Black)
            is Result.Success -> {
                YoutubeView(state.data.key.orEmpty(), lifecycle)
            }

            is Result.Error -> {
                Text("Video Error", Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
            }
        }

        Spacer(Modifier.height(12.dp))
        ReviewView(reviewItem)
    }
}

@Composable
fun Loading() {
    Column(
        modifier = Modifier
            .fillMaxWidth().fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(text = "Loading...")

        CircularProgressIndicator(color = Color.Black)
    }
}

@Composable
fun YoutubeView(urlId: String, lifecycle: Lifecycle) {
    val isError = mutableStateOf(false)
    AndroidViewBinding(YoutubeViewBinding::inflate) {
        this.youtubePlayerView.apply {
            lifecycle.addObserver(this)
            addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    super.onReady(youTubePlayer)
                    youTubePlayer.loadVideo(urlId, 0F)
                }

                override fun onError(
                    youTubePlayer: YouTubePlayer,
                    error: PlayerConstants.PlayerError,
                ) {
                    super.onError(youTubePlayer, error)
                    isError.value = true
                }
            })
        }
    }
    if (isError.value) Text("Video Error")
}

@Composable
fun ReviewView(reviewItem: LazyPagingItems<MovieReview>) {
    LazyColumn(modifier = Modifier.padding(top = 12.dp)) {
        items(items = reviewItem) { item ->
            Box(
                Modifier
                    .wrapContentHeight()
                    .wrapContentWidth().padding(start = 12.dp, end = 12.dp, bottom = 12.dp)
                    .background(
                        color = MaterialTheme.colorScheme.tertiaryContainer,
                        shape = RoundedCornerShape(12.dp),
                    ),
            ) {
                Column(Modifier.padding(8.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(text = item?.author.orEmpty())
                        StarRatingBar(rating = (item?.authorDetails?.rating ?: 0.0).toFloat())
                    }
                    Spacer(Modifier.height(6.dp))
                    Divider()
                    Spacer(Modifier.height(6.dp))
                    Text(text = item?.content.orEmpty())
                }
            }
        }

        when (val state = reviewItem.loadState.refresh) { // FIRST LOAD
            is LoadState.Error -> {
                item {
                    Column(
                        modifier = Modifier
                            .fillParentMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                    ) {
                        Text("Error Load")
                    }
                }
            }

            is LoadState.Loading -> { // Loading UI
                item {
                    Loading()
                }
            }

            is LoadState.NotLoading -> {
                if (reviewItem.itemSnapshotList.isEmpty()) {
                    item {
                        Column(
                            modifier = Modifier
                                .fillParentMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                        ) {
                            Text(
                                text = "No review available",
                            )
                        }
                    }
                }
            }
        }

        when (val state = reviewItem.loadState.append) { // Pagination
            is LoadState.Error -> {
                // state.error to get error message
            }

            is LoadState.Loading -> { // Pagination Loading UI
                item {
                    Loading()
                }
            }

            else -> {}
        }
    }
}

@Composable
fun StarRatingBar(
    maxStars: Int = 5,
    rating: Float,
) {
    val density = LocalDensity.current.density
    val starSize = (12f * density).dp
    val starSpacing = (0.3f * density).dp

    Row(
        modifier = Modifier.selectableGroup(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        for (i in 1..maxStars) {
            val isSelected = i <= rating
            val icon = if (isSelected) Icons.Filled.Star else Icons.Default.Star
            val iconTintColor = if (isSelected) Color(0xFFFFC700) else Color(0x20FFFFFF)
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = iconTintColor,
                modifier = Modifier
                    .width(starSize).height(starSize),
            )

            if (i < maxStars) {
                Spacer(modifier = Modifier.width(starSpacing))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    //    Content(MovieDetail())
}
