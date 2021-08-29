package com.cricbuzz.restaurant.presentation.di

import com.cricbuzz.restaurant.data.repository.RestaurantRepositoryImpl
import com.cricbuzz.restaurant.data.repository.dataSource.RestaurantLocalDataSource
import com.cricbuzz.restaurant.domain.repository.RestaurantRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
/**
 * Created by Sunilkumar V on 29/08/21.
 * This class created for Injecting all repository classes into Hilt
 */
@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideRestaurantRepository(restaurantLocalDataSource: RestaurantLocalDataSource): RestaurantRepository {
        return RestaurantRepositoryImpl(restaurantLocalDataSource)
    }

}














