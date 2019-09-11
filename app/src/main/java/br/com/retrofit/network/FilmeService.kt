package br.com.retrofit.network

import br.com.retrofit.model.Filme
import retrofit2.Call
import retrofit2.http.GET

interface FilmeService{

    @GET("filmes.json")
    fun list() : Call <Map<String, Filme>>
}