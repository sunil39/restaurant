package com.cricbuzz.restaurant.presentation.di

import com.cricbuzz.restaurant.domain.repository.RestaurantRepository
import com.cricbuzz.restaurant.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
/**
 * Created by Sunilkumar V on 29/08/21.
 * This class created for Injecting all use cases into Hilt
 */
@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun provideGetSearchedRestaurantUseCase(restaurantRepository: RestaurantRepository): GetSearchedRestaurantUseCase {
        return GetSearchedRestaurantUseCase(restaurantRepository)
    }

    @Singleton
    @Provides
    fun provideGetRestaurantUseCase(restaurantRepository: RestaurantRepository): GetRestaurantUseCase {
        return GetRestaurantUseCase(restaurantRepository)
    }

    @Singleton
    @Provides
    fun provideResourceToDbUseCase(restaurantRepository: RestaurantRepository): ResourceToDbUseCase {
        return ResourceToDbUseCase(restaurantRepository)
    }

    @Singleton
    @Provides
    fun provideRestaurantDetailsUseCase(restaurantRepository: RestaurantRepository): GetRestaurantDetailsUseCase {
        return GetRestaurantDetailsUseCase(restaurantRepository)
    }

    @Singleton
    @Provides
    fun provideMenuItemUseCase(restaurantRepository: RestaurantRepository): GetMenuItemsUseCase {
        return GetMenuItemsUseCase(restaurantRepository)
    }

    @Singleton
    @Provides
    fun provideReviewUseCase(restaurantRepository: RestaurantRepository): GetReviewUseCase {
        return GetReviewUseCase(restaurantRepository)
    }

    @Singleton
    @Provides
    fun provideOperatingHourUseCase(restaurantRepository: RestaurantRepository): GetOperatingHourUseCase {
        return GetOperatingHourUseCase(restaurantRepository)
    }

}


















