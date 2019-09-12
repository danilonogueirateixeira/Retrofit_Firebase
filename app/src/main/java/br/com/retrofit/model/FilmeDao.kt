package br.com.retrofit.model

import android.arch.persistence.room.*

@Dao
interface FilmeDao {

    @Query("SELECT * FROM filme")
    fun all(): List<Filme>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(vararg filme: Filme)

    @Update
    fun update(vararg filme: Filme)

    @Delete
    fun delete(vararg filme: Filme)
}