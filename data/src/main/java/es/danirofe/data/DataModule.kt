package es.danirofe.data

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.danirofe.data.database.RoomModule
import es.danirofe.domain.model.repository.FilmRepository


@InstallIn(SingletonComponent::class)
@Module(includes = [RoomModule::class])
abstract class DataModule {
    @Binds
    abstract fun bindFilmRepository(impl: FilmRepositoryImpl): FilmRepository
}
