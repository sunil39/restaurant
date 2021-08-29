package com.cricbuzz.restaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.cricbuzz.restaurant.presentation.adapter.MenuAdapter
import com.cricbuzz.restaurant.presentation.adapter.RestaurantAdapter
import com.cricbuzz.restaurant.presentation.adapter.ReviewAdapter
import com.cricbuzz.restaurant.presentation.viewmodel.RestaurantViewModel
import com.cricbuzz.restaurant.presentation.viewmodel.RestaurantViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
/**
 * Created by Sunilkumar V on 29/08/21.
 * In this project we are listing and filtering restaurants
 * Currently data's are loading from local
 * Created for the purpose of Technical round assignment
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: RestaurantViewModelFactory

    @Inject
    lateinit var restaurantAdapter: RestaurantAdapter

    @Inject
    lateinit var menuAdapter: MenuAdapter

    @Inject
    lateinit var reviewAdapter: ReviewAdapter
    lateinit var viewModel: RestaurantViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        DataBindingUtil.setContentView<ViewDataBinding>(this, R.layout.activity_main)

        viewModel = ViewModelProvider(this, factory).get(RestaurantViewModel::class.java)
        supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
    }
}