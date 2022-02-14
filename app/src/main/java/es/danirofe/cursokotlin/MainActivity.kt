package es.danirofe.cursokotlin

import android.os.Bundle
import android.os.PersistableBundle
import androidx.fragment.app.FragmentActivity
import es.danirofe.cursokotlin.databinding.ActivityMainBinding
import es.danirofe.cursokotlin.databinding.MainBinding

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        val binding = MainBinding.inflate(layoutInflater)
        setContentView((binding.root))
    }
}