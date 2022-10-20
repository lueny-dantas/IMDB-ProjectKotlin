package model


data class Top250ResponseData(
    val items: List<MovieResponse>,
    val errorMessage: String
)

data class MovieResponse(
    val id: String,
    val rank: String,
    val title: String,
    val fullTitleval: String,
    val year: String,
    val image: String,
    val crew: String,
    val imDbRating: String,
    val imDbRatingCount: String
)

fun MovieResponse.toMovie(): Movie = Movie(
    title = this.title,
    image = this.image,
    rating = imDbRating.toDouble(),
    year = year.toInt()
)