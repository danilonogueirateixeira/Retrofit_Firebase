package br.com.retrofit.model

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import br.com.retrofit.model.Filme
import br.com.retrofit.model.FilmeDao

@Database(entities = [Filme::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun filmeDao(): FilmeDao
}