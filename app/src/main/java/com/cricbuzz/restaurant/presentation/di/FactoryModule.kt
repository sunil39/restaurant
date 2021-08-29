package com.cricbuzz.restaurant.presentation.di

import android.app.Application
import com.cricbuzz.restaurant.domain.usecase.*
import com.cricbuzz.restaurant.presentation.viewmodel.RestaurantViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
/**
 * Created by Sunilkumar V on 29/08/21.
 * This class created for Injecting ViewModelFactory into Hilt
 */
@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {

    @Singleton
    @Provides
    fun provideRestaurantViewModelFactory(
        application: Application,
        getSearchedRestaurantUseCase: GetSearchedRestaurantUseCase,
        getRestaurantUseCase: GetRestaurantUseCase,
        resourceToDbUseCase: ResourceToDbUseCase,
        getRestaurantDetailsUseCase: GetRestaurantDetailsUseCase,
        getMenuItemsUseCase: GetMenuItemsUseCase,
        getReviewUseCase: GetReviewUseCase,
        getOperatingHourUseCase: GetOperatingHourUseCase
    ): RestaurantViewModelFactory {
        return RestaurantViewModelFactory(
            application,
            getSearchedRestaurantUseCase,
            getRestaurantUseCase,
            resourceToDbUseCase,
            getRestaurantDetailsUseCase,
            getMenuItemsUseCase,
            getReviewUseCase,
            getOperatingHourUseCase
        )
    }

}








