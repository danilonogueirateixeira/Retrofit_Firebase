package br.com.retrofit.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.retrofit.R
import br.com.retrofit.model.Filme
import kotlinx.android.synthetic.main.filme_item.view.*


class FilmeListAdapter(private val filmes: List<Filme>,
                       private val context: Context) : Adapter<FilmeListAdapter.ViewHolder>() {

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val filme = filmes[p1]
        p0?.let {
            it.bindView(filme)
        }    }



    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.filme_item, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return filmes.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(filme: Filme) {
            val nome = itemView.filme_item_nome
            val descricao = itemView.filme_item_descricao
            val ano = itemView.filme_item_ano

            nome.text = filme.nome
            descricao.text = filme.categoria
            ano.text = filme.ano.toString()
        }

    }


}