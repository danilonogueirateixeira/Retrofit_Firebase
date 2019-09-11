package br.com.retrofit.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://trabalhofinal-6da66.firebaseio.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun filmeService () = retrofit.create(FilmeService::class.java)

}