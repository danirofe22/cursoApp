package es.danirofe.cursokotlin.list

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import es.danirofe.cursokotlin.FilmLauncher
import es.danirofe.cursokotlin.R
import es.danirofe.cursokotlin.databinding.FilmListBinding
import javax.inject.Inject

@AndroidEntryPoint
class FilmListFragment : Fragment() {

    @Inject
    lateinit var adapter: FilmListAdapter

    private lateinit var binding: FilmListBinding

    private var filmLaucher: FilmLauncher? = null

    private val viewModel: FilmListViewModel by viewModels()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        filmLaucher = context as? FilmLauncher
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FilmListBinding.inflate(layoutInflater)


        binding.root.adapter = adapter

        val isTablet = resources.getBoolean(R.bool.isTablet)
        if(isTablet){
            binding.root.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false )
        }else{
            binding.root.layoutManager = GridLayoutManager(context, 2)
        }

        viewModel.loadFilms()
        viewModel.films.observe(this){
            adapter.submitList(it)
        }
        adapter.callback = {
            filmLaucher?.openDetails(it.id)
        }
        return binding.root
    }

    }




