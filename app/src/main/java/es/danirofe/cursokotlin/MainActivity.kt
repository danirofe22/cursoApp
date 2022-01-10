package es.danirofe.cursokotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import es.danirofe.cursokotlin.databinding.ActivityMainBinding
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var log: CursoKotlinLog
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        log.log("La actividad se ha creado")

        binding.title.text = it.


    }


    override fun onResume() {
        super.onResume()
        log.log("La actividad entra en el estado visible")
    }
    override fun onPause() {
        super.onPause()
        log.log("La actividad sale del estado visible")
    }

    override fun onStart() {
        super.onStart()
        log.log("La actividad ha entrado en estado foreGround")

    }

    override fun onDestroy() {
        super.onDestroy()
        log.log("La actividad ha sido borrada de la memoria")
    }

    override fun onStop() {
        super.onStop()
        log.log("La activida ha entrado en estado foreGround")
    }


}