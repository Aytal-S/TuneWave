package com.allenhouse.mini_project

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Toast
import com.allenhouse.mini_project.databinding.ActivityLoginPageBinding

class login_page : AppCompatActivity() {
   private lateinit var binding: ActivityLoginPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityLoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.logCon.setOnClickListener {
            val name = binding.editLoginName.text.toString().trim()
            val email = binding.editLoginEmail.text.toString().trim()
            if (name.isNotEmpty() && email.isNotEmpty()) {
                val sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString("userName", name)
                editor.putString("userEmail", email)
                editor.apply()

                val i = Intent(this, log_pass::class.java)
                startActivity(i)
            } else {
                Toast.makeText(this, "Please enter your name and email", Toast.LENGTH_SHORT).show()
            }
        }
        binding.googleBtn.setOnClickListener {
            val i = Intent(this, password::class.java)
            startActivity(i)
        }
    }
}