package com.ebac.marvelheroes.data

import android.telecom.Call
import com.ebac.marvelheroes.data.model.heroiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelAPI {
    // Passo: Ver o tipo do método e a rota
    @GET("/v1/public/characters") // <--- Rota do endpoint

    fun buscarHeroiPorNome(
        @Query("name") name: String,
        @Query("apikey") apiKey: String,
        @Query("ts") ts: String,
        @Query("hash") hash: String
    ): retrofit2.Call<heroiResponse>
}