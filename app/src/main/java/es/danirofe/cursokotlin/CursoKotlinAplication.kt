package es.danirofe.cursokotlin

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CursoKotlinAplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}