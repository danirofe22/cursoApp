package es.danirofe.data.server

import com.google.gson.annotations.SerializedName

data class CastDto(
    @SerializedName("known_for_department") val role: String,
    @SerializedName("name") val name: String
)
