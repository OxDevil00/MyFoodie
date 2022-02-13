package com.example.myfoodie.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.myfoodie.data.favorite.FavoriteItemModel
import com.example.myfoodie.data.favorite.FavoriteRepository
import com.example.myfoodie.data.favorite.FavoriteRoomDB
import com.example.myfoodie.data.home.HomeItemModel
import com.example.myfoodie.data.home.HomeItemRepository
import com.example.myfoodie.data.myCart.MyCartModel
import com.example.myfoodie.data.myCart.MyCartRepository
import com.example.myfoodie.data.myCart.MyCartRoomDB

class HomeViewModel(application: Application) : AndroidViewModel(application){

    private val homeItemRepository = HomeItemRepository()
    val homeItemList : LiveData<List<HomeItemModel>> = homeItemRepository._homeItemList

    //work for cart
    private val myCartDao = MyCartRoomDB.getMyCartRoodDB(application).myCartDao()

    private val myCartRepository = MyCartRepository(myCartDao)

    suspend fun insertCartItem(myCartModel: MyCartModel){
        myCartRepository.insertCartItem(myCartModel)
    }

    //work for favorite


}