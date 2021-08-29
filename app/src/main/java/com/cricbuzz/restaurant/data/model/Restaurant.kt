package com.cricbuzz.restaurant.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
/**
 * Created by Sunilkumar V on 29/08/21.
 */
@Entity(tableName = "restaurant")
data class Restaurant(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val name: String?,
    val neighborhood: String?,
    val photograph: String?,
    val address: String?,
    val cuisineType: String?
) : Serializable