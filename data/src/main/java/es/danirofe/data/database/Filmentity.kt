package es.danirofe.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Filmentity(
    @PrimaryKey val id:Int,
    @ColumnInfo(name = "title") val title:String,
    @ColumnInfo(name = "imageUrl") val imageUrl:String,
    @ColumnInfo(name = "director") val director:String,
    @ColumnInfo(name = "description") val description:String,
    @ColumnInfo(name = "rating") val rating:String,
    @ColumnInfo(name = "video") val video:String,
    )
