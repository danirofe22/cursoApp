package es.danirofe.cursokotlin

import android.os.Bundle
import android.os.PersistableBundle
import androidx.fragment.app.FragmentActivity
import es.danirofe.cursokotlin.databinding.MainBinding
import es.danirofe.cursokotlin.film.FilmFragment
import es.danirofe.cursokotlin.list.FilmListFragment

class MainActivity : FragmentActivity(), FilmLauncher {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        val binding = MainBinding.inflate(layoutInflater)
        setContentView((binding.root))

        supportFragmentManager.beginTransaction()
            .add(R.id.list, FilmListFragment())
            .commit()
    }

    override fun openDetails(id: Int) {
        val fragment = FilmFragment()
        fragment.arguments = Bundle().apply {
            putInt(FilmFragment.FILM_ID, id)
        }
        val isTablet = resources.getBoolean(R.bool.isTablet)
        if(isTablet){
            supportFragmentManager.beginTransaction()
                .add(R.id.detail, FilmListFragment())
                .commit()
        }else{
            supportFragmentManager.beginTransaction()
                .addToBackStack("BACKSTACK")
                .add(R.id.list, FilmListFragment())
                .commit()
        }
    }
}