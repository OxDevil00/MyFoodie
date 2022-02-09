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
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MyCartActivity : AppCompatActivity(),MyCartItemListener {
    private lateinit var binding : ActivityMyCartBinding
    lateinit var myCartRoodDB: MyCartRoodDB
    lateinit var myCartViewModel : MyCartViewModel
    lateinit var myCartAdapter: MyCartAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyCartBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        myCartRoodDB = MyCartRoodDB.getMyCartRoodDB(this)

        myCartViewModel = ViewModelProvider(this)[MyCartViewModel::class.java]

        myCartViewModel.myCartLiveList.observe(this){
            myCartAdapter = MyCartAdapter(this)
            myCartAdapter.submitList(it)
            binding.myCartRec.layoutManager = LinearLayoutManager(this)
            binding.myCartRec.adapter = myCartAdapter

        }

    }

    @OptIn(DelicateCoroutinesApi::class)
    override fun onDeleteBtnClicked(myCartModel: MyCartModel) {
        GlobalScope.launch(Dispatchers.IO){
            myCartViewModel.deleteCartItem(myCartModel)
            GlobalScope.launch(Dispatchers.Main){
                Toast.makeText(this@MyCartActivity, "${myCartModel.foodName} Deleted To Cart", Toast.LENGTH_SHORT).show()
            }
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    override fun onMinusBtnClicked(myCartModel: MyCartModel) {
        if(myCartModel.foodNumPieces > 1){
            val updatedCartItem = MyCartModel(myCartModel.id,myCartModel.foodImage,myCartModel.foodName,
                myCartModel.foodPrice,myCartModel.foodDescription,myCartModel.foodNumPieces - 1,
                myCartModel.foodPrice * (myCartModel.foodNumPieces - 1))
            GlobalScope.launch(Dispatchers.IO){
                myCartViewModel.updateCartItem(updatedCartItem)
            }
        }

    }

    @OptIn(DelicateCoroutinesApi::class)
    override fun onPlusBtnClicked(myCartModel: MyCartModel) {
        val updatedCartItem = MyCartModel(myCartModel.id,myCartModel.foodImage,myCartModel.foodName,
        myCartModel.foodPrice,myCartModel.foodDescription,myCartModel.foodNumPieces + 1,
        myCartModel.foodPrice * (myCartModel.foodNumPieces + 1))
        GlobalScope.launch(Dispatchers.IO){
            myCartViewModel.updateCartItem(updatedCartItem)
        }
    }

}