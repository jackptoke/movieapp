package dev.agitek.movieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import dev.agitek.movieapp.ui.theme.MovieAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MainContent()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp(content: @Composable () -> Unit) {
    MovieAppTheme {
        Scaffold(topBar = {
                          TopAppBar(title = { Text(text = "AME Plus") }, modifier = Modifier.background(MaterialTheme.colorScheme.primary))
        }, modifier = Modifier.fillMaxSize()) {
            Surface(color = MaterialTheme.colorScheme.surface, modifier = Modifier.padding(it)) {
                MainContent()
            }
        }
    }
}

@Composable
fun MainContent(movieList: List<String> = listOf("Avatar", "300", "James Bond", "Harry Potter")) {
        Column(modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()){
            for (movie in movieList) {
                MovieRow(movie)
            }
        }
}

@Composable
fun MovieRow(movie: String) {
    Card(modifier = Modifier
        .padding(4.dp)
        .fillMaxWidth()
        .height(130.dp), shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = CardDefaults.cardElevation()
    ){
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start){
            Surface(modifier = Modifier.padding(12.dp)
                .size(100.dp),
                shape = RectangleShape,
                shadowElevation = 4.dp) {
                Icon(imageVector = Icons.Default.AccountBox, contentDescription="$movie image")

            }
            Text(movie)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MovieAppTheme {
        MyApp {
            MainContent()
        }
    }
}