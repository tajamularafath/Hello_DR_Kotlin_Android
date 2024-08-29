package Viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.root.R
import model.CardView
import model.CatgeoryModel
import model.DrListModel

class HomeViewModel: ViewModel() {

    val _cardData = MutableLiveData<List<CardView>>().apply {
        value = generateCardData()
    }

    val _categeoryData = MutableLiveData<List<CatgeoryModel>>().apply {
        value = generateCategeoryData()
    }

    val _drListData = MutableLiveData<List<DrListModel>>().apply {
        value = generateDrListData()
    }

    private fun generateDrListData(): List<DrListModel>? {
        return listOf(
            DrListModel(R.drawable.drf,"Dr. Dominic Savio","Psychologist • Apollo Hospital","120"),
            DrListModel(R.drawable.drf,"Dr. Dominic Savio","Psychologist • Apollo Hospital","120"),
            DrListModel(R.drawable.drf,"Dr. Dominic Savio","Psychologist • Apollo Hospital","120"),
            DrListModel(R.drawable.drf,"Dr. Dominic Savio","Psychologist • Apollo Hospital","120"),
            DrListModel(R.drawable.drf,"Dr. Dominic Savio","Psychologist • Apollo Hospital","120"),
            DrListModel(R.drawable.drf,"Dr. Dominic Savio","Psychologist • Apollo Hospital","120"),
        )

    }

    private fun generateCategeoryData(): List<CatgeoryModel> {
        return listOf(
            CatgeoryModel(R.drawable.cardiology,"Cardiology"),
            CatgeoryModel(R.drawable.psychologist,"Psychologist"),
            CatgeoryModel(R.drawable.quicktest,"Quick Test"),
            CatgeoryModel(R.drawable.covid, "Covid 19"),
            CatgeoryModel(R.drawable.covid, "Covid 19")
        )

    }

    private fun generateCardData(): List<CardView> {

        val data = ArrayList<CardView>()
        for (i in 1..5){
            data.add(CardView(R.drawable.doctor,"DR Ummar","Cardiology","Sep 24, 12:00AM"))
        }
        return data
    }


}