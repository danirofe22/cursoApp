package es.danirofe.data

import com.google.gson.annotations.SerializedName

data class FilmsDto(
    @SerializedName("page")val page:Int,
    @SerializedName("Films") val filmList: List<FilmDto>

)
