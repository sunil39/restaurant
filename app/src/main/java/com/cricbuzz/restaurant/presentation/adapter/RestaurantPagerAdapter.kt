package com.cricbuzz.restaurant.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
/**
 * Created by Sunilkumar V on 29/08/21.
 * FragmentStateAdapter class for viewPager2
 */
class RestaurantPagerAdapter(
    activity: FragmentActivity,
    private var fragments: List<Fragment>
) : FragmentStateAdapter(activity) {

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

    override fun getItemCount(): Int {
        return fragments.size
    }
}
