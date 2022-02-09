package com.example.myfoodie.ui.myCart

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myfoodie.R
import com.example.myfoodie.data.myCart.MyCartModel
import com.example.myfoodie.data.myCart.MyCartRepository
import com.example.myfoodie.data.myCart.MyCartRoodDB
import java.util.ArrayList

class MyCartViewModel(application: Application) : AndroidViewModel(application) {

    val myCartDao = MyCartRoodDB.getMyCartRoodDB(application).myCartDao()
    val myCartRepository = MyCartRepository(myCartDao)

    val myCartLiveList = myCartRepository.myCartListLive

    suspend fun deleteCartItem(myCartModel: MyCartModel){
        myCartRepository.deleteCartItem(myCartModel)
    }
    suspend fun updateCartItem(myCartModel: MyCartModel){
        myCartRepository.updateCartItem(myCartModel)
    }


}