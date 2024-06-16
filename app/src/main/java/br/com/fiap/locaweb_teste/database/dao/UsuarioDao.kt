package br.com.fiap.locaweb_teste.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.com.fiap.locaweb_teste.model.Usuario

@Dao
interface UsuarioDao {

    @Insert
    fun salvar(Usuario : Usuario) : Long

    @Update
    fun atualizar(Contato: Usuario): Int

    @Delete
    fun excluir(Contato: Usuario): Int

    @Query("SELECT * From tbl_usuario WHERE id = :id")
    fun buscarContatoPeloId(id: Int): Usuario

    @Query("SELECT * FROM tbl_Usuario ORDER BY email ASC")
    fun listarUsuarios(): List<Usuario>
}