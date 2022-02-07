package es.danirofe.data

import com.google.gson.annotations.SerializedName

data class VideosResultDto(
    @SerializedName("id")val id:Int,
    @SerializedName("results") val VideosList: List<VideosDto>
)
