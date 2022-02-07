package es.danirofe.cursokotlin.list

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import es.danirofe.cursokotlin.film.FilmActivity
import es.danirofe.cursokotlin.FilmListViewModel
import es.danirofe.cursokotlin.databinding.FilmListBinding
import javax.inject.Inject

@AndroidEntryPoint
class FilmListActivity : AppCompatActivity() {

    @Inject
    lateinit var adapter: FilmListAdapter

    private lateinit var binding: FilmListBinding

    private val viewModel: FilmListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FilmListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.root.adapter = adapter

        viewModel.loadFilms()
        viewModel.films.observe(this){
            adapter.submitList(it)
        }
        adapter.callback = {
            //Log.i("onclick", "${it.title}")
            startActivity(Intent(this, FilmActivity::class.java).apply {
                putExtra(FilmActivity.FILM_ID, it.id)
            })

        }

        }

    }


