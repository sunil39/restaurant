package com.cricbuzz.restaurant.presentation.di

import com.cricbuzz.restaurant.data.db.*
import com.cricbuzz.restaurant.data.repository.dataSource.RestaurantLocalDataSource
import com.cricbuzz.restaurant.data.repository.dataSourceImpl.RestaurantLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
/**
 * Created by Sunilkumar V on 29/08/21.
 * This class created for Injecting Data access object classes into Hilt
 */
@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {

    @Singleton
    @Provides
    fun provideRestaurantDataSource(
        restaurantDAO: RestaurantDAO,
        categoriesDAO: CategoriesDAO,
        latitudeLongitudeDAO: LatitudeLongitudeDAO,
        menuItemsDAO: MenuItemsDAO,
        operatingHoursDAO: OperatingHoursDAO,
        reviewDAO: ReviewDAO
    ): RestaurantLocalDataSource {
        return RestaurantLocalDataSourceImpl(
            restaurantDAO,
            categoriesDAO,
            latitudeLongitudeDAO,
            menuItemsDAO,
            operatingHoursDAO,
            reviewDAO
        )
    }

}













