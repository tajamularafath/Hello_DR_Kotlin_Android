package Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.root.R
import com.example.root.databinding.CardViewDesignBinding
import model.CardView

class HomeCardViewAdapter(private val cList: List<CardView>): RecyclerView.Adapter<HomeCardViewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding =  CardViewDesignBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return cList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemViewModel = cList[position]
        holder.binding.apply {
            ivDrImg.load(itemViewModel.image){
                placeholder(R.drawable.home)
                error(R.drawable.calendar)
            }
            tvDoctorName.setText(itemViewModel.dName)
            tvSpecialist.setText(itemViewModel.dSpecialist)
            bTime.setText(itemViewModel.time)
        }
    }


    class ViewHolder(val binding: CardViewDesignBinding): RecyclerView.ViewHolder(binding.root) {

    }
}