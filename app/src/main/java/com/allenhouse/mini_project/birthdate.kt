package com.allenhouse.mini_project

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.allenhouse.mini_project.databinding.ActivityBirthdateBinding

class birthdate : AppCompatActivity() {
    private lateinit var binding: ActivityBirthdateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityBirthdateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.next.setOnClickListener {
            val day = binding.datePicker.dayOfMonth
            val month = binding.datePicker.month + 1
            val year = binding.datePicker.year
            val birthDate = "$day/$month/$year"

            val sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
            sharedPreferences.edit {
                putString("userBirthDate", birthDate)
            }

            val i = Intent(this, gender::class.java)
            startActivity(i)
        }
    }
}
