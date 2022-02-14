package es.danirofe.data.database

import es.danirofe.domain.model.repository.Film
import javax.inject.Inject

class DataBaseDataSource @Inject constructor(
    private val database: AppDatabase
) {

    suspend fun getFilms(): List<Film>{
        return database.filmDao().getFilms().map{ it.toDomain()}
    }

    suspend fun getFilm(id:Int): Film?{
        return database.filmDao().getFilm(id)?.toDomain()
    }

    suspend fun updateFilms(films :List<Film>){
        database.filmDao().insertAll(films.map{
            it.toEntity()
        })
    }
    suspend fun clearfilms(){
        database.filmDao().deleteAll()
    }

    private fun FilmEntity.toDomain(): Film = Film(
        title,
        imageUrl?:"",
        rating,
        director,
        description,
        id,
        video
    )

    private fun Film.toEntity(): FilmEntity = FilmEntity(
        id,
        title,
        url,
        nameDir,
        description,
        rating,
        videoId?:""

    )

}