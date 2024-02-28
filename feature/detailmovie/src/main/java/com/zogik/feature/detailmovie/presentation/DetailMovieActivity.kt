package com.zogik.feature.detailmovie.presentation

// @AndroidEntryPoint
// class DetailMovieActivity : ComponentActivity() {
//    companion object {
//        const val MOVIE_ID = "movie_id"
//    }
//
//    @OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        val movieId = intent.getStringExtra(MOVIE_ID)
//
//        setContent {
//            val viewModel = hiltViewModel<MainViewModel>()
//            val favIcon: MutableState<ImageVector> =
//                remember { mutableStateOf(Icons.Filled.FavoriteBorder) }
//
//            com.zogik.designsystem.theme.MovieTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background,
//                ) {
//                    Scaffold(
//                        topBar = {
//                            TopAppBar(
//                                colors = TopAppBarDefaults.largeTopAppBarColors(com.zogik.designsystem.theme.Purple80),
//                                title = { Text("Detail") },
//                                navigationIcon = { },
//                                actions = {
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
//                                },
//                            )
//                        },
//                        content = { innerPadding ->
//                            DetailScreen(
//                                viewModel,
//                                innerPadding,
//                                movieId.orEmpty(),
//                                lifecycle,
//                            )
//                        },
//                    )
//                }
//            }
//        }
//    }
// }
//
// @Composable
// fun DetailScreen(
//    viewModel: MainViewModel,
//    padding: PaddingValues,
//    movieId: String,
//    lifecycle: Lifecycle,
// ) {
//    viewModel.getDetail(movieId)
//
//    when (val state = viewModel.getDetail.collectAsState().value) {
//        is Result.Error -> {}
//        is Result.Loading -> Loading()
//        is Result.Success -> {
//            viewModel.favoriteDataPass.value =
//                MovieFavorite(state.data.id ?: 0, state.data.title.orEmpty())
//
//            Content(state.data, padding, lifecycle)
//        }
//
//        else -> {}
//    }
// }
//
// @Composable
// fun Loading() {
//    Column(
//        modifier = Modifier
//            .fillMaxWidth().fillMaxHeight(),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center,
//    ) {
//        Text(text = "Loading...")
//
//        CircularProgressIndicator(color = Color.Black)
//    }
// }
//
// @Composable
// fun Content(data: MovieDetail, padding: PaddingValues, lifecycle: Lifecycle) {
//    Column(Modifier.verticalScroll(rememberScrollState()).padding(padding)) {
//        AndroidViewBinding(YoutubeViewBinding::inflate) {
//            this.youtubePlayerView.apply {
//                lifecycle.addObserver(this)
//                addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
//                    override fun onReady(youTubePlayer: YouTubePlayer) {
//                        super.onReady(youTubePlayer)
//                        youTubePlayer.loadVideo("otNh9bTjXWg", 0F)
//                    }
//
//                    override fun onError(
//                        youTubePlayer: YouTubePlayer,
//                        error: PlayerConstants.PlayerError,
//                    ) {
//                        super.onError(youTubePlayer, error)
//                        Text("Video Error")
//                    }
//                })
//            }
//        }
//        Spacer(Modifier.padding(top = 12.dp))
//        Text(text = data.overview.orEmpty())
//    }
// }
//
// @Preview(showBackground = true)
// @Composable
// fun GreetingPreview3() {
// //    Content(MovieDetail())
// }
