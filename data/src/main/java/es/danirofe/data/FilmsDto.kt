package es.danirofe.data

import com.google.gson.annotations.SerializedName

data class FilmsDto(
    @SerializedName("page")val page:Int,
    @SerializedName("results") val filmList: List<FilmDto>

)
