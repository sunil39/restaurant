package com.cricbuzz.restaurant.presentation.di

import com.cricbuzz.restaurant.presentation.adapter.MenuAdapter
import com.cricbuzz.restaurant.presentation.adapter.RestaurantAdapter
import com.cricbuzz.restaurant.presentation.adapter.ReviewAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
/**
 * Created by Sunilkumar V on 29/08/21.
 * This class created for Injecting Adapters into Hilt
 */
@Module
@InstallIn(SingletonComponent::class)
class AdapterModule {

    @Singleton
    @Provides
    fun provideRestaurantAdapter(): RestaurantAdapter {
        return RestaurantAdapter()
    }

    @Singleton
    @Provides
    fun provideMenuAdapter(): MenuAdapter {
        return MenuAdapter()
    }

    @Singleton
    @Provides
    fun provideReviewAdapter(): ReviewAdapter {
        return ReviewAdapter()
    }
}