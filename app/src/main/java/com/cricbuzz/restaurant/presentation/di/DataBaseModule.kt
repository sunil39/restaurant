package com.cricbuzz.restaurant.presentation.di

import android.app.Application
import androidx.room.Room
import com.cricbuzz.restaurant.data.db.*
import com.cricbuzz.restaurant.data.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
/**
 * Created by Sunilkumar V on 29/08/21.
 * This class created for Injection all Data access object into database and Hilt
 */
@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {

    @Singleton
    @Provides
    fun provideRestaurantDatabase(app: Application): RestaurantDatabase {
        return Room.databaseBuilder(
            app,
            RestaurantDatabase::class.java,
            Constants.RESTAURANT_DB.toString()
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideRestaurantDao(restaurantDatabase: RestaurantDatabase): RestaurantDAO {
        return restaurantDatabase.getRestaurantDAO()
    }

    @Singleton
    @Provides
    fun provideCategoriesDao(restaurantDatabase: RestaurantDatabase): CategoriesDAO {
        return restaurantDatabase.getCategoryDAO()
    }

    @Singleton
    @Provides
    fun provideLatitudeLongitudeDao(restaurantDatabase: RestaurantDatabase): LatitudeLongitudeDAO {
        return restaurantDatabase.getLatitudeLongitude()
    }


    @Singleton
    @Provides
    fun provideMenuItemsDao(restaurantDatabase: RestaurantDatabase): MenuItemsDAO {
        return restaurantDatabase.getMenuItemDao()
    }

    @Singleton
    @Provides
    fun provideOperatingHoursDao(restaurantDatabase: RestaurantDatabase): OperatingHoursDAO {
        return restaurantDatabase.getOperatingHoursDAO()
    }

    @Singleton
    @Provides
    fun provideReviewDao(restaurantDatabase: RestaurantDatabase): ReviewDAO {
        return restaurantDatabase.getReviewDAO()
    }

}