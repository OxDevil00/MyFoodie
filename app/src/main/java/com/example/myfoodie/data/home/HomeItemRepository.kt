package com.example.myfoodie.data.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myfoodie.R
import com.example.myfoodie.data.myCart.MyCartModel
import java.util.ArrayList

class HomeItemRepository(private val homeDao: HomeDao) {

    val myHomeItemList : LiveData<List<HomeItemModel>> = homeDao.getHomeItemList()

    suspend fun insertHomeItem(homeItemModel: HomeItemModel){
        homeDao.insertHomeItem(homeItemModel)
    }

    suspend fun updateHomeItem(homeItemModel: HomeItemModel){
        homeDao.updateHomeItem(homeItemModel)
    }

    suspend fun deleteHomeItem(homeItemModel: HomeItemModel){
        homeDao.deleteHomeItem(homeItemModel)
    }


}