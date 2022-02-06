package com.example.myfoodie.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myfoodie.R
import com.example.myfoodie.data.home.HomeItemModel
import com.example.myfoodie.data.myCart.MyCartModel
import com.example.myfoodie.ui.myCart.MyCartActivity
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.home_food_item_view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeFragment : Fragment(), HomeItemListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val root: View = inflater.inflate(R.layout.fragment_home, container, false)
        val homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        homeViewModel.homeItemList.observe(viewLifecycleOwner) {
            val list =  it
            root.home_item_rec.layoutManager = LinearLayoutManager(activity)
            root.home_item_rec.adapter = HomeAdapter(list,this)
        }
        root.home_cart_icon.setOnClickListener {
            startActivity(Intent(root.context,MyCartActivity::class.java))
        }

        return root
    }

    override fun onAddCartClicked(homeItemModel: HomeItemModel){
        val homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        val myCartItem = MyCartModel(
            0,homeItemModel.food_pic,homeItemModel.food_name,homeItemModel.food_price,"This Is Very Resty",
            1,homeItemModel.food_price)
        GlobalScope.launch(Dispatchers.IO){
            homeViewModel.insertCartItem(myCartItem)
        }
        Toast.makeText(activity,homeItemModel.food_name + " added To Cart",Toast.LENGTH_SHORT).show()
    }

    override fun onLikeBtnClicked(homeItemModel: HomeItemModel) {
        var isLiked = homeItemModel.food_isLiked // initially isLiked is false
        if(isLiked){
            home_item_like_btn.setImageResource(R.drawable.ic_baseline_un_favorite_btn_24)
            Toast.makeText(activity,"Un Liked",Toast.LENGTH_SHORT).show()
        }else{
            home_item_like_btn.setImageResource(R.drawable.ic_baseline_favorite_btn_24)
            Toast.makeText(activity,"Liked",Toast.LENGTH_SHORT).show()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()


    }

}