package es.danirofe.domain.model.repository

import javax.inject.Inject

class GetFilmUseCase @Inject constructor(
    private val repository: FilmRepository
) {
    fun run(): Film {
        return repository.getFilm()
    }
}