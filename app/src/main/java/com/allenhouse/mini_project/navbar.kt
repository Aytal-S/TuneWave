package com.allenhouse.mini_project

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.allenhouse.mini_project.databinding.ActivityNavbarBinding

class navbar : AppCompatActivity() {
    private lateinit var binding : ActivityNavbarBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityNavbarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        supportFragmentManager.beginTransaction().replace(
            R.id.fragment_container_view,
            home()
        ).commit()


        binding.bottom.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fragment_container_view,
                        home()
                    ).commit()
                    true
                }

                R.id.fav -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fragment_container_view,
                        favorites()
                    ).commit()
                    true
                }

                R.id.playlist -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fragment_container_view,
                        playlist()
                    ).commit()
                    true
                }

                R.id.profile -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fragment_container_view,
                        profile()
                    ).commit()
                    true
                }

                R.id.search -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fragment_container_view,
                        search()
                    ).commit()
                    true
                }

                else -> false
            }
        }

    }


}