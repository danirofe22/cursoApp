package es.danirofe.data

import es.danirofe.domain.model.repository.Film
import es.danirofe.domain.model.repository.FilmRepository
import javax.inject.Inject
import javax.sql.DataSource

class FilmRepositoryImpl @Inject constructor(
    private val dataSource:HarcodedDataSource
    ): FilmRepository {
        override fun  getFilm(): Film{
            return dataSource.getFilm()
        }
    }
