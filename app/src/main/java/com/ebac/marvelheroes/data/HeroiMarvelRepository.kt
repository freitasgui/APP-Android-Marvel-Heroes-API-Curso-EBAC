package com.ebac.marvelheroes.data

import com.ebac.marvelheroes.data.model.heroiResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HeroiMarvelRepository {
    private var retrofit: Retrofit = Retrofit.Builder() //controle de chamadas e retornos da API
        .baseUrl("https://gateway.marvel.com:443") // endpoint do gateway
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun buscarHeroiPorNome(nome :String, sucesso:(heroiResponse) ->Unit, erro : () -> Unit ){
        val api = retrofit.create(MarvelAPI::class.java)

        api.buscarHeroiPorNome(nome, KEY, TIMESTAMP, HASH).enqueue(
            object: Callback<heroiResponse>{
                override fun onResponse(call: Call<heroiResponse>?, response: Response<heroiResponse>?)
                {
                    if (response?.isSuccessful== true){
                        sucesso(response.body())
                    }
                    else
                    {
                        erro()
                    }
                }

                override fun onFailure(call: Call<heroiResponse>?, t: Throwable?) {
                    TODO("Not yet implemented")
                }

            }
        )
    }

    companion object{
        val KEY = "c53c99c94574682d669f0ce43e8245f0"
        val TIMESTAMP = "1660260465"
        val HASH = "bee33d3b319b89984bc9659155709c33"
    }
}