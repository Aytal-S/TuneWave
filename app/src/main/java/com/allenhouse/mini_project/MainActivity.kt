package com.allenhouse.mini_project

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.allenhouse.mini_project.databinding.ActivityMainBinding
import com.allenhouse.mini_project.databinding.ActivitySplashScreenBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.SBtn.setOnClickListener{
        var i= Intent(this, sign_up_page::class.java)
            startActivity(i)
        }
        binding.logBtn.setOnClickListener{
            var i= Intent(this, login_page::class.java)
            startActivity(i)

        }
    }
}