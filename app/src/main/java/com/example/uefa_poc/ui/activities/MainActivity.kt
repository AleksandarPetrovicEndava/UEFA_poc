package com.example.uefa_poc.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.uefa_poc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        const val uclTheme = 1
        const val uelTheme = 2
        const val THEME_KEY = "themeKey"
        const val THEME_BUNDLE_KEY = "themeBundleKey"
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initOnClickListeners()
    }

    private fun initOnClickListeners() {
        binding.buttonUcl.setOnClickListener {
            launchSquadActivity(uclTheme)
        }

        binding.buttonUel.setOnClickListener {
            launchSquadActivity(uelTheme)
        }
    }

    private fun launchSquadActivity(theme: Int) {
        val themeBundle = Bundle()
        themeBundle.putInt(THEME_KEY, theme)
        val intent = Intent(this, DetailsActivity::class.java).apply {
            putExtra(THEME_BUNDLE_KEY, themeBundle)
        }
        startActivity(intent)
    }
}