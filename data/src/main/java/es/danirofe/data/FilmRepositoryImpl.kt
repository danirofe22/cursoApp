package es.danirofe.data

import es.danirofe.domain.model.repository.Film
import es.danirofe.domain.model.repository.FilmRepository
import javax.inject.Inject
import javax.sql.DataSource

class FilmRepositoryImpl @Inject constructor(
    private val dataSource:ServerDataSource
    ): FilmRepository {
    override suspend fun getFilm(id: Int, language: String): Film? {
        return runCatching {
            dataSource.getFilm(id, language)
        }.getOrNull()
    }
}
