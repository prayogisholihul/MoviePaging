package com.zogik.feature.home.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.zogik.designsystem.theme.MovieTheme
import com.zogik.designsystem.theme.Purple80
import com.zogik.network.Result
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {
    @Inject
    lateinit var navigation: HomeAction

    @OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
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
                                title = { Text("Home") },
                                navigationIcon = { },
                                actions = {
//                                    Icon(
//                                        Icons.Filled.Favorite,
//                                        contentDescription = "Favorite",
//                                        modifier = Modifier.clickable {
//                                            navigation.navigateToFavorite(this@HomeActivity)
//                                        },
//                                    )
                                },
                            )
                        },
                        floatingActionButtonPosition = FabPosition.End,
                        floatingActionButton = {
                            ExtendedFloatingActionButton(
                                onClick = {
                                    navigation.navigateToSearch(this)
                                },
                            ) {
                                Icon(Icons.Filled.Search, contentDescription = "Search")
                            }
                        },
                        content = { innerPadding ->
                            HomeScreen(
                                modifier = Modifier.consumeWindowInsets(innerPadding),
                                innerPadding,
                            ) { id, name ->
                                navigation.navigateToDetail(this, id, name)
                            }
                        },
                    )
                }
            }
        }
    }
}

@Composable
fun HomeScreen(modifier: Modifier, padding: PaddingValues, onlick: (String, String) -> Unit) {
    val viewModel = hiltViewModel<HomeViewModel>()
    val itemList = viewModel.getMovieList().collectAsLazyPagingItems()
    val genreList = viewModel.genreList.collectAsState(Result.Loading).value

    Column(Modifier.padding(padding)) {
        when (genreList) {
            is Result.Loading -> CircularProgressIndicator(color = Color.Black)
            is Result.Success -> {
                LazyRow {
                    items(items = genreList.data) {
                        Box(
                            Modifier.height(50.dp)
                                .wrapContentHeight(align = Alignment.CenterVertically)
                                .wrapContentWidth().padding(horizontal = 6.dp)
                                .background(
                                    color = if (it.isSelected) MaterialTheme.colorScheme.primary else Color.White,
                                    shape = RoundedCornerShape(12.dp),
                                )
                                .border(
                                    width = 1.dp,
                                    color = Color.Black,
                                    shape = RoundedCornerShape(12.dp),
                                )
                                .clickable {
                                    viewModel.setGenre(genreList.data, it)
                                },
                        ) {
                            Text(
                                modifier = Modifier.padding(8.dp),
                                color = if (it.isSelected) Color.White else Color.Black,
                                text = it.name,
                            )
                        }
                    }
                }
            }

            is Result.Error -> {}
            is Result.Idle -> {}
        }

        LazyColumn(modifier = Modifier.padding(top = 12.dp)) {
            items(items = itemList) { item ->
                Text(
                    modifier = Modifier
                        .height(75.dp).fillMaxWidth().clickable {
                            onlick.invoke(item?.id.toString(), item?.title.orEmpty())
                        },
                    color = Color.Black,
                    text = item?.title.orEmpty(),
                )
                Divider()
            }

            when (val state = itemList.loadState.refresh) { // FIRST LOAD
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

            when (val state = itemList.loadState.append) { // Pagination
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
fun GreetingPreview() {
    MovieTheme {}
}
