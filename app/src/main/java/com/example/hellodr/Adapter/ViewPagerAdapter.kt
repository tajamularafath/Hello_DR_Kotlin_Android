package com.example.hellodr.Adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.hellodr.Fragment.OnBoardingScreen1Fragment

class ViewPagerAdapter(private val fargments: List<Fragment>, fragmentActivity: OnBoardingScreen1Fragment): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return fargments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fargments[position]
    }
}