package com.example.myfoodie.ui.myCart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myfoodie.R
import com.example.myfoodie.data.myCart.MyCartModel
import com.example.myfoodie.data.myCart.MyCartRoodDB
import com.example.myfoodie.databinding.ActivityMyCartBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MyCartActivity : AppCompatActivity(),MyCartItemListener {
    private lateinit var binding : ActivityMyCartBinding
    lateinit var myCartRoodDB: MyCartRoodDB
    lateinit var myCartViewModel : MyCartViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyCartBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        myCartRoodDB = MyCartRoodDB.getMyCartRoodDB(this)

        myCartViewModel = ViewModelProvider(this)[MyCartViewModel::class.java]

        myCartViewModel.myCartLiveList.observe(this){
            binding.myCartRec.layoutManager = LinearLayoutManager(this)
            binding.myCartRec.adapter = MyCartAdapter(it,this)
        }

    }

    override fun onDeleteBtnClicked(myCartModel: MyCartModel) {
        GlobalScope.launch(Dispatchers.IO){
            myCartViewModel.deleteCartItem(myCartModel)
            GlobalScope.launch(Dispatchers.Main){
                Toast.makeText(this@MyCartActivity, "${myCartModel.foodName} Deleted To Cart", Toast.LENGTH_SHORT).show()
            }
        }
    }
}