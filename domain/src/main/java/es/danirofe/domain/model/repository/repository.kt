package es.danirofe.domain.model.repository

interface FilmRepository {
    suspend fun getFilm(id: Int, language: String): Film?
}