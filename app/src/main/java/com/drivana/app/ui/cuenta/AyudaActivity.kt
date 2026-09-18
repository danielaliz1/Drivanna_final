package com.drivana.app.ui.cuenta

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.drivana.app.databinding.ActivityAyudaBinding

class AyudaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAyudaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAyudaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener { finish() }

        binding.btnContactaSoporte.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("tel:+33420628643"))
            startActivity(intent)
        }
    }
}
