package com.example.myfoodie.ui.favorite

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
import com.example.myfoodie.ui.myCart.MyCartViewModel

class FavoriteViewModel(application: Application) : AndroidViewModel(application){

    private val favoriteDao = FavoriteRoomDB.getFavoriteRoomDB(application).getFavoriteDao()
    private val favoriteRepository =  FavoriteRepository(favoriteDao)

    val favoriteItemList : LiveData<List<FavoriteItemModel>> = favoriteRepository.favoriteItemList

    suspend fun insertFavoriteItem(favoriteItemModel: FavoriteItemModel){
        favoriteRepository.insertFavoriteItem(favoriteItemModel)
    }
    suspend fun updateFavoriteItem(favoriteItemModel: FavoriteItemModel){
        favoriteRepository.updateFavoriteItem(favoriteItemModel)
    }

    suspend fun deleteFavoriteItem(favoriteItemModel: FavoriteItemModel){
        favoriteRepository.deleteFavoriteItem(favoriteItemModel)
    }

    //work for cart
    val myCartViewModel = MyCartViewModel(application)



}