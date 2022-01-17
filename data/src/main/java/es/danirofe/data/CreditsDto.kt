package es.danirofe.data
import com.google.gson.annotations.SerializedName

data class CreditsDto(
    @SerializedName("cast") val role: String
)
