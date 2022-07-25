package com.example.uefa_poc.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.uefa_poc.R

import com.example.uefa_poc.databinding.ActivitySquadDetailsBinding

class SquadDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySquadDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySquadDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}
