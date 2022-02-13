package es.danirofe.data.database

import androidx.room.*

@Dao
interface FilmDao {
    @Query("SELECT * from FilmEntity")
    suspend fun getFilms(): List<FilmEntity>


    @Query("SELECT * from FilmEntity WHERE id LIKE :filmId")
    suspend fun getFilm(filmId: Int): FilmEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(films: List<FilmEntity>)

    @Delete
    suspend fun deleteFilm(Film: FilmEntity)

    @Query("DELETE from FilmEntity")
    suspend fun deleteAll()

}