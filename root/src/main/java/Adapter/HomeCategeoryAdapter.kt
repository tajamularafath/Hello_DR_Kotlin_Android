package Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.root.R
import com.example.root.databinding.CategeoryCardViewBinding
import model.CatgeoryModel

class HomeCategeoryAdapter(private var cList: List<CatgeoryModel>): RecyclerView.Adapter<HomeCategeoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding= CategeoryCardViewBinding
        .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return cList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val itemViewModel = cList[position]
        holder.binding.apply {
            ivCateimg.load(itemViewModel.ctImage){
                placeholder(R.drawable.home)
                error(R.drawable.calendar)
            }
            tvCate.setText(itemViewModel.ctText)
        }

    }
    fun updateData(newData:List<CatgeoryModel>){
        cList = newData
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: CategeoryCardViewBinding): RecyclerView.ViewHolder(binding.root) {

    }
}