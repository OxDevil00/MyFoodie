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
import com.example.myfoodie.data.home.HomeItemModel
import com.example.myfoodie.data.myCart.MyCartModel
import com.example.myfoodie.databinding.FragmentHomeBinding
import com.example.myfoodie.ui.myCart.MyCartActivity
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeFragment : Fragment(), HomeItemListener {

    private var _binding: FragmentHomeBinding? = null // This property is only valid between onCreateView and onDestroyView.

    private val binding get() = _binding!!
    lateinit var homeViewModel : HomeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        homeViewModel.homeItemList.observe(viewLifecycleOwner) {
            binding.homeItemRec.layoutManager = LinearLayoutManager(activity)
            binding.homeItemRec.adapter = HomeAdapter(it,this)

        }
        binding.homeCartIcon.setOnClickListener {
         startActivity(Intent(activity,MyCartActivity::class.java))
        }

        return view
    }

    @OptIn(DelicateCoroutinesApi::class)
    override fun onPlaceOrderClicked(homeItemModel: HomeItemModel) {
        GlobalScope.launch(Dispatchers.IO) {
            homeViewModel.insertCartItem(
                MyCartModel(
                    0,
                    homeItemModel.food_pic,
                    homeItemModel.food_name,
                    homeItemModel.food_price,
                    "This Is Very Resty",
                    1,
                    homeItemModel.food_price
                )
            )
            GlobalScope.launch(Dispatchers.Main){
                activity?.startActivity(Intent(activity,MyCartActivity::class.java))
            }
        }
    }

    override fun onLikeBtnClicked(homeItemModel: HomeItemModel) {
        Toast.makeText(activity,"Not Implemented now",Toast.LENGTH_SHORT).show()
    }

    override fun onMinusBtnClicked(homeItemModel: HomeItemModel) {
        Toast.makeText(activity,"Not Implemented now",Toast.LENGTH_SHORT).show()
    }

    override fun onPlusBtnClicked(homeItemModel: HomeItemModel) {
        Toast.makeText(activity,"Not Implemented now",Toast.LENGTH_SHORT).show()
    }
}