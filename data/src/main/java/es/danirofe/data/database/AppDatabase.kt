package es.danirofe.data.database

import androidx.room.Database

@Database(entities = [FilmEntity::class], version = 1)
abstract class AppDatabase {
    abstract fun filmDao():FilmDao
}