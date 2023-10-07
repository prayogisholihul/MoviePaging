package com.zogik.feature.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.zogik.feature.presentation.ui.theme.MovieTheme
import com.zogik.feature.presentation.ui.theme.Purple80
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
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
                                title = { Text("Favorite") },
                                navigationIcon = { },
                                actions = {},
                            )
                        },
                        content = { innerPadding ->
                            FavoriteScreen(innerPadding) {
                                val intent = Intent(this, DetailMovieActivity::class.java)
                                intent.putExtra(DetailMovieActivity.MOVIE_ID, it)
                                startActivity(intent)
                            }
                        },
                    )
                }
            }
        }
    }
}

@Composable
fun FavoriteScreen(padding: PaddingValues, onlick: (String) -> Unit) {
    val viewModel = hiltViewModel<MainViewModel>()
    LazyColumn(contentPadding = padding) {
        items(viewModel.getFavorite()) {
            Text(
                modifier = Modifier
                    .height(75.dp).fillMaxWidth().clickable {
                        onlick.invoke(it.id.toString())
                    },
                color = Color.Black,
                text = it.title,
            )
            Divider()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    MovieTheme {}
}
