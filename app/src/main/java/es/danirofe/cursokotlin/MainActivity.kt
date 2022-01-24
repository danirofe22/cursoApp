package es.danirofe.cursokotlin

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import es.danirofe.cursokotlin.databinding.ActivityMainBinding
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var log: CursoKotlinLog
    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.loadFilm()
        viewModel.film.observe(this){
            binding.title.text = it.title
            binding.dirFecha.text = it.nameDir
            Glide.with(this).load(it.imageUrl).into(binding.poster)

        }

        binding.button.text= resources.getString(R.string.comprarBtn)
        binding.button2.text = resources.getString(R.string.alquilarbtn)


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