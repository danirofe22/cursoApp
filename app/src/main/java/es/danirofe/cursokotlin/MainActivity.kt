package es.danirofe.cursokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("daniel", "La actividad se ha creado")
    }

    override fun onResume() {
        super.onResume()
        Log.d("daniel", "La actividad entra en el estado visible")
    }
    override fun onPause() {
        super.onPause()
        Log.d("daniel", "La actividad sale del estado visible")
    }

    override fun onStart() {
        super.onStart()
        Log.d("daniel", "La actividad ha entrado en estado foreGround")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("daniel", "La actividad ha sido borrada de la memoria")
    }

    override fun onStop() {
        super.onStop()
        Log.d("daniel", "La activida ha entrado en estado foreGround")
    }
}