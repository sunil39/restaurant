package com.cricbuzz.restaurant.domain.repository

import androidx.lifecycle.LiveData
import com.cricbuzz.restaurant.data.model.MenuItems
import com.cricbuzz.restaurant.data.model.OperatingHours
import com.cricbuzz.restaurant.data.model.Restaurant
import com.cricbuzz.restaurant.data.model.Review
/**
 * Created by Sunilkumar V on 29/08/21.
 */
interface RestaurantRepository {

    fun getSearchedRestaurant(searchQuery: String): LiveData<List<Restaurant>>
    fun getRestaurant(): LiveData<List<Restaurant>>
    fun getRestaurantDetails(id: Int): LiveData<Restaurant>
    fun getMenuItems(id: Int): LiveData<List<MenuItems>>
    fun getReview(id: Int): LiveData<List<Review>>
    fun getOperatingHour(id: Int): LiveData<OperatingHours>
    suspend fun resourceToDb()

}