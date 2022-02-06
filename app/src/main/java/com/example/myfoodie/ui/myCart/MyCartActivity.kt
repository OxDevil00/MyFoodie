package com.example.myfoodie.ui.myCart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myfoodie.R
import com.example.myfoodie.data.myCart.MyCartRoodDB
import kotlinx.android.synthetic.main.activity_my_cart.*

class MyCartActivity : AppCompatActivity() {
    lateinit var myCartRoodDB: MyCartRoodDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_cart)

        myCartRoodDB = MyCartRoodDB.getMyCartRoodDB(this)

        val myCartViewModel = ViewModelProvider(this)[MyCartViewModel::class.java]

        myCartViewModel.myCartLiveList.observe(this){
            my_cart_rec.layoutManager = LinearLayoutManager(this)
            my_cart_rec.adapter = MyCartAdapter(it)
        }

    }
}