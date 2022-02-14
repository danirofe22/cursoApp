package es.danirofe.cursokotlin.film


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import es.danirofe.cursokotlin.CursoKotlinLog
import es.danirofe.cursokotlin.MainViewModel
import es.danirofe.cursokotlin.R
import es.danirofe.cursokotlin.databinding.ActivityMainBinding
import javax.inject.Inject

@AndroidEntryPoint
class FilmFragment: Fragment() {

    companion object {
        const val FILM_ID = "ID"
    }

    @Inject
    lateinit var log: CursoKotlinLog
    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ActivityMainBinding.inflate(layoutInflater)


        val id = arguments?.getInt(FILM_ID)?:600


        viewModel.loadFilm(id)
        viewModel.film.observe(this){

            activity?.title = it.title
            binding.title.text = it.title
            binding.dirFecha.text = it.nameDir
            binding.ratingBar.rating = it.rating
            binding.description.text = it.description
            Glide.with(this).load(it.imageUrl).into(binding.poster)



            binding.verTrailer.text = resources.getString(R.string.verTrailer)

            if(it.video == null){
                binding.verTrailer.visibility = View.GONE
            }else{
                binding.verTrailer.visibility = View.VISIBLE
                binding.verTrailer.setOnClickListener { _->
                    launchYouTube(it.video)
                }
            }
        }

        return binding.root
    }

    private fun launchYouTube(id:String){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("www.youtube.com/watch?v=$id"))
        startActivity(intent)
    }

}