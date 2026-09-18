package com.drivana.app.data

import android.content.Context

/**
 * Maneja la sesión actual del usuario usando SharedPreferences.
 * Se usa junto con el checkbox "Mantenerse en la sesión" del login.
 */
class SessionManager(context: Context) {

    private val prefs = context.getSharedPreferences("drivana_session", Context.MODE_PRIVATE)

    fun guardarSesion(usuario: String) {
        prefs.edit().putString(KEY_USUARIO, usuario).apply()
    }

    fun obtenerUsuario(): String? = prefs.getString(KEY_USUARIO, null)

    fun cerrarSesion() {
        prefs.edit().remove(KEY_USUARIO).apply()
    }

    fun haySesionActiva(): Boolean = obtenerUsuario() != null

    companion object {
        private const val KEY_USUARIO = "usuario_actual"
    }
}
