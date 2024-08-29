package Fragment

import Adapter.HomeCardViewAdapter
import Adapter.HomeCategeoryAdapter
import Adapter.HomeDrListAdapter
import Viewmodel.HomeViewModel
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.root.R
import com.example.root.databinding.FragmentHomeBinding
import model.CardView
import model.CatgeoryModel
import model.DrListModel

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Initialize the ViewModel here
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
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

//        For Dr Avalibilty
        val recyclerView = binding.recyclerView
        val adapter = HomeCardViewAdapter(emptyList())
        recyclerView.adapter = adapter
//        adapter.notifyDataSetChanged()

        homeViewModel._cardData.observe(viewLifecycleOwner, {cdata ->
            adapter.updateData(cdata)
        })

//        For Category
        val cateRecyclerView = binding.rvCategeory
        val cadapter = HomeCategeoryAdapter(emptyList())
        cateRecyclerView.adapter = cadapter
//        cadapter.notifyDataSetChanged()

        homeViewModel._categeoryData.observe(viewLifecycleOwner,{ cdata ->
            cadapter.updateData(cdata)
        })

//    For DR List
        val drListRecyclerView = binding.rvDr
        val drListAdapter = HomeDrListAdapter(emptyList())
        drListRecyclerView.adapter = drListAdapter
//        drListAdapter.notifyDataSetChanged()
        homeViewModel._drListData.observe(viewLifecycleOwner, { drListData ->
            drListAdapter.updateData(drListData)
        })






    }
}