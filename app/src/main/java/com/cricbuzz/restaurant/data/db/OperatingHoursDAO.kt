package com.cricbuzz.restaurant.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.cricbuzz.restaurant.data.model.*
/**
 * Created by Sunilkumar V on 29/08/21.
 * Data access object for doing database operations related to OperatingHours
 */
@Dao
interface OperatingHoursDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(operatingHours: OperatingHours)

    @Query("SELECT * FROM operatingHours WHERE restaurantId=:restaurantId")
    fun get(restaurantId: Int): LiveData<OperatingHours>

}