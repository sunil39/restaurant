package com.cricbuzz.restaurant

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.cricbuzz.restaurant.data.util.Constants
import com.cricbuzz.restaurant.databinding.FragmentMenuBinding
import com.cricbuzz.restaurant.presentation.adapter.MenuAdapter
import com.cricbuzz.restaurant.presentation.viewmodel.RestaurantViewModel

class FragmentMenu : Fragment() {
    private lateinit var viewModel: RestaurantViewModel
    private lateinit var menuAdapter: MenuAdapter
    private lateinit var fragmentMenuBinding: FragmentMenuBinding

    companion object {
        fun newInstance(bundle: Bundle): FragmentMenu {
            val fragment = FragmentMenu()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentMenuBinding = FragmentMenuBinding.inflate(layoutInflater)
        return fragmentMenuBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        menuAdapter = (activity as MainActivity).menuAdapter
        menuAdapter.setOnItemClickListener {

        }
        initRecyclerView()
        viewRestaurantList()
    }

    private fun viewRestaurantList() {
        viewModel.getMenuItems(requireArguments().getInt(Constants.RESTAURANT_ID.toString()))
            .observe(viewLifecycleOwner, {
                menuAdapter.differ.submitList(it)
            })
    }

    private fun initRecyclerView() {
        fragmentMenuBinding.menus.apply {
            adapter = menuAdapter
            layoutManager = LinearLayoutManager(activity)
        }

    }
}