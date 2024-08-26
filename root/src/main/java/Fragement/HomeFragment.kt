package Fragement

import Adapter.HomeCardViewAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.root.R
import com.example.root.databinding.FragmentBottomSheetBinding
import com.example.root.databinding.FragmentHomeBinding
import model.CardView

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = binding.recyclerView

        val data = ArrayList<CardView>()

        for(i in 1..5){
            data.add(CardView(R.drawable.doctor, "DR Ummar", "Heart", "Sep 24, 12:00AM"))
        }
        val adapter = HomeCardViewAdapter(data)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
    }


}