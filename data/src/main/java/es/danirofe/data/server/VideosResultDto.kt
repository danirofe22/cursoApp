package es.danirofe.data.server

import com.google.gson.annotations.SerializedName
import es.danirofe.data.server.VideosDto

data class VideosResultDto(
    @SerializedName("id")val id:Int,
    @SerializedName("results") val VideosList: List<VideosDto>
)
