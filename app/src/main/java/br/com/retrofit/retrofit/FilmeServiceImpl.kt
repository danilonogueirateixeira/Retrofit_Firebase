package br.com.retrofit.retrofit

import android.util.Log
import br.com.retrofit.model.Filme
import br.com.retrofit.view.MainActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FilmeServiceImpl : FilmeService{


    override fun adicionar(filme: Filme): Call<Filme> {
        val call = RetrofitInitializer().filmeService().adicionar(filme)

        call.enqueue(object : Callback<Filme>{
            override fun onFailure(call: Call<Filme>, t: Throwable) {
                Log.e("ADICIONAR ERRO", t.message)
            }

            override fun onResponse(call: Call<Filme>, response: Response<Filme>) {
                Log.i("ADICIONAR SUCESSO", response.message())
            }

        })

        return call
    }

    override fun atualizar(id: String, filme: Filme): Call<Filme> {
        val call = RetrofitInitializer().filmeService().atualizar(id, filme)

        call.enqueue(object : Callback<Filme>{
            override fun onFailure(call: Call<Filme>, t: Throwable) {
                Log.e("ATUALIZAR ERRO", t.message)
            }

            override fun onResponse(call: Call<Filme>, response: Response<Filme>) {
                Log.i("ATUALIZAR SUCESSO", response.message())
            }

        })
        return call
    }

    override fun deletar(id: String): Call<Filme> {
        val call = RetrofitInitializer().filmeService().deletar(id)
        call.enqueue(object  : Callback<Filme>{
            override fun onFailure(call: Call<Filme>, t: Throwable) {
                Log.e("DELETAR ERRO", t.message)

            }

            override fun onResponse(call: Call<Filme>, response: Response<Filme>) {
                Log.i("DELETAR SUCESSO", response.message())
            }

        })
        return call
    }

         override fun listar(): Call<Map<String, Filme>> {

             /* INICIANDO A CHAMADA DO SERVICE */
             val call = RetrofitInitializer().filmeService().listar()

             /* REALIZANDO CHAMADA ASSINCRONA */
             call.enqueue(object : Callback<Map<String, Filme>> {

                 /* RESPOSTA DE SUCESSO DA CHAMADA */
                 override fun onResponse(call: Call <Map<String, Filme>>, response: Response<Map<String, Filme>>) {
                     response.body()?.let {
                         val filmes = it.values.toList()
                         Log.i("LISTAR SUCESSO", filmes.size.toString())


                     }
                 }

                 /* RESPOSTA DE ERRO DA CHAMADA */
                 override fun onFailure(call: Call<Map<String, Filme>>, t: Throwable) {
                     Log.e("LISTAR ERRO", t.message)
                 }
             })

             return call
         }






}