package com.cricbuzz.restaurant.domain.usecase

import androidx.lifecycle.LiveData
import com.cricbuzz.restaurant.data.model.Restaurant
import com.cricbuzz.restaurant.domain.repository.RestaurantRepository
/**
 * Created by Sunilkumar V on 29/08/21.
 */
class GetSearchedRestaurantUseCase(private val restaurantRepository: RestaurantRepository) {

    fun execute(searchQuery: String): LiveData<List<Restaurant>> {
        return restaurantRepository.getSearchedRestaurant("%$searchQuery%")
    }
}