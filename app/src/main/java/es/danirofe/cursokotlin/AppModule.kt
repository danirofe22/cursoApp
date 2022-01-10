package es.danirofe.cursokotlin

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.danirofe.data.DataModule

@InstallIn(SingletonComponent::class)
@Module(includes = [DataModule::class])
class AppModule {

}