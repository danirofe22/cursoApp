package es.danirofe.domain.model.repository

interface FilmRepository {
    fun getFilm(): Film{
        return Film("Batman", "", 8.8f, "pepe" )

    }
}