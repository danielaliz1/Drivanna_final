package com.drivana.app.ui.cuenta

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.drivana.app.databinding.ActivityConfiguracionBinding

class ConfiguracionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConfiguracionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfiguracionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener { finish() }
    }
}
