package com.cricbuzz.restaurant.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
/**
 * Created by Sunilkumar V on 29/08/21.
 */
@Entity(
    tableName = "operatingHours",
    foreignKeys = [ForeignKey(
        entity = Restaurant::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("restaurantId"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class OperatingHours(

    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo(index = true)
    val restaurantId: Long,
    val monday: String?,
    val tuesday: String?,
    val wednesday: String?,
    val thursday: String?,
    val friday: String?,
    val saturday: String?,
    val sunday: String?

)