package dev.agitek.movieapp.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import dev.agitek.movieapp.models.Movie
import dev.agitek.movieapp.models.getMovies
import dev.agitek.movieapp.navigation.MovieScreens
import dev.agitek.movieapp.widgets.MovieRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "AME Plus") }, modifier = Modifier.background(MaterialTheme.colorScheme.primary))
    }, modifier = Modifier.fillMaxSize()) {
        Surface(color = MaterialTheme.colorScheme.surface, modifier = Modifier.padding(it)) {
            MainContent(navController)
        }
    }
}

@Composable
fun MainContent(navController: NavController, movieList: List<Movie> = getMovies()) {
    Column(modifier = Modifier
        .padding(5.dp)
        .fillMaxWidth()){
        LazyColumn {
            items(items = movieList) {
                MovieRow(movie = it) { movie ->
                    navController.navigate(route = MovieScreens.DetailsScreen.name + "/${movie.id}")
                }
            }
        }

    }
}
