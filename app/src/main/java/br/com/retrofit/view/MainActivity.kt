package br.com.retrofit.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.Log
import br.com.retrofit.adapter.FilmeListAdapter
import br.com.retrofit.R
import br.com.retrofit.model.Filme
import br.com.retrofit.network.RetrofitInitializer
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* INICIANDO A CHAMADA DO SERVICE */
        val call = RetrofitInitializer().filmeService().list()

        /* REALIZANDO CHAMADA ASSINCRONA */
        call.enqueue(object : Callback <Map<String, Filme>> {

            /* RESPONSTA DE SUCESSO DA CHAMADA */
            override fun onResponse(call: Call <Map<String, Filme>>, response: Response<Map<String, Filme>>) {
                response.body()?.let {
                    val filmes: List<Filme> = it.values.toList()
                    Log.i("FILME SUCESSO", filmes.toString())

                    /* PREENCHIMENTO DA LISTA PARA ADAPTER */
                    configureList(filmes)
                }
            }

            /* RESPONSTA DE ERRO DA CHAMADA */
            override fun onFailure(call: Call<Map<String, Filme>>, t: Throwable) {
                Log.e("FILME ERROR", t?.message)
            }
        })
    }

    /* PREENCHIMENTO DO ADAPTER */
    private fun configureList(filmes: List<Filme>) {
        val recyclerView = filme_list_recyclerview
        recyclerView.adapter = FilmeListAdapter(filmes, this)
        val layoutManager = StaggeredGridLayoutManager(
            3, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager
    }

}
