package webclient

import model.Movie
import model.Top250ResponseData
import model.toMovie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MovieWebClient {

    private val service = RetrofitInit().movieService

    fun findTop250Movies(onSuccess: (movies: List<Movie>) -> Unit) {
        service.findTop250Movies().enqueue(object : Callback<Top250ResponseData?> {
            override fun onResponse(
                call: Call<Top250ResponseData?>,
                response: Response<Top250ResponseData?>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let { data ->
                        val movies = data.items.map { detail ->
                            detail.toMovie()
                        }
                        onSuccess(movies)
                    }
                }
            }

            override fun onFailure(
                call: Call<Top250ResponseData?>,
                t: Throwable
            ) {

            }
        })
    }

}