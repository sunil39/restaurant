package com.cricbuzz.restaurant.data.db

import androidx.room.*
import com.cricbuzz.restaurant.data.model.*
import kotlinx.coroutines.flow.Flow
/**
 * Created by Sunilkumar V on 29/08/21.
 * Data access object for doing database operations related to latitude and longitude
 */
@Dao
interface LatitudeLongitudeDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(latitudeLongitude: LatitudeLongitude)

    @Query("SELECT * FROM latitudeLongitude")
    fun get(): Flow<List<LatitudeLongitude>>

}