package com.example.myfoodie.data.myCart

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MyCartModel::class], version = 3, exportSchema = false)
abstract class MyCartRoodDB : RoomDatabase() {

    abstract fun myCartDao() : MyCartDao

    companion object{

        @Volatile
        private var instance : MyCartRoodDB? = null

        fun getMyCartRoodDB(context: Context) : MyCartRoodDB{
            if (instance == null){
                synchronized(this){
                    instance = Room.databaseBuilder(context.applicationContext
                        ,MyCartRoodDB::class.java
                        ,"MyCartDB").build()
                }
            }

            return instance!!
        }

    }

}