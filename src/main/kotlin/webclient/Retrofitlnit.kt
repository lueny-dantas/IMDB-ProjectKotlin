package webclient


import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import service.MovieService


class RetrofitInit {
    val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    var client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://imdb-api.com/API/")
        .client(client)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val movieService: MovieService
        get() = retrofit.create(MovieService::class.java)

}