package es.danirofe.domain.model.repository

import javax.inject.Inject

class GetFilmUseCase @Inject constructor(
    private val repository: FilmRepository
) {
    suspend fun run(id:Int, language:String) = repository.getFilm(id, language)

}