package br.com.fiap.locaweb_teste.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_usuario")
data class Usuario(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val email: String = "",
    val password: String = "",
)


