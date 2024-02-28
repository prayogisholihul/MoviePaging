package com.zogik.feature.search.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchActivity : ComponentActivity() {
    @OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            com.zogik.designsystem.theme.MovieTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                colors = TopAppBarDefaults.largeTopAppBarColors(com.zogik.designsystem.theme.Purple80),
                                title = { Text("Search") },
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
                                actions = {},
                            )
                        },
                        content = { innerPadding ->
                            SearchScreen(
                                modifier = Modifier.consumeWindowInsets(innerPadding)
                                    .padding(innerPadding),
                            ) {
//                                val intent = Intent(this, DetailMovieActivity::class.java)
//                                intent.putExtra(DetailMovieActivity.MOVIE_ID, it)
//                                startActivity(intent)
                            }
                        },
                    )
                }
            }
        }
    }
}

@Composable
fun SearchScreen(modifier: Modifier = Modifier, onlick: (String) -> Unit) {
    val viewModel = hiltViewModel<SearchViewModel>()
    val searchList = viewModel.searchMovie().collectAsLazyPagingItems()

    Column {
        Search(modifier, viewModel)

        LazyColumn(modifier) {
            items(
                items = searchList,
                key = { it.id ?: 0 },
            ) { item ->
                Text(
                    modifier = Modifier
                        .height(75.dp).fillMaxWidth().clickable {
                            onlick.invoke(item?.id.toString())
                        },
                    color = Color.Black,
                    text = item?.title.orEmpty(),
                )
                Divider()
            }

            when (val state = searchList.loadState.refresh) { // FIRST LOAD
                is LoadState.Error -> {
                    // state.error to get error message
                }

                is LoadState.Loading -> { // Loading UI
                    item {
                        Column(
                            modifier = Modifier
                                .fillParentMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                        ) {
                            Text(
                                modifier = Modifier
                                    .padding(8.dp),
                                text = "Refresh Loading",
                            )

                            CircularProgressIndicator(color = Color.Black)
                        }
                    }
                }

                else -> {}
            }

            when (searchList.loadState.append) { // Pagination
                is LoadState.Error -> {
                    // state.error to get error message
                }

                is LoadState.Loading -> { // Pagination Loading UI
                    item {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                        ) {
                            Text(text = "Pagination Loading")

                            CircularProgressIndicator(color = Color.Black)
                        }
                    }
                }

                else -> {}
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    com.zogik.designsystem.theme.MovieTheme {}
}
