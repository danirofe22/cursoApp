package es.danirofe.data

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import es.danirofe.domain.model.repository.FilmRepository

@Module
@InstallIn(ActivityComponent::class)
abstract class DataModule {
    @Binds
    abstract fun bindFilmRepository(impl: FilmRepositoryImpl): FilmRepository
}
