package es.danirofe.cursokotlin

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import es.danirofe.domain.model.repository.Film
import es.danirofe.domain.model.repository.GetFilmUseCase
import es.danirofe.domain.model.repository.GetFilmsUseCase
import kotlinx.coroutines.*
import java.util.*
import javax.inject.Inject

@HiltViewModel
class FilmListViewModel@Inject constructor(
    private val useCase: GetFilmsUseCase
): ViewModel(), LifecycleObserver {

    private val filmListLiveData = MutableLiveData<FilmListDataView>()
    val films: LiveData<FilmListDataView> = filmListLiveData

    var job : Job? = null




    fun loadFilms() {
        val language = Locale.getDefault().language
        job = CoroutineScope(Dispatchers.IO).launch{
            val loadedFilmList = useCase.run(language)
            withContext(Dispatchers.Main){
                loadedFilmList?.let {
                    filmListLiveData.value = FilmListDataView(
                        it
                    )
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}


data class FilmListDataView(val films: List<Film>?)




