package es.danirofe.data.server

import es.danirofe.data.database.AppDatabase
import es.danirofe.data.database.FilmEntity
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
        val video = api.getVideos(id, language).VideosList.filter {
            it.site == "YouTube"
        }.firstOrNull{it.type=="Trailer"}?.key

        val title = filmDto.title
        val director = creditsDto.role.firstOrNull { it.role=="Directing" }?.name?:""
        val image  ="https://image.tmdb.org/t/p/w500${filmDto.imageUrl}"
        val rating  = filmDto.rating
        val description = filmDto.description
        val id = filmDto.id


        return Film(title ,image, rating, director, description,id, video)
    }

    suspend fun getFilms(language:String):List<Film>{

        return api.getFilms(language).filmList.map {
            Film(it.title, "https://image.tmdb.org/t/p/w500${it.imageUrl}", it.rating, null, it.description, it.id, null )

        }
    }



}
