package com.cricbuzz.restaurant.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cricbuzz.restaurant.domain.usecase.*
/**
 * Created by Sunilkumar V on 29/08/21.
 * ViewModel factory for restaurantsViewModel
 */
class RestaurantViewModelFactory(
    private val app: Application,
    private val getSearchedRestaurantUseCase: GetSearchedRestaurantUseCase,
    private val getRestaurantUseCase: GetRestaurantUseCase,
    private val resourceToDbUseCase: ResourceToDbUseCase,
    private val getRestaurantDetailsUseCase: GetRestaurantDetailsUseCase,
    private val getMenuItemsUseCase: GetMenuItemsUseCase,
    private val getReviewUseCase: GetReviewUseCase,
    private val getOperatingHourUseCase: GetOperatingHourUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return RestaurantViewModel(
            app,
            getSearchedRestaurantUseCase,
            getRestaurantUseCase,
            resourceToDbUseCase,
            getRestaurantDetailsUseCase,
            getMenuItemsUseCase,
            getReviewUseCase,
            getOperatingHourUseCase
        ) as T
    }
}









