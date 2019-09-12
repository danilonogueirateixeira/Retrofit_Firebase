package br.com.retrofit.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class Filme (@PrimaryKey(autoGenerate = false)
             val nome: String,
             val categoria: String,
             val ano: Int)
