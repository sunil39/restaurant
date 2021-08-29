package com.cricbuzz.restaurant.domain.usecase

import androidx.lifecycle.LiveData
import com.cricbuzz.restaurant.data.model.Review
import com.cricbuzz.restaurant.domain.repository.RestaurantRepository
/**
 * Created by Sunilkumar V on 29/08/21.
 */
class GetReviewUseCase(private val restaurantRepository: RestaurantRepository) {

    fun execute(id: Int): LiveData<List<Review>> {
        return restaurantRepository.getReview(id)
    }
}