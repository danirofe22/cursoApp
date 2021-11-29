package es.danirofe.cursokotlin

import android.util.Log
import javax.inject.Inject

//Con el inject no hay que declarar el objeto para usarlo
class CursoKotlinLog @Inject constructor() {

    fun log(message: String){
        Log.d("dani", message)
    }
}