package br.com.retrofit.view

import android.arch.persistence.room.Room
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.Log
import br.com.retrofit.model.AppDatabase
import br.com.retrofit.adapter.FilmeListAdapter
import br.com.retrofit.R
import br.com.retrofit.model.Filme
import br.com.retrofit.model.FilmeDao
import br.com.retrofit.retrofit.FilmeService
import br.com.retrofit.retrofit.FilmeServiceImpl
import br.com.retrofit.retrofit.RetrofitInitializer
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var filmeDao: FilmeDao

    var filmes: List<Filme>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val database = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "teste-database")
            .allowMainThreadQueries()
            .build()


        filmeDao = database.filmeDao()







        val call = FilmeServiceImpl()




        call.listar()
//        call.adicionar(Filme("Batman - O cavaleiro", "DC", 2019))
//        call.atualizar("-LSApvhKHcFOAfviAVh4", Filme("Homem Aranha", "Marvel", 2012))
//        call.deletar("-Lo_yV-RZsiUbEIGKbDj")





    }

    /* PREENCHIMENTO DO ADAPTER */
    fun configureList(filmes: List<Filme>) {
        val recyclerView = filme_list_recyclerview
        recyclerView.adapter = FilmeListAdapter(filmes, this)
        val layoutManager = StaggeredGridLayoutManager(
            3, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager
    }

    fun adicionar() {
        for (i in 0 until filmes!!.size) {

            //Log.i("PRODUTOS", produtos!![i].nome + " "+ produtos!![i].marca)

            filmeDao.add(filmes!![i])

        }
    }

    fun listarBanco() {
        for (i in 0 until filmeDao.all().size) {

            //Log.i("PRODUTOS", produtos!![i].nome + " "+ produtos!![i].marca)

            Log.i("FILME BANCO", filmeDao.all()[i].nome)

        }
    }


    fun filmes(filme: List<Filme>): List<Filme>{


        return filme
    }
}
