package com.cricbuzz.restaurant.data.repository.dataSourceImpl

import androidx.lifecycle.LiveData
import com.cricbuzz.restaurant.data.db.*
import com.cricbuzz.restaurant.data.model.*
import com.cricbuzz.restaurant.data.repository.dataSource.RestaurantLocalDataSource
/**
 * Created by Sunilkumar V on 29/08/21.
 */
class RestaurantLocalDataSourceImpl(
    private val restaurantDAO: RestaurantDAO,
    private val categoriesDAO: CategoriesDAO,
    private val latitudeLongitudeDAO: LatitudeLongitudeDAO,
    private val menuItemsDAO: MenuItemsDAO,
    private val operatingHoursDAO: OperatingHoursDAO,
    private val reviewDAO: ReviewDAO
) : RestaurantLocalDataSource {

    override fun getSearchedRestaurant(searchQuery: String): LiveData<List<Restaurant>> {
        return restaurantDAO.getSearchedRestaurant(searchQuery)
    }

    override fun getRestaurant(): LiveData<List<Restaurant>> {
        return restaurantDAO.getRestaurant()
    }

    override fun getRestaurantDetails(id: Int): LiveData<Restaurant> {
        return restaurantDAO.getRestaurantDetails(id)
    }

    override fun getMenuItems(id: Int): LiveData<List<MenuItems>> {
        return menuItemsDAO.get(id)
    }

    override fun getReview(id: Int): LiveData<List<Review>> {
        return reviewDAO.get(id)
    }

    override fun getOperatingHour(id: Int): LiveData<OperatingHours> {
        return operatingHoursDAO.get(id)
    }

    override suspend fun saveCategory(categories: Categories): Long {
        return categoriesDAO.insert(categories)
    }

    override suspend fun saveLatitudeLongitude(latitudeLongitude: LatitudeLongitude) {
        latitudeLongitudeDAO.insert(latitudeLongitude)
    }

    override suspend fun saveMenuItem(menuItems: MenuItems) {
        menuItemsDAO.insert(menuItems)
    }

    override suspend fun saveOperatingHour(operatingHours: OperatingHours) {
        operatingHoursDAO.insert(operatingHours)
    }

    override suspend fun saveRestaurant(restaurant: Restaurant): Long {
        return restaurantDAO.insert(restaurant)
    }

    override suspend fun saveReview(review: Review) {
        reviewDAO.insert(review)
    }

}