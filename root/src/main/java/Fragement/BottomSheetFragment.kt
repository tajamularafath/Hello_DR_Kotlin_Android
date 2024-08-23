package Fragement

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import com.example.root.R
import com.example.root.databinding.FragmentBottomSheetBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class BottomSheetFragment : Fragment() {

    lateinit var binding: FragmentBottomSheetBinding
    lateinit var bottomNav: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentBottomSheetBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)

        val homeFragment = HomeFragment()
        val calendarFragment = CalendarFragment()
        val messageFragment = MessageFragment()
        val profileFragment = ProfileFragment()

        bottomNav = binding.bottomNav

        replacefragment(homeFragment)
        bottomNav.setOnItemSelectedListener { item ->

            when(item.itemId){
                R.id.home -> {
                    replacefragment(homeFragment)
                    true
                }
                R.id.calendar -> {
                    replacefragment(calendarFragment)
                    true
                }
                R.id.message -> {
                    replacefragment(messageFragment)
                    true
                }
                R.id.profile -> {
                    replacefragment(profileFragment)
                    true
                }
                else -> false
            }
        }
    }

    private fun replacefragment(fragment: Fragment){
        childFragmentManager.beginTransaction()
            .replace(R.id.root_host_fragment, fragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .addToBackStack(null)
            .commit()
    }
}