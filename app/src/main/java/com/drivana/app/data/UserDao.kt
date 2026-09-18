package com.drivana.app.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertUser(user: User): Long

    @Query("SELECT * FROM users WHERE usuario = :usuario LIMIT 1")
    suspend fun findByUsuario(usuario: String): User?

    @Query("SELECT * FROM users WHERE usuario = :usuario AND contrasena = :contrasena LIMIT 1")
    suspend fun login(usuario: String, contrasena: String): User?

    @Query("SELECT COUNT(*) FROM users WHERE usuario = :usuario")
    suspend fun countByUsuario(usuario: String): Int
}
