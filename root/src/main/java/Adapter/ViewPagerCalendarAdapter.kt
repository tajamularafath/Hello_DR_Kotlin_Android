package Adapter

import Fragment.CalendarFragment
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerCalendarAdapter(private val fragments: List<Fragment>, fragmentActivity: CalendarFragment)
    : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}