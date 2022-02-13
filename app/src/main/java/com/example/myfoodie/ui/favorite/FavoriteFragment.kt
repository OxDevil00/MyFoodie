package com.example.myfoodie.ui.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myfoodie.R
import com.example.myfoodie.data.favorite.FavoriteItemModel
import com.example.myfoodie.data.myCart.MyCartModel
import com.example.myfoodie.databinding.FragmentFavoriteBinding
import com.example.myfoodie.databinding.FragmentHomeBinding
import com.example.myfoodie.ui.myCart.MyCartViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FavoriteFragment : Fragment(),FavoriteListener {
    private var _binding : FragmentFavoriteBinding? = null
    private val binding get() = _binding!!
    lateinit var favoriteViewModel: FavoriteViewModel
    lateinit var cartViewModel: MyCartViewModel
    lateinit var favoriteAdapter: FavoriteAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentFavoriteBinding.inflate(inflater,container,false)
        val view = binding.root
        favoriteViewModel = ViewModelProvider(this)[FavoriteViewModel::class.java]
        cartViewModel = ViewModelProvider(this)[MyCartViewModel::class.java]
        favoriteAdapter = FavoriteAdapter(this)

        favoriteViewModel.favoriteItemList.observe(viewLifecycleOwner){
            if (it == null){
                binding.emptyListTxt.visibility = View.VISIBLE
            }
            favoriteAdapter.submitList(it)
            binding.favoriteRec.layoutManager = LinearLayoutManager(activity)
            binding.favoriteRec.adapter = favoriteAdapter


        }

        return view
    }

    @OptIn(DelicateCoroutinesApi::class)
    override fun onHeartBtnClicked(favoriteItemModel: FavoriteItemModel) {
        GlobalScope.launch(Dispatchers.IO){
        favoriteViewModel.deleteFavoriteItem(favoriteItemModel)
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    override fun onAddToCartClicked(favoriteItemModel: FavoriteItemModel) {
        val cartItemModel = MyCartModel(
            0,
            favoriteItemModel.food_pic,
            favoriteItemModel.food_name,
            favoriteItemModel.food_price,
            favoriteItemModel.food_description,
            1,
            favoriteItemModel.food_price
        )
        GlobalScope.launch(Dispatchers.IO){
            cartViewModel.insertCartItem(cartItemModel)
        }
    }

}