package es.danirofe.data.server

import com.google.gson.annotations.SerializedName
import es.danirofe.data.server.FilmDto

data class FilmsDto(
    @SerializedName("page")val page:Int,
    @SerializedName("results") val filmList: List<FilmDto>

)
