package com.zogik.feature.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidViewBinding
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.zogik.entity.MovieFavorite
import com.zogik.feature.databinding.YoutubeViewBinding
import com.zogik.feature.presentation.ui.theme.MovieTheme
import com.zogik.feature.presentation.ui.theme.Purple80
import com.zogik.network.Result
import com.zogik.model.MovieDetail
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailMovieActivity : ComponentActivity() {
    companion object {
        const val MOVIE_ID = "movie_id"
    }

    @OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val movieId = intent.getStringExtra(MOVIE_ID)

        setContent {
            val viewModel = hiltViewModel<MainViewModel>()
            val favIcon: MutableState<ImageVector> =
                remember { mutableStateOf(Icons.Filled.FavoriteBorder) }

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
                                title = { Text("Detail") },
                                navigationIcon = { },
                                actions = {
                                    val favorite = movieId?.toInt()
                                        ?.let { viewModel.getFavoriteById(it) }

                                    if (favorite != null) {
                                        favIcon.value = Icons.Filled.Favorite
                                    }

                                    Icon(
                                        imageVector = favIcon.value,
                                        contentDescription = "Favorite",
                                        tint = if (favorite != null) {
                                            Color.Red
                                        } else {
                                            Color.Black
                                        },
                                        modifier = Modifier.clickable {
                                            if (favorite == null) {
                                                viewModel.favoriteDataPass.value?.let {
                                                    viewModel.setFavorite(it)
                                                    favIcon.value = Icons.Filled.Favorite
                                                }
                                            } else {
                                                viewModel.favoriteDataPass.value?.let {
                                                    viewModel.deleteFavorite(it)
                                                    favIcon.value = Icons.Filled.FavoriteBorder
                                                }
                                            }
                                        },
                                    )
                                },
                            )
                        },
                        content = { innerPadding ->
                            DetailScreen(
                                viewModel,
                                innerPadding,
                                movieId.orEmpty(),
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
    viewModel: MainViewModel,
    padding: PaddingValues,
    movieId: String,
    lifecycle: Lifecycle,
) {
    viewModel.getDetail(movieId)

    when (val state = viewModel.getDetail.collectAsState().value) {
        is Result.Error -> {}
        is Result.Loading -> Loading()
        is Result.Success -> {
            viewModel.favoriteDataPass.value =
                MovieFavorite(state.data.id ?: 0, state.data.title.orEmpty())

            Content(state.data, padding, lifecycle)
        }

        else -> {}
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
fun Content(data: MovieDetail, padding: PaddingValues, lifecycle: Lifecycle) {
    Column(Modifier.verticalScroll(rememberScrollState()).padding(padding)) {
        AndroidViewBinding(YoutubeViewBinding::inflate) {
            this.youtubePlayerView.apply {
                lifecycle.addObserver(this)
                addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                    override fun onReady(youTubePlayer: YouTubePlayer) {
                        super.onReady(youTubePlayer)
                        youTubePlayer.loadVideo("otNh9bTjXWg", 0F)
                    }

                    override fun onError(
                        youTubePlayer: YouTubePlayer,
                        error: PlayerConstants.PlayerError,
                    ) {
                        super.onError(youTubePlayer, error)
                        Text("Video Error")
                    }
                })
            }
        }
        Spacer(Modifier.padding(top = 12.dp))
        Text(text = data.overview.orEmpty())
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
//    Content(MovieDetail())
}
