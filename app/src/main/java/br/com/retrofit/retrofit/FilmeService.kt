package br.com.retrofit.retrofit

import br.com.retrofit.model.Filme
import retrofit2.Call
import retrofit2.http.*

interface FilmeService{

    @GET("filmes.json")
    fun listar() : Call <Map<String, Filme>>

    @POST("filmes/.json")
    fun adicionar(@Body filme : Filme) : Call<Filme>

    @PUT("filmes/{new}.json")
    fun atualizar(@Path("new") id : String, @Body filme : Filme ) : Call<Filme>

    @DELETE("filmes/{new}.json")
    fun deletar(@Path("new") id : String) : Call<Filme>
}