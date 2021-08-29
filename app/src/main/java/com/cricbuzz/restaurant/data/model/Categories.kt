package com.cricbuzz.restaurant.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
/**
 * Created by Sunilkumar V on 29/08/21.
 */
@Entity(tableName = "categories")
data class Categories(

    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val restaurantId: Long?,
    val name: String?
)
