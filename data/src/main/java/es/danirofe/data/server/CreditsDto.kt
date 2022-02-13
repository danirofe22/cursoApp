package es.danirofe.data.server
import com.google.gson.annotations.SerializedName
import es.danirofe.data.server.CastDto

data class CreditsDto(
    @SerializedName("cast") val role: List<CastDto>
)
