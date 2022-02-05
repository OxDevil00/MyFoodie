package com.example.myfoodie.ui.myCart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myfoodie.R
import com.example.myfoodie.data.myCart.MyCartModel
import java.util.ArrayList

class MyCartViewModel : ViewModel() {

    val _myCartLiveList = MutableLiveData<ArrayList<MyCartModel>>().apply {
        value = ArrayList(listOf(
            MyCartModel(R.drawable.bergger,"Bergur",25,"This Is The VeryTesty",1,25),
            MyCartModel(R.drawable.sadwitch2,"sandwich",285,"1This Is The VeryTesty",15,2565),
            MyCartModel(R.drawable.sadwitch2,"sandwich",285,"1This Is The VeryTesty",15,2565),
            MyCartModel(R.drawable.sadwitch2,"sandwich",285,"1This Is The VeryTesty",15,2565),
            MyCartModel(R.drawable.bergger,"Bergur",25,"This Is The VeryTesty",1,25),
            MyCartModel(R.drawable.sadwitch2,"sandwich",285,"1This Is The VeryTesty",15,2565),
            MyCartModel(R.drawable.bergger,"Bergur",25,"This Is The VeryTesty",1,25),

        ))
    }

    val myCartLiveList : LiveData<ArrayList<MyCartModel>> = _myCartLiveList

}