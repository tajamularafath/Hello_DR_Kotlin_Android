package Fragement

import Adapter.HomeCardViewAdapter
import Adapter.HomeCategeoryAdapter
import Adapter.HomeDrListAdapter
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
import model.CatgeoryModel
import model.DrListModel

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

//        For Dr Avalibilty
        val recyclerView = binding.recyclerView

        val data = ArrayList<CardView>()

        for(i in 1..5){
            data.add(CardView(R.drawable.doctor, "DR Ummar", "Cardiology", "Sep 24, 12:00AM"))
        }
        val adapter = HomeCardViewAdapter(data)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()

//        For Category
        val cateRecyclerView = binding.rvCategeory
        val cdata = ArrayList<CatgeoryModel>()
        cdata.add(CatgeoryModel(R.drawable.cardiology, "Cardiology"))
        cdata.add(CatgeoryModel(R.drawable.psychologist, "Psychologist"))
        cdata.add(CatgeoryModel(R.drawable.quicktest, "Quick Test"))
        cdata.add(CatgeoryModel(R.drawable.covid, "Covid 19"))

        val cadapter = HomeCategeoryAdapter(cdata)
        cateRecyclerView.adapter = cadapter
        cadapter.notifyDataSetChanged()

//    For DR List
        val drListRecyclerView = binding.rvDr
        val drListData = ArrayList<DrListModel>()

        drListData.add(DrListModel(R.drawable.drf,"","Psychologist • Apollo Hospital","120"))
        drListData.add(DrListModel(R.drawable.drf,"","Psychologist • Apollo Hospital","120"))
        drListData.add(DrListModel(R.drawable.drf,"","Psychologist • Apollo Hospital","120"))
        drListData.add(DrListModel(R.drawable.drf,"","Psychologist • Apollo Hospital","120"))
        drListData.add(DrListModel(R.drawable.drf,"","Psychologist • Apollo Hospital","120"))
        drListData.add(DrListModel(R.drawable.drf,"","Psychologist • Apollo Hospital","120"))
        drListData.add(DrListModel(R.drawable.drf,"","Psychologist • Apollo Hospital","120"))

        val drListAdapter = HomeDrListAdapter(drListData)
        drListRecyclerView.adapter = drListAdapter
        drListAdapter.notifyDataSetChanged()






    }
}