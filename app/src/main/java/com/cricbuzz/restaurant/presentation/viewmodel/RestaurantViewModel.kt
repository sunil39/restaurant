package com.cricbuzz.restaurant.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.cricbuzz.restaurant.data.model.MenuItems
import com.cricbuzz.restaurant.data.model.OperatingHours
import com.cricbuzz.restaurant.data.model.Restaurant
import com.cricbuzz.restaurant.data.model.Review
import com.cricbuzz.restaurant.domain.usecase.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
/**
 * Created by Sunilkumar V on 29/08/21.
 * This viewModel class created for doing all operations related to restaurants
 */
class RestaurantViewModel(
    app: Application,
    private val getSearchedRestaurantUseCase: GetSearchedRestaurantUseCase,
    private val getRestaurantUseCase: GetRestaurantUseCase,
    private val resourceToDbUseCase: ResourceToDbUseCase,
    private val getRestaurantDetailsUseCase: GetRestaurantDetailsUseCase,
    private val getMenuItemsUseCase: GetMenuItemsUseCase,
    private val getReviewUseCase: GetReviewUseCase,
    private val getOperatingHourUseCase: GetOperatingHourUseCase
) : AndroidViewModel(app) {

    fun getRestaurant(): LiveData<List<Restaurant>> {
        return getRestaurantUseCase.execute()
    }

    fun getSearchedRestaurant(searchQuery: String): LiveData<List<Restaurant>> {
        return getSearchedRestaurantUseCase.execute(searchQuery)
    }

    fun resourceToDb() = viewModelScope.launch(Dispatchers.IO) {
        resourceToDbUseCase.execute()
    }

    fun getRestaurantDetails(id: Int): LiveData<Restaurant> {
        return getRestaurantDetailsUseCase.execute(id)
    }

    fun getMenuItems(id: Int): LiveData<List<MenuItems>> {
        return getMenuItemsUseCase.execute(id)
    }

    fun getReview(id: Int): LiveData<List<Review>> {
        return getReviewUseCase.execute(id)
    }

    fun getOperatingHours(id: Int): LiveData<OperatingHours> {
        return getOperatingHourUseCase.execute(id)
    }

}














