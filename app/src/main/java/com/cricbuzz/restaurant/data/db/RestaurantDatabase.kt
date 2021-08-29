package com.cricbuzz.restaurant.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cricbuzz.restaurant.data.model.*
/**
 * Created by Sunilkumar V on 29/08/21.
 * Room database instance class for doing database operations related to this restaurants project
 */
@Database(
    entities = [Restaurant::class,
        Categories::class,
        LatitudeLongitude::class,
        MenuItems::class,
        OperatingHours::class,
        Review::class],
    version = 2,
    exportSchema = false
)

abstract class RestaurantDatabase : RoomDatabase() {

    abstract fun getRestaurantDAO(): RestaurantDAO
    abstract fun getCategoryDAO(): CategoriesDAO
    abstract fun getLatitudeLongitude(): LatitudeLongitudeDAO
    abstract fun getMenuItemDao(): MenuItemsDAO
    abstract fun getOperatingHoursDAO(): OperatingHoursDAO
    abstract fun getReviewDAO(): ReviewDAO

}

