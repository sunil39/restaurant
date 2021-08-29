package com.cricbuzz.restaurant.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
/**
 * Created by Sunilkumar V on 29/08/21.
 */
@Entity(
    tableName = "latitudeLongitude",
    foreignKeys = [ForeignKey(
        entity = Restaurant::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("restaurantId"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class LatitudeLongitude(

    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo(index = true)
    val restaurantId: Long?,
    val lat: Double?,
    val lng: Double?

)
