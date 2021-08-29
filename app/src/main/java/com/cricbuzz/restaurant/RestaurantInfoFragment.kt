package com.cricbuzz.restaurant

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.cricbuzz.restaurant.data.util.Constants
import com.cricbuzz.restaurant.databinding.FragmentRestaurantInfoBinding
import com.cricbuzz.restaurant.presentation.adapter.RestaurantPagerAdapter
import com.cricbuzz.restaurant.presentation.viewmodel.RestaurantViewModel
import com.google.android.material.tabs.TabLayoutMediator

/**
 * Created by Sunilkumar V on 29/08/21.
 * This fragment created for displaying all details of a restaurants like menu's, reviews and operating hours
 */
class RestaurantInfoFragment : Fragment() {
    private lateinit var fragmentRestaurantInfoBinding: FragmentRestaurantInfoBinding
    private lateinit var viewModel: RestaurantViewModel
    private lateinit var restaurantPagerAdapter: RestaurantPagerAdapter
    private lateinit var args: RestaurantInfoFragmentArgs
    private val tabs = arrayOf(
        Constants.Menus.toString(),
        Constants.Details.toString(),
        Constants.Reviews.toString()
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentRestaurantInfoBinding = FragmentRestaurantInfoBinding.inflate(layoutInflater)
        return fragmentRestaurantInfoBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        args = RestaurantInfoFragmentArgs.fromBundle(requireArguments())
        fragmentRestaurantInfoBinding.backBtn.setOnClickListener { requireActivity().onBackPressed() }
        initAdapter()
        loadInfo()
        initFragmentInfo()
    }

    private fun initAdapter() {
        val bundle = Bundle()
        bundle.putInt(Constants.RESTAURANT_ID.toString(), args.restaurantId)
        val fragmentList = arrayListOf(
            FragmentMenu.newInstance(bundle),
            FragmentDetails.newInstance(bundle),
            FragmentReview.newInstance(bundle)
        )
        restaurantPagerAdapter = RestaurantPagerAdapter(requireActivity(), fragmentList)
    }

    private fun loadInfo() {
        viewModel.getRestaurantDetails(args.restaurantId).observe(viewLifecycleOwner, {
            fragmentRestaurantInfoBinding.restaurant = it
            Glide.with(requireContext()).load(it.photograph)
                .into(fragmentRestaurantInfoBinding.logoImage)
        })
    }

    private fun initFragmentInfo() {
        fragmentRestaurantInfoBinding.tabLayout
        fragmentRestaurantInfoBinding.viewPager.adapter = restaurantPagerAdapter
        fragmentRestaurantInfoBinding.viewPager.offscreenPageLimit = 3
        TabLayoutMediator(
            fragmentRestaurantInfoBinding.tabLayout,
            fragmentRestaurantInfoBinding.viewPager,
            true
        ) { tab, position -> tab.text = tabs[position] }.attach()
    }
}







