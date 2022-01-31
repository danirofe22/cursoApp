package es.danirofe.data

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val API_KEY ="143fec07b303f0f06e266c4e16423064"
const val BASE_URL  = "https://api.themoviedb.org/3/"


interface FilmApiService {

    @GET("movie/{id}")
    suspend fun getFilm(@Path("id")filmId:Int,
                        @Query("language")lang:String,
                        @Query("api_key")apiKey:String= API_KEY):FilmDto

    @GET("movie/{id}/credits")
    suspend fun getCredits(@Path("id")filmId:Int,
                           @Query("language")lang:String,
                        @Query("api_key")apiKey:String= API_KEY):CreditsDto

    @GET("movie/popular")
    suspend fun getFilms(
                        @Query("language")lang:String,
                        @Query("api_key")apiKey:String= API_KEY):FilmsDto
/*
    @GET("movie/popular")
    suspend fun getFilms(
        @Query("language")lang:String,
        @Query("api_key")apiKey:String= API_KEY):FilmsDto

    @GET("movie/popular")
    suspend fun getFilms(
        @Query("language")lang:String,
        @Query("api_key")apiKey:String= API_KEY):FilmsDto

 */
}


