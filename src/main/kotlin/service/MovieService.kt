package service

import model.Top250ResponseData
import retrofit2.Call
import retrofit2.http.GET
import webclient.IMDB_API_KEY

interface MovieService {

    @GET("Top250Movies/$IMDB_API_KEY")
    fun findTop250Movies(): Call<Top250ResponseData>

}
