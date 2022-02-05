package com.example.myfoodie.ui.myCart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myfoodie.R
import com.example.myfoodie.ui.home.HomeViewModel
import kotlinx.android.synthetic.main.activity_my_cart.*

class MyCartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_cart)

        val myCartViewModel = ViewModelProvider(this).get(MyCartViewModel::class.java)

        myCartViewModel.myCartLiveList.observe(this){
            my_cart_rec.layoutManager = LinearLayoutManager(this)
            my_cart_rec.adapter = MyCartAdapter(it)
        }

    }
}