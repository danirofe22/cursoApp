package es.danirofe.data.server

import com.google.gson.annotations.SerializedName

data class FilmDto(
    @SerializedName("id") val id:Int,
    @SerializedName("title") val title:String,
    @SerializedName("overview") val description: String,
    @SerializedName("vote_average") val rating: Float,
    @SerializedName("poster_path") val imageUrl:String
)
