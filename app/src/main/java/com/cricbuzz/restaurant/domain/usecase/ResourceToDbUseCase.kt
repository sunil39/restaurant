package com.cricbuzz.restaurant.domain.usecase

import com.cricbuzz.restaurant.domain.repository.RestaurantRepository
/**
 * Created by Sunilkumar V on 29/08/21.
 */
class ResourceToDbUseCase(private val restaurantRepository: RestaurantRepository) {
    suspend fun execute() {
        restaurantRepository.resourceToDb()
    }
}