package com.example.myfoodie.data.myCart

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MyCartDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCartItem(cartModel: MyCartModel)

    @Delete
    suspend fun deleteCartItem(cartModel: MyCartModel)

    @Update
    suspend fun updateCartItem(cartModel: MyCartModel)

    @Query("SELECT * FROM MyCartTable ORDER BY ID ASC")
    fun getMyCartList() : LiveData<List<MyCartModel>>

}