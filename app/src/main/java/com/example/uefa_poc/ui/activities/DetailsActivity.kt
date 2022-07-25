package com.example.uefa_poc.ui.activities


import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import com.example.uefa_poc.R
import com.example.uefa_poc.databinding.ActivityDetailsBinding
import com.example.uefa_poc.ui.activities.MainActivity.Companion.THEME_BUNDLE_KEY
import com.example.uefa_poc.ui.activities.MainActivity.Companion.THEME_KEY
import com.example.uefa_poc.ui.fragments.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator


class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setupTheme(intent.getBundleExtra(THEME_BUNDLE_KEY))
        setupActionBar()
        setupViewPager()
        setupTabLayout()

    }

    private fun setupTheme(bundle: Bundle?) {
        when(bundle?.getInt(THEME_KEY)) {
            1 -> setupUCLTheme()
            else -> setupUELTheme()
        }
    }

    @SuppressLint("ResourceType")
    private fun setupUELTheme() {
        binding.collapsingToolbarLayout.setContentScrimColor(R.color.uel_primary)
        binding.toolbarImage.setImageResource(R.raw.pk_profiles)
        binding.tabLayout.setBackgroundResource(R.color.uel_secondary)
        binding.tabLayout.setSelectedTabIndicatorColor(R.color.uel_accent)
        binding.tabLayout.setTabTextColors(Color.parseColor(resources.getString(R.color.white)),
            Color.parseColor(resources.getString(R.color.uel_accent)))
    }

    @SuppressLint("ResourceType")
    private fun setupUCLTheme() {
        binding.collapsingToolbarLayout.setContentScrimColor(R.color.ucl_primary)
        binding.toolbarImage.setImageResource(R.raw.pk_profiles_dark)
        binding.tabLayout.setBackgroundResource(R.color.ucl_secondary)
        binding.tabLayout.setSelectedTabIndicatorColor(R.color.ucl_accent)
        binding.tabLayout.setTabTextColors(Color.parseColor(resources.getString(R.color.white)),
            Color.parseColor(resources.getString(R.color.ucl_accent)))
    }

    private fun setupViewPager() {
        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        binding.viewPager.adapter = adapter
    }

    private fun setupTabLayout() {
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when(position) {
                0 -> tab.text = "Overview"
                1 -> tab.text = "Matches"
                2 -> tab.text = "Groups"
                3 -> tab.text = "Stats"
                else -> tab.text = "Squad"
            }
        }.attach()
    }


    private fun setupActionBar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setIcon(R.drawable.ic_baseline_arrow_back_ios_24)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
}
