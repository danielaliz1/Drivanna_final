package com.drivana.app.ui.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.drivana.app.R
import com.drivana.app.data.AppDatabase
import com.drivana.app.data.User
import com.drivana.app.databinding.ActivityRegistroBinding
import kotlinx.coroutines.launch

class RegistroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistroBinding
    private val db by lazy { AppDatabase.getInstance(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvIrLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        binding.btnRegistrarse.setOnClickListener { validarYRegistrar() }
    }

    private fun validarYRegistrar() {
        val correo = binding.etCorreo.text.toString().trim()
        val usuario = binding.etUsuario.text.toString().trim()
        val contrasena = binding.etContrasena.text.toString().trim()

        if (correo.isEmpty() || usuario.isEmpty() || contrasena.isEmpty()) {
            Toast.makeText(this, R.string.error_campos_vacios, Toast.LENGTH_SHORT).show()
            return
        }

        lifecycleScope.launch {
            val existentes = db.userDao().countByUsuario(usuario)
            if (existentes > 0) {
                Toast.makeText(this@RegistroActivity, R.string.usuario_ya_existe, Toast.LENGTH_SHORT).show()
                return@launch
            }

            db.userDao().insertUser(User(correo = correo, usuario = usuario, contrasena = contrasena))

            Toast.makeText(this@RegistroActivity, R.string.registro_exitoso, Toast.LENGTH_SHORT).show()
            startActivity(Intent(this@RegistroActivity, LoginActivity::class.java))
            finish()
        }
    }
}
