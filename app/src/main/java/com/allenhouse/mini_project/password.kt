package com.allenhouse.mini_project

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Toast
import com.allenhouse.mini_project.databinding.ActivityPasswordBinding

class password : AppCompatActivity() {
    private lateinit var binding: ActivityPasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.nextBtn.setOnClickListener {
            val password = binding.editPassword.text.toString().trim()
            if (password.isNotEmpty()) {
                val i = Intent(this, birthdate::class.java)
                startActivity(i)
            } else {
                Toast.makeText(this, "Please enter a password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}