package com.ebac.marvelheroes.presentation.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ebac.marvelheroes.databinding.RevistaItemBinding

class SerieAdapter(private val listaSeries:ArrayList<String>):
    RecyclerView.Adapter<SerieAdapter.SerieItemViewHolder>()
{
    class SerieItemViewHolder(private val binding: RevistaItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(nomeRevista : String){
            binding.tituloRevista.text = nomeRevista
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SerieItemViewHolder {
        val binding = RevistaItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SerieItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SerieItemViewHolder, position: Int) {
        // pega a posição e chama o create view holder e o onbind que vai pegar o item passando para o holder colocar na tela
        val nomeSerie = listaSeries[position]
        holder.bind(nomeSerie)
    }

    override fun getItemCount(): Int {
        return listaSeries.size
    }
}