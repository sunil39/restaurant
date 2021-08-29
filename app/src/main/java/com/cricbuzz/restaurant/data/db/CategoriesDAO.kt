package com.cricbuzz.restaurant.data.db

import androidx.room.*
import com.cricbuzz.restaurant.data.model.*
import kotlinx.coroutines.flow.Flow
/**
 * Created by Sunilkumar V on 29/08/21.
 * Data access object for database operation related to categories
 */
@Dao
interface CategoriesDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(categories: Categories): Long

    @Query("SELECT * FROM categories")
    fun get(): Flow<List<Categories>>

}