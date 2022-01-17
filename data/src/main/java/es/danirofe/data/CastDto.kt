package es.danirofe.data

import com.google.gson.annotations.SerializedName

data class CastDto(
    @SerializedName("known_for_department") val role: String,
    @SerializedName("name") val name: String
)
