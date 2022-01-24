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

        val filmDto = api.getFilm(id, language)
        val creditsDto = api.getCredits(id, language)

        val title = filmDto.title
        val director = creditsDto.role.firstOrNull { it.role=="Directing" }?.name?:""
        val image  ="https://image.tmdb.org/t/p/w500${filmDto.imageUrl}"
        val rating  = filmDto.rating
        val description = filmDto.description

        return Film(title ,image, rating, director, description)
    }

    suspend fun getFilms(language:String):List<Film>{

        val filmsDto = api.getFilms(language)
        return filmsDto.films.map {
            Film(it.title, "https://image.tmdb.org/t/p/w500${it.imageUrl}", it.rating, null, it.description )
        }

    }


}