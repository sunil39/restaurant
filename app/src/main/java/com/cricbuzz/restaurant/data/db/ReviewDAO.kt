package com.cricbuzz.restaurant.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.cricbuzz.restaurant.data.model.*
/**
 * Created by Sunilkumar V on 29/08/21.
 * Data access object for doing database operations for reviews
 */
@Dao
interface ReviewDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(review: Review)

    @Query("SELECT * FROM review WHERE restaurantId=:restaurantId")
    fun get(restaurantId: Int): LiveData<List<Review>>
}