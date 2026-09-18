package com.drivana.app.ui.entrada

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.drivana.app.data.SessionManager
import com.drivana.app.databinding.ActivityEntradaBinding
import com.drivana.app.ui.auth.LoginActivity
import com.drivana.app.ui.auth.RegistroActivity
import com.drivana.app.ui.main.MainActivity

class EntradaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEntradaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEntradaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Si ya hay una sesión guardada ("Mantenerse en la sesión"), saltar directo al home.
        val session = SessionManager(this)
        if (session.haySesionActiva()) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
            return
        }

        binding.btnIniciarSesion.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        binding.btnRegistrarse.setOnClickListener {
            startActivity(Intent(this, RegistroActivity::class.java))
        }
    }
}
