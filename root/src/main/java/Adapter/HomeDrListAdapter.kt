package Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.root.R
import com.example.root.databinding.DrCardViewBinding
import model.CardView
import model.DrListModel

class HomeDrListAdapter(var drListModel: List<DrListModel>): RecyclerView.Adapter<HomeDrListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DrCardViewBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return drListModel.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val itemViewModel = drListModel[position]
        holder.binding.apply {
            ivDr.load(itemViewModel.drImage){
                placeholder(R.drawable.home)
                error(R.drawable.message)
            }
            tvDrname.setText(itemViewModel.drName)
            tvDrhospital.setText(itemViewModel.drHospital)
            tvRatingcount.setText(itemViewModel.ratingCount)
        }
    }

    fun updateData(newData: List<DrListModel>){
        drListModel = newData
        notifyDataSetChanged()
    }

   class ViewHolder(val binding: DrCardViewBinding): RecyclerView.ViewHolder(binding.root) {

    }
}