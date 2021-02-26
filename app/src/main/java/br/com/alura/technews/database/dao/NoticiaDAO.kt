package br.com.alura.technews.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import br.com.alura.technews.model.Noticia
import java.nio.charset.CodingErrorAction.REPLACE

@Dao
interface NoticiaDAO {

    @Query("SELECT * FROM Noticia ORDER BY id DESC")
    fun buscaTodos(): LiveData<List<Noticia>>

    @Insert
    fun salva(noticia: Noticia)

    @Delete
    fun remove(noticia: Noticia)

    @Query("SELECT * FROM Noticia WHERE id = :id")
    fun buscaPorId(id: Long): LiveData<Noticia?>

    @Insert
    fun salva(noticias: List<Noticia>)

}
