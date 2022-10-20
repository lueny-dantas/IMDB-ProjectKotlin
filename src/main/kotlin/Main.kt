import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import app.App
import model.Movie
import webclient.MovieWebClient
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

fun main() = application {
    val client = MovieWebClient()
    var movies: List<Movie> by remember {
        mutableStateOf(emptyList())
    }


    client.findTop250Movies(onSuccess = { moviesFromApi ->
        movies = moviesFromApi
    })

    Window(
        onCloseRequest = ::exitApplication,
        title = "IMDB"
    ) {
        App(movies)
    }


}







