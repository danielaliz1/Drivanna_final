package com.drivana.app.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Entidad que representa a un usuario registrado en Drivana.
 * Se persiste localmente mediante Room.
 */
@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val correo: String,
    val usuario: String,
    val contrasena: String
)
