package com.allenhouse.mini_project

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Toast
import com.allenhouse.mini_project.databinding.ActivityLogPassBinding

class log_pass : AppCompatActivity() {
    private lateinit var binding: ActivityLogPassBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLogPassBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.login.setOnClickListener {
            val password = binding.editLogPassword.text.toString().trim()
            if (password.isNotEmpty()) {
                val i = Intent(this, navbar::class.java)
                startActivity(i)
            } else {
                Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
