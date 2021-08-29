package com.cricbuzz.restaurant.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.cricbuzz.restaurant.data.model.*
/**
 * Created by Sunilkumar V on 29/08/21.
 * Data access object for doing database operations related to MenuItems
 */
@Dao
interface MenuItemsDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(menuItems: MenuItems)

    @Query("SELECT * FROM menuItems WHERE categoryId IN (SELECT id FROM categories WHERE restaurantId=:restaurantId)")
    fun get(restaurantId: Int): LiveData<List<MenuItems>>

}