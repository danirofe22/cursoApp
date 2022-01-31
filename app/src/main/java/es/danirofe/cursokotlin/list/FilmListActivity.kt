package es.danirofe.cursokotlin.list

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import es.danirofe.cursokotlin.FilmListViewModel
import es.danirofe.cursokotlin.databinding.FilmListBinding
import javax.inject.Inject

@AndroidEntryPoint
class FilmListActivity : AppCompatActivity() {

    @Inject
    lateinit var adapter: FilmListAdapter

    @Inject
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
        }

    }


