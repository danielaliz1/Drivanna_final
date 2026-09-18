package com.drivana.app.ui.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.drivana.app.R
import com.drivana.app.data.AppDatabase
import com.drivana.app.data.SessionManager
import com.drivana.app.databinding.ActivityLoginBinding
import com.drivana.app.ui.main.MainActivity
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val db by lazy { AppDatabase.getInstance(this) }
    private val session by lazy { SessionManager(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener { finish() }

        binding.tvIrRegistro.text = buildLinkText(
            getString(R.string.no_tienes_cuenta),
            getString(R.string.registrate)
        )
        binding.tvIrRegistro.setOnClickListener {
            startActivity(Intent(this, RegistroActivity::class.java))
        }

        binding.btnIniciarSesion.setOnClickListener { validarYEntrar() }
    }

    private fun validarYEntrar() {
        val usuario = binding.etUsuario.text.toString().trim()
        val contrasena = binding.etContrasena.text.toString().trim()

        if (usuario.isEmpty() || contrasena.isEmpty()) {
            Toast.makeText(this, R.string.error_campos_vacios, Toast.LENGTH_SHORT).show()
            return
        }

        lifecycleScope.launch {
            val user = db.userDao().login(usuario, contrasena)
            if (user == null) {
                Toast.makeText(this@LoginActivity, R.string.credenciales_invalidas, Toast.LENGTH_SHORT).show()
            } else {
                if (binding.cbMantenerSesion.isChecked) {
                    session.guardarSesion(user.usuario)
                }
                Toast.makeText(
                    this@LoginActivity,
                    getString(R.string.bienvenida, user.usuario),
                    Toast.LENGTH_SHORT
                ).show()
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                intent.putExtra(MainActivity.EXTRA_USUARIO, user.usuario)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun buildLinkText(base: String, link: String): String = base + link
}
