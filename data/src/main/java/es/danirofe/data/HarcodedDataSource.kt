package es.danirofe.data

import es.danirofe.domain.model.repository.Film
import javax.inject.Inject

class HarcodedDataSource @Inject constructor(){
    fun getFilm(): Film{
        return Film("Batman", "", 8.8f, "pepe" )

    }
}