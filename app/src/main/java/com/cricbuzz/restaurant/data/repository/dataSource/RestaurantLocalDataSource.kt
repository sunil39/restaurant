package com.cricbuzz.restaurant.data.repository.dataSource

import androidx.lifecycle.LiveData
import com.cricbuzz.restaurant.data.model.*
/**
 * Created by Sunilkumar V on 29/08/21.
 */
interface RestaurantLocalDataSource {

    fun getSearchedRestaurant(searchQuery: String): LiveData<List<Restaurant>>
    fun getRestaurant(): LiveData<List<Restaurant>>
    fun getRestaurantDetails(id: Int): LiveData<Restaurant>
    fun getMenuItems(id: Int): LiveData<List<MenuItems>>
    fun getReview(id: Int): LiveData<List<Review>>
    fun getOperatingHour(id: Int): LiveData<OperatingHours>
    suspend fun saveCategory(categories: Categories): Long
    suspend fun saveLatitudeLongitude(latitudeLongitude: LatitudeLongitude)
    suspend fun saveMenuItem(menuItems: MenuItems)
    suspend fun saveOperatingHour(operatingHours: OperatingHours)
    suspend fun saveRestaurant(restaurant: Restaurant): Long
    suspend fun saveReview(review: Review)

}