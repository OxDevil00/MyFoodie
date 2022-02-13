package com.example.myfoodie.data.home

data class HomeItemModel(
    val id : Int,
    val food_pic: Int,
    val food_name: String,
    val food_price: Int,
    val food_likes_count: Int,
    val food_description : String,
    var isLiked : Boolean

)
