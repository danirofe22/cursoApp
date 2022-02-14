package es.danirofe.data

import es.danirofe.data.database.DataBaseDataSource
import es.danirofe.data.server.ServerDataSource
import es.danirofe.domain.model.repository.Film
import es.danirofe.domain.model.repository.FilmRepository
import java.lang.Exception
import javax.inject.Inject


class FilmRepositoryImpl @Inject constructor(
    private val serverDataSource: ServerDataSource,
    private val dataBaseDataSource: DataBaseDataSource
    ): FilmRepository {

    override suspend fun getFilm(id: Int, language: String): Film? {
        return  try {
            val filmFormServer = serverDataSource.getFilm(id, language)
            dataBaseDataSource.clearfilms()
            dataBaseDataSource.updateFilms(listOf(filmFormServer))
            filmFormServer
        }catch (ex: Exception){
            dataBaseDataSource.getFilm(id)
        }
    }

    override suspend fun getFilms(language: String): List<Film>? {
        return try {
            val filmsFromServer = serverDataSource.getFilms(language)
            dataBaseDataSource.clearfilms()
            dataBaseDataSource.updateFilms(filmsFromServer)
            filmsFromServer
        }catch (ex: Exception){
            dataBaseDataSource.getFilms()
        }
    }


}
