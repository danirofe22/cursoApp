package es.danirofe.cursokotlin.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import es.danirofe.cursokotlin.databinding.FilmOverviewBinding
import javax.inject.Inject
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide

typealias OnMessageClick = (FilmOverViewDataView) -> Unit

open class FilmViewHolder(val binding:FilmOverviewBinding): RecyclerView.ViewHolder(binding.root)


class FilmListAdapter @Inject constructor(): ListAdapter<FilmOverViewDataView, FilmViewHolder>(diffUtil){
    companion object{
        private val diffUtil = object: DiffUtil.ItemCallback<FilmOverViewDataView>(){
            override fun areContentsTheSame(
                oldItem: FilmOverViewDataView,
                newItem: FilmOverViewDataView
            ): Boolean {
                return oldItem.id ==newItem.id
            }

            override fun areItemsTheSame(
                oldItem: FilmOverViewDataView,
                newItem: FilmOverViewDataView
            ): Boolean {
                return oldItem == newItem
            }

        }
    }

    var callback: OnMessageClick? =null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
        object:FilmViewHolder(FilmOverviewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)){}


    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val film = getItem(position)
        holder.binding.info.text =film.title
        Glide.with(holder.binding.imageInfo).load(film.imageUrl).into(holder.binding.imageInfo)
        holder.binding.root.setOnClickListener {
            callback?.invoke(film)
        }

    }
}