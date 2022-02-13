package com.example.myfoodie.ui.myCart

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.myfoodie.data.myCart.MyCartModel
import com.example.myfoodie.data.myCart.MyCartRepository
import com.example.myfoodie.data.myCart.MyCartRoomDB

class MyCartViewModel(application: Application) : AndroidViewModel(application) {

    private val myCartDao = MyCartRoomDB.getMyCartRoodDB(application).myCartDao()
    private val myCartRepository = MyCartRepository(myCartDao)

    val myCartLiveList = myCartRepository.myCartListLive

    suspend fun insertCartItem(myCartModel: MyCartModel){
        myCartRepository.insertCartItem(myCartModel)
    }
    suspend fun deleteCartItem(myCartModel: MyCartModel){
        myCartRepository.deleteCartItem(myCartModel)
    }
    suspend fun updateCartItem(myCartModel: MyCartModel){
        myCartRepository.updateCartItem(myCartModel)
    }


}