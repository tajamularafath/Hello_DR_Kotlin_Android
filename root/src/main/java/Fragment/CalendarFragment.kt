package Fragment

import Adapter.ViewPagerCalendarAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.root.R
import com.example.root.databinding.FragmentCalendarBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class CalendarFragment : Fragment() {

    lateinit var binding: FragmentCalendarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calendar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCalendarBinding.bind(view)

        val navController = findNavController()
        val tabLayout = binding.tabLayoutCalendar
        tabLayout.addTab(tabLayout.newTab().setText("Upcoming"))
        tabLayout.addTab(tabLayout.newTab().setText("Completed"))
        tabLayout.addTab(tabLayout.newTab().setText("Cancelled"))
        val viewPager: ViewPager2 = binding.viewPagerCalendar

        val fragments = listOf(
            UpcomingFragment(),
            CompletedFragment(), CancelledFragment()
        )
        val adapter = ViewPagerCalendarAdapter(fragments, this)
        viewPager.adapter = adapter

        // Adding a TabSelectedListener to perform navigation actions when a tab is selected
//        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
//            override fun onTabSelected(tab: TabLayout.Tab) {
//                when (tab.position) {
//                    0 -> {
//                        // Navigate when the Upcoming tab is selected
//                        navController.navigate(R.id.action_upcomingFragment_to_completedFragment)
//                    }
//                    1 -> {
//                        // Navigate when the Completed tab is selected
//                        navController.navigate(R.id.action_upcomingFragment_to_completedFragment)
//                    }
//                    2 -> {
//                        // Navigate when the Cancelled tab is selected
//                        navController.navigate(R.id.action_cancelledFragment_to_upcomingFragment)
//                    }
//                }
//            }
//
//            override fun onTabUnselected(tab: TabLayout.Tab?) {
//            }
//
//            override fun onTabReselected(tab: TabLayout.Tab?) {
//            }
//        })


//         Setup TabLayout with ViewPager2
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Upcoming"
                1 -> "Completed"
                2 -> "Cancelled"
                else -> null
            }
        }.attach()
//        tabLayout.setupWithViewPager2(viewPager);

    }
}