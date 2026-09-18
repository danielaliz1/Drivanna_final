package com.drivana.app.ui.cuenta

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.drivana.app.databinding.ActivityPrivacidadBinding

class PrivacidadActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPrivacidadBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPrivacidadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener { finish() }
    }
}
