package es.danirofe.cursokotlin

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import es.danirofe.domain.model.repository.Film
import es.danirofe.domain.model.repository.GetFilmUseCase
import javax.inject.Inject

@HiltViewModel
class MainViewModel@Inject constructor(
    private val useCase: GetFilmUseCase
): ViewModel(), LifecycleObserver{

    private val filmLiveData = MutableLiveData<Film>()
    val film: LiveData<Film> = filmLiveData

    fun loadFilm(){
        filmLiveData.value = useCase.run()
    }

}