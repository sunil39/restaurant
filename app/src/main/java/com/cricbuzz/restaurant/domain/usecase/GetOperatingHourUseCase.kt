package com.cricbuzz.restaurant.domain.usecase

import androidx.lifecycle.LiveData
import com.cricbuzz.restaurant.data.model.OperatingHours
import com.cricbuzz.restaurant.domain.repository.RestaurantRepository
/**
 * Created by Sunilkumar V on 29/08/21.
 */
class GetOperatingHourUseCase(private val restaurantRepository: RestaurantRepository) {

    fun execute(id: Int): LiveData<OperatingHours> {
        return restaurantRepository.getOperatingHour(id)
    }
}