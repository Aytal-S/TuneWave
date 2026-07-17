package com.allenhouse.mini_project

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Toast
import com.allenhouse.mini_project.databinding.ActivityGenderBinding

class gender : AppCompatActivity() {
    private lateinit var binding: ActivityGenderBinding
    private var selectedGender: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityGenderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val genderButtons = listOf(
            binding.btnFemale,
            binding.btnMale,
            binding.btnOther,
            binding.btnNonBinary,
            binding.btnPreferNotToSay
        )

        genderButtons.forEach { button ->
            button.setOnClickListener {
                selectedGender = button.text.toString()
                // Simple visual feedback: could be improved with drawable states
                Toast.makeText(this, "Selected: $selectedGender", Toast.LENGTH_SHORT).show()
            }
        }

        binding.createBtn.setOnClickListener {
            if (selectedGender != null) {
                val i = Intent(this, navbar::class.java)
                startActivity(i)
            } else {
                Toast.makeText(this, "Please select your gender", Toast.LENGTH_SHORT).show()
            }
        }
    }
}