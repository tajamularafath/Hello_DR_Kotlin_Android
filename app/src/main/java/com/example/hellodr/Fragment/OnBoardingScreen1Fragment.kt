package com.example.hellodr.Fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.hellodr.R
import com.example.hellodr.ViewPagerAdapter
import com.example.hellodr.databinding.FragmentOnBoardingScreen1Binding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class OnBoardingScreen1Fragment : Fragment() {

    lateinit var binding: FragmentOnBoardingScreen1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_on_boarding_screen1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentOnBoardingScreen1Binding.bind(view)

        val navController = findNavController()
        val viewPager: ViewPager2 = binding.viewPager
        viewPager.isUserInputEnabled = false

        val fragments = listOf(
            OnBoardind1Fragment(), OnBoardind2Fragment(), OnBoardind3Fragment()
        ) // Replace with your fragment instances
        val adapter = ViewPagerAdapter(fragments, this)
        viewPager.adapter = adapter

        val tabLayout: TabLayout = binding.tabLayout
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            // Set tab text or icon here if needed
//            tab.text = "${position + 1}"
            when (position) {
                0 -> {
                    tab.setIcon(R.drawable.selected_dot)
                }

                1 -> {
                    tab.setIcon(R.drawable.selected_dot)
                }

                2 -> {
                    tab.setIcon(R.drawable.selected_dot)
                }
            }
        }.attach()

//        val loginFragment = LoginFragment()
//        val transaction = parentFragmentManager.beginTransaction()
//        transaction.replace(R.id.onBoardingScreen1Fragment, loginFragment)
//        transaction.addToBackStack(null)
//        transaction.commit()

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                // Check if the current position is the last fragment
                if (position == viewPager.adapter?.itemCount?.minus(1)) {
                    binding.bNext.text = "Get Started"
                    binding.tvSkip.text = ""

                    binding.bNext.setOnClickListener {
                        // Navigate to the desired fragment using the action ID from the navigation graph
                        navController.navigate(R.id.action_onBoardingScreen1Fragment_to_loginFragment)
                    }
                } else {
                    binding.bNext.text = "Next"
                }
            }
        })

        binding.tvSkip.setOnClickListener {
            Log.d("Navigation", "tvSkip clicked")
            // Navigate to the desired fragment using the action ID from the navigation graph
            navController.navigate(R.id.action_onBoardingScreen1Fragment_to_loginFragment)
        }

        binding.bNext.setOnClickListener {
            // Check if we're not on the last fragment
            if (viewPager.currentItem < (viewPager.adapter?.itemCount?.minus(1) ?: 0)) {
                // Move to the next fragment
                viewPager.currentItem = viewPager.currentItem + 1
            } else {
                // If on the last fragment, you can decide what to do
                // For example, you can finish the activity, start a new one, etc.
            }

        }
    }

}
