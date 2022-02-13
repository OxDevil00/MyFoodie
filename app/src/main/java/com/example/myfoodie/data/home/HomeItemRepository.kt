package com.example.myfoodie.data.home

import androidx.lifecycle.MutableLiveData
import com.example.myfoodie.R
import java.util.ArrayList

class HomeItemRepository {

    val _homeItemList = MutableLiveData<List<HomeItemModel>>().apply {
        value = ArrayList(listOf(
            HomeItemModel(0,R.drawable.smosa,"Samosa",20,56,"Samosa Is Testy",false),
            HomeItemModel(0,R.drawable.sadwitch2,"Sandwitch",15,66,"Sandwitch Is Testy",false),
            HomeItemModel(0,R.drawable.shakes,"Shake",30,26,"Shake Is Testy",false),
            HomeItemModel(0,R.drawable.shnakes,"Shnakes",36,62,"Shanakes Is Testy",false),
            HomeItemModel(0,R.drawable.bergger,"Bergger",25,44,"Burger Is Testy",false),
            HomeItemModel(0,R.drawable.dosa,"Dosa",15,45,"Dosa Is Testy",false),
            HomeItemModel(0,R.drawable.pakodi,"Pakodi",20,55,"Pakodi Is Testy",false),
            HomeItemModel(0,R.drawable.lichicipizza,"Pizza",220,561,"Pizza Is Testy",false)
        ))

    }

}