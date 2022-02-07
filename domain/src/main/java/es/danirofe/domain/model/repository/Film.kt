package es.danirofe.domain.model.repository

data class Film (
    val title: String,
    val url:String,
    val rating: Float,
    val nameDir: String?,
    val description: String,
    val id: Int,
    val videoId: String?
)

