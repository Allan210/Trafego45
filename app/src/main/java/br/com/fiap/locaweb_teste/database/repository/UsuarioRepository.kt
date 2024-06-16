package br.com.fiap.locaweb_teste.database.repository

import android.content.Context
import br.com.fiap.locaweb_teste.database.dao.UsuarioDb
import br.com.fiap.locaweb_teste.model.Usuario

class UsuarioRepository(context: Context) {

    private val db = UsuarioDb.getDatabase(context).usuarioDao()

    fun salvar(usuario: Usuario): Long {
        return db.salvar(usuario)
    }

    fun atualizar(usuario: Usuario): Int {
        return db.atualizar(usuario)
    }

    fun excluir(usuario: Usuario): Int {
        return db.excluir(usuario)
    }

    fun buscarUsuarioPeloId(id: Int): Usuario {
        return db.buscarContatoPeloId(id)
    }

}
