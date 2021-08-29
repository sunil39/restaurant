package com.cricbuzz.restaurant.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.cricbuzz.restaurant.data.model.*
/**
 * Created by Sunilkumar V on 29/08/21.
 * Data access object for doing database operations related to restaurants
 */
@Dao
interface RestaurantDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(restaurant: Restaurant): Long

    @Query("SELECT * FROM restaurant")
    fun getRestaurant(): LiveData<List<Restaurant>>

    @Query("SELECT * FROM restaurant WHERE name LIKE:searchQuery OR cuisineType LIKE:searchQuery OR id IN (SELECT restaurantId FROM categories WHERE id IN (SELECT categoryId FROM  menuItems WHERE name LIKE :searchQuery))")
    fun getSearchedRestaurant(searchQuery: String): LiveData<List<Restaurant>>

    @Query("SELECT * FROM restaurant WHERE id=:id")
    fun getRestaurantDetails(id: Int): LiveData<Restaurant>

}