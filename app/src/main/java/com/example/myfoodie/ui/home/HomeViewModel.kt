package com.example.myfoodie.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.myfoodie.data.favorite.FavoriteItemModel
import com.example.myfoodie.data.favorite.FavoriteRepository
import com.example.myfoodie.data.favorite.FavoriteRoomDB
import com.example.myfoodie.data.home.HomeItemModel
import com.example.myfoodie.data.home.HomeItemRepository
import com.example.myfoodie.data.home.HomeRoomDB
import com.example.myfoodie.data.myCart.MyCartModel
import com.example.myfoodie.data.myCart.MyCartRepository
import com.example.myfoodie.data.myCart.MyCartRoomDB

class HomeViewModel(application: Application) : AndroidViewModel(application){

    private val homeRoomDao = HomeRoomDB.getHomeRoomDB(application).getHomeDao()
    private val homeItemRepository = HomeItemRepository(homeRoomDao)

    val homeItemList : LiveData<List<HomeItemModel>> = homeItemRepository.myHomeItemList
    suspend fun insertHomeItem(homeItemModel: HomeItemModel){
        homeItemRepository.insertHomeItem(homeItemModel)
    }
    suspend fun updateHomeItem(homeItemModel: HomeItemModel){
        homeItemRepository.updateHomeItem(homeItemModel)
    }



    //work for cart
    private val myCartDao = MyCartRoomDB.getMyCartRoodDB(application).myCartDao()
    private val myCartRepository = MyCartRepository(myCartDao)

    suspend fun insertCartItem(myCartModel: MyCartModel){
        myCartRepository.insertCartItem(myCartModel)
    }
    val myCartListLive = myCartRepository.myCartListLive

    //work for favorite


}