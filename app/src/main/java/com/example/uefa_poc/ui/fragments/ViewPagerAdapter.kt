package com.example.uefa_poc.ui.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

private const val NUM_TABS = 5

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> OverviewFragment.newInstance("","")
            1 -> MatchesFragment.newInstance("","")
            2 -> GroupsFragment()
            3 -> StatsFragment.newInstance("","")
            else ->   SquadFragment()
        }
    }
}