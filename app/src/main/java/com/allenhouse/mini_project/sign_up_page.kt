package com.allenhouse.mini_project

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.allenhouse.mini_project.databinding.ActivitySignUpPageBinding

class sign_up_page : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySignUpPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.ConBtn.setOnClickListener {
            val name = binding.editName.text.toString().trim()
            val email = binding.editEmail.text.toString().trim()

            if (name.isNotEmpty() && email.isNotEmpty()) {
                val sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString("userName", name)
                editor.putString("userEmail", email)
                editor.apply()

                val i = Intent(this, password::class.java)
                startActivity(i)
            } else {
                Toast.makeText(this, "Please enter both name and email", Toast.LENGTH_SHORT).show()
            }
        }

        binding.googleBtn.setOnClickListener {
            val i = Intent(this, password::class.java)
            startActivity(i)
        }
    }
}
