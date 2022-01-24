package es.danirofe.domain.model.repository

import javax.inject.Inject

class GetFilmsUseCase  @Inject constructor(
    private val repository: FilmRepository
) {
    suspend fun run(language:String) = repository.getFilms(language)

}