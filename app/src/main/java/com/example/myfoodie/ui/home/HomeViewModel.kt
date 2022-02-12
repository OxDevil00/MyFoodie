package com.example.myfoodie.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.myfoodie.data.home.HomeItemModel
import com.example.myfoodie.data.home.HomeItemRepository
import com.example.myfoodie.data.myCart.MyCartModel
import com.example.myfoodie.data.myCart.MyCartRepository
import com.example.myfoodie.data.myCart.MyCartRoodDB

class HomeViewModel(application: Application) : AndroidViewModel(application){

    private val myCartDao = MyCartRoodDB.getMyCartRoodDB(application).myCartDao()
    private val myCartRepository = MyCartRepository(myCartDao)

    suspend fun insertCartItem(myCartModel: MyCartModel){
        myCartRepository.insertCartItem(myCartModel)
    }

    private val homeItemRepository = HomeItemRepository()

    val homeItemList : LiveData<List<HomeItemModel>> = homeItemRepository._homeItemList

}