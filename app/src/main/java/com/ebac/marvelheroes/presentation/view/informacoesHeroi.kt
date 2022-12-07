package com.ebac.marvelheroes.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ebac.marvelheroes.R
import com.ebac.marvelheroes.databinding.ActivityInformacoesHeroiBinding

class informacoesHeroi : AppCompatActivity() {
    private lateinit var binding: ActivityInformacoesHeroiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInformacoesHeroiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val b = intent.extras
        val nome = b?.getString("nome") ?: ""
        val desc = b?.getString("descricao") ?: ""

        binding.nomeHeroi.text = nome
        binding.resumoHeroi.text = desc

        val adapter = RevistaAdapter(
            arrayListOf("Revista #1", "Revista #2", "Revista #3")
        )
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.listaQuadrinhos.layoutManager = layoutManager
        binding.listaQuadrinhos.adapter = adapter

        val adapter2 = SerieAdapter(
            arrayListOf("Serie #1", "Serie #2", "Serie #3")
        )
        val layoutManager2 = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.listaSeries.layoutManager = layoutManager2
        binding.listaSeries.adapter = adapter2

    }
}