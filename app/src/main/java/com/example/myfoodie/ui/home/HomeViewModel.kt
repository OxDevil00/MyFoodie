package com.example.myfoodie.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myfoodie.R
import com.example.myfoodie.data.home.HomeItemModel
import com.example.myfoodie.data.home.HomeItemRepository
import com.example.myfoodie.data.myCart.MyCartModel
import com.example.myfoodie.data.myCart.MyCartRepository
import com.example.myfoodie.data.myCart.MyCartRoodDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.ArrayList

class HomeViewModel(application: Application) : AndroidViewModel(application){

    val myCartDao = MyCartRoodDB.getMyCartRoodDB(application).myCartDao()
    val myCartRepository = MyCartRepository(myCartDao)

    suspend fun insertCartItem(myCartModel: MyCartModel){
        myCartRepository.insertCartItem(myCartModel)
    }

    val homeItemRepository = HomeItemRepository()
    val homeItemList : LiveData<List<HomeItemModel>> = homeItemRepository._homeItemList


}