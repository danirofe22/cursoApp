package es.danirofe.data

import es.danirofe.domain.model.repository.Film
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class ServerDataSource @Inject constructor() {
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val api:FilmApiService = retrofit.create(FilmApiService::class.java)

    suspend fun getFilm(id: Int, language:String): Film {
        val filmDto = api.getFilm()
    }
}