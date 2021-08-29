package com.cricbuzz.restaurant.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
/**
 * Created by Sunilkumar V on 29/08/21.
 */
@Entity(
    tableName = "menuItems",
    foreignKeys = [ForeignKey(
        entity = Categories::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("categoryId"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class MenuItems(

    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo(index = true)
    val categoryId: Long?,
    val name: String?,
    val description: String?,
    val price: Float?,
    val image: String?

)
