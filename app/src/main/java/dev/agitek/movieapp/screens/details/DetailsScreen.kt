package dev.agitek.movieapp.screens.details


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

import androidx.navigation.NavController
import dev.agitek.movieapp.navigation.MovieScreens


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(navController: NavController, movieId: String? = "") {

    Scaffold(topBar = {
        TopAppBar(title = { Text("Back", style = MaterialTheme.typography.headlineSmall ) },
            navigationIcon = { Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back arrow", modifier = Modifier
                .size(24.dp)
                .clickable { navController.navigate(MovieScreens.HomeScreen.name) }) },
            colors = TopAppBarDefaults.topAppBarColors(),
            scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior())
    },
        contentColor = Color.DarkGray,
        containerColor = Color.Transparent,
        modifier = Modifier.padding(16.dp)
        ) {
        Surface(modifier = Modifier
            .padding(it)
            .fillMaxWidth()
            .fillMaxHeight()) {
            Text(movieId.orEmpty(), style = MaterialTheme.typography.headlineLarge)
        }
    }
}

