package com.drivana.app.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.drivana.app.R
import com.drivana.app.databinding.ActivityMainBinding
import com.drivana.app.ui.busqueda.BusquedaFragment
import com.drivana.app.ui.carro.CarroFragment
import com.drivana.app.ui.cuenta.CuentaFragment
import com.drivana.app.ui.inicio.InicioFragment
import com.drivana.app.ui.notificaciones.NotificacionesFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val usuario = intent.getStringExtra(EXTRA_USUARIO) ?: ""

        if (savedInstanceState == null) {
            abrirFragment(InicioFragment.newInstance(usuario))
        }

        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_inicio -> abrirFragment(InicioFragment.newInstance(usuario))
                R.id.nav_busqueda -> abrirFragment(BusquedaFragment())
                R.id.nav_carro -> abrirFragment(CarroFragment())
                R.id.nav_notificaciones -> abrirFragment(NotificacionesFragment())
                R.id.nav_cuenta -> abrirFragment(CuentaFragment.newInstance(usuario))
            }
            true
        }
    }

    private fun abrirFragment(fragment: androidx.fragment.app.Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

    companion object {
        const val EXTRA_USUARIO = "extra_usuario"
    }
}
