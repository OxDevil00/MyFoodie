package com.example.myfoodie.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myfoodie.R
import com.example.myfoodie.data.home.HomeItemModel
import java.util.ArrayList

class HomeAdapter(private val list : ArrayList<HomeItemModel>, private val homeItemListener: HomeItemListener) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.home_food_item_view,parent,false)

        return HomeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val currentItem = list[position]
        holder.food_pic.setImageResource(currentItem.food_pic)
        holder.food_name.text = currentItem.food_name.toString()
        holder.food_price.text = currentItem.food_price.toString()
        holder.food_likes_count.text = currentItem.food_likes_count.toString()

        holder.btn_add_to_cart.setOnClickListener {
            homeItemListener.onAddCartClicked(currentItem)
        }

        holder.food_un_like_btn.setOnClickListener {
            homeItemListener.onLikeBtnClicked(currentItem)
        }
        holder.food_like_btn.setOnClickListener {
            homeItemListener.onLikeBtnClicked(currentItem)
        }


    }

    inner class HomeViewHolder(viewItem : View):RecyclerView.ViewHolder(viewItem)  {
        val food_pic : ImageView = viewItem.findViewById(R.id.home_item_food_img)
        val food_name : TextView = viewItem.findViewById(R.id.home_item_food_name)
        val food_price : TextView = viewItem.findViewById(R.id.home_item_food_price)
        val food_likes_count : TextView = viewItem.findViewById(R.id.home_item_like_count)
        val food_like_btn : ImageView = viewItem.findViewById(R.id.home_item_like_btn)
        val food_un_like_btn : ImageView = viewItem.findViewById(R.id.home_item_un_like_btn)
        val btn_add_to_cart : LinearLayout = viewItem.findViewById(R.id.home_item_btn_addCart)

    }
}

interface HomeItemListener {
    fun onAddCartClicked(homeItemModel: HomeItemModel)
    fun onLikeBtnClicked(homeItemModel: HomeItemModel)
}