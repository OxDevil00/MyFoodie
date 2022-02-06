package com.example.myfoodie.ui.myCart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myfoodie.R
import com.example.myfoodie.data.myCart.MyCartModel
import java.util.ArrayList

class MyCartAdapter(private val list : List<MyCartModel>,private val myCartItemListener: MyCartItemListener ) : RecyclerView.Adapter<MyCartAdapter.MyCartViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyCartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.my_cart_item,parent,false)

        return MyCartViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyCartViewHolder, position: Int) {
        val currentItem = list[position]

        holder.food_pic.setImageResource(currentItem.foodImage)
        holder.food_name.text = currentItem.foodName.toString()
        holder.food_description.text = currentItem.foodDescription.toString()
        holder.food_price.text = currentItem.foodPrice.toString()
        holder.food_num_of_pieces.text = currentItem.foodNumPieces.toString()

        holder.food_item_delete_btn.setOnClickListener {
            myCartItemListener.onDeleteBtnClicked(currentItem)
        }

    }

    inner class MyCartViewHolder(viewItem : View):RecyclerView.ViewHolder(viewItem)  {

        val food_pic : ImageView = viewItem.findViewById(R.id.my_cart_food_img)
        val food_name : TextView = viewItem.findViewById(R.id.my_cart_food_name)
        val food_description : TextView = viewItem.findViewById(R.id.my_cart_food_description)
        val food_price : TextView = viewItem.findViewById(R.id.my_cart_food_price)
        val food_num_of_pieces : TextView = viewItem.findViewById(R.id.my_cart_food_count)
        val food_item_min_btn : ImageView = viewItem.findViewById(R.id.my_cart_food_min_btn)
        val food_item_plus_btn : ImageView = viewItem.findViewById(R.id.my_cart_food_plus_btn)
        val food_item_delete_btn : ImageView = viewItem.findViewById(R.id.my_cart_cross_btn)

    }

}

interface MyCartItemListener{
    fun onDeleteBtnClicked(myCartModel: MyCartModel)
}