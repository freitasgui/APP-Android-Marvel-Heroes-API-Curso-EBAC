package com.ebac.marvelheroes.data.model

data class heroiResponse (
    val data: InfosHeroi
)

data class InfosHeroi(
    val results: List<Heroi>
)
data class Heroi(
    val name: String,
    val description : String,
)