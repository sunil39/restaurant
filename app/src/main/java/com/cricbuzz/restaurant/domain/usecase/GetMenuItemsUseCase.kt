package com.cricbuzz.restaurant.domain.usecase

import androidx.lifecycle.LiveData
import com.cricbuzz.restaurant.data.model.MenuItems
import com.cricbuzz.restaurant.domain.repository.RestaurantRepository
/**
 * Created by Sunilkumar V on 29/08/21.
 */
class GetMenuItemsUseCase(private val restaurantRepository: RestaurantRepository) {

    fun execute(id: Int): LiveData<List<MenuItems>> {
        return restaurantRepository.getMenuItems(id)
    }
}