package es.danirofe.data.server

import com.google.gson.annotations.SerializedName

data class VideosDto(
    @SerializedName("type")val type:String,
    @SerializedName("key")val key:String,
    @SerializedName("site") val site: String
)
