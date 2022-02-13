package com.example.myfoodie.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.example.myfoodie.R
import com.example.myfoodie.data.home.HomeItemModel
import java.util.ArrayList

class HomeAdapter(private val list : List<HomeItemModel>, private val homeItemListener: HomeItemListener)
    : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

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
        holder.food_name.text = currentItem.food_name
        holder.food_price.text = currentItem.food_price.toString()
        holder.food_likes_count.text = currentItem.food_likes_count.toString()
        // holder.home_item_count.text

        holder.home_item_minus_img.setOnClickListener {
            homeItemListener.onMinusBtnClicked(currentItem)
        }
        holder.home_item_plus_img.setOnClickListener {
            homeItemListener.onPlusBtnClicked(currentItem)
        }
        holder.home_item_place_order_txt.setOnClickListener {
            homeItemListener.onPlaceOrderClicked(currentItem)
        }
        holder.food_like_btn.setOnClickListener {
            homeItemListener.onLikeBtnClicked(currentItem)
            if (currentItem.isLiked){
                holder.food_like_btn.setImageResource(R.drawable.ic_baseline_favorite_btn_24)
            }else{
                holder.food_like_btn.setImageResource(R.drawable.ic_baseline_un_favorite_btn_24)
            }
        }

    }
    inner class HomeViewHolder(viewItem : View):RecyclerView.ViewHolder(viewItem)  {
        val food_pic : ImageView = viewItem.findViewById(R.id.home_item_food_img)
        val food_name : TextView = viewItem.findViewById(R.id.home_item_food_name)
        val food_price : TextView = viewItem.findViewById(R.id.home_item_food_price)
        val food_like_btn : ImageView = viewItem.findViewById(R.id.home_item_like_btn)
        val food_likes_count : TextView = viewItem.findViewById(R.id.home_item_like_count)
        val home_item_place_order_txt : TextView = viewItem.findViewById(R.id.home_item_place_order_txt)
        val home_item_minus_img : ImageView = viewItem.findViewById(R.id.home_item_minus_img)
        val home_item_plus_img : ImageView = viewItem.findViewById(R.id.home_item_plus_img)


    }
}

interface HomeItemListener {
    fun onPlaceOrderClicked(homeItemModel: HomeItemModel)
    fun onLikeBtnClicked(homeItemModel: HomeItemModel)
    fun onMinusBtnClicked(homeItemModel: HomeItemModel)
    fun onPlusBtnClicked(homeItemModel: HomeItemModel)
}