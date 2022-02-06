package com.example.myfoodie.data.home

import androidx.lifecycle.MutableLiveData
import com.example.myfoodie.R
import java.util.ArrayList

class HomeItemRepository {

    val _homeItemList = MutableLiveData<List<HomeItemModel>>().apply {
        value = ArrayList(listOf(
            HomeItemModel(R.drawable.smosa,"Samosa",20,56),
            HomeItemModel(R.drawable.sadwitch2,"Sandwitch",15,66),
            HomeItemModel(R.drawable.shakes,"Shake",30,26),
            HomeItemModel(R.drawable.shnakes,"Shnakes",36,62),
            HomeItemModel(R.drawable.bergger,"Bergger",25,44),
            HomeItemModel(R.drawable.dosa,"Dosa",15,45),
            HomeItemModel(R.drawable.pakodi,"Pakodi",20,55),
            HomeItemModel(R.drawable.lichicipizza,"Pizza",220,561)
        ))

    }

}