package com.example.myfoodie.ui.home

import android.content.Intent
import android.graphics.drawable.Drawable
import android.opengl.Visibility
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.graphics.toColor
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myfoodie.R
import com.example.myfoodie.data.home.HomeItemModel
import com.example.myfoodie.ui.myCart.MyCartActivity
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.home_food_item_view.*
import kotlinx.android.synthetic.main.home_food_item_view.view.*

class HomeFragment : Fragment(), HomeItemListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val root: View = inflater.inflate(R.layout.fragment_home, container, false)

        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

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
        Toast.makeText(activity,homeItemModel.food_name + " added To Cart",Toast.LENGTH_LONG).show()
    }

    override fun onLikeBtnClicked(homeItemModel: HomeItemModel) {

        var isLiked = homeItemModel.food_isLiked


    }

    override fun onDestroyView() {
        super.onDestroyView()


    }

}