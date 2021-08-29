package com.cricbuzz.restaurant.data.repository

import androidx.lifecycle.LiveData
import com.cricbuzz.restaurant.data.model.*
import com.cricbuzz.restaurant.data.repository.dataSource.RestaurantLocalDataSource
import com.cricbuzz.restaurant.domain.repository.RestaurantRepository
import org.json.JSONObject
/**
 * Created by Sunilkumar V on 29/08/21.
 * Repository class for restaurants created for doing all operations related to it
 */
class RestaurantRepositoryImpl(private val restaurantLocalDataSource: RestaurantLocalDataSource) :
    RestaurantRepository {

    override fun getSearchedRestaurant(searchQuery: String): LiveData<List<Restaurant>> {
        return restaurantLocalDataSource.getSearchedRestaurant(searchQuery)
    }

    override fun getRestaurant(): LiveData<List<Restaurant>> {
        return restaurantLocalDataSource.getRestaurant()
    }

    override fun getRestaurantDetails(id: Int): LiveData<Restaurant> {
        return restaurantLocalDataSource.getRestaurantDetails(id)
    }

    override fun getMenuItems(id: Int): LiveData<List<MenuItems>> {
        return restaurantLocalDataSource.getMenuItems(id)
    }

    override fun getReview(id: Int): LiveData<List<Review>> {
        return restaurantLocalDataSource.getReview(id)
    }

    override fun getOperatingHour(id: Int): LiveData<OperatingHours> {
        return restaurantLocalDataSource.getOperatingHour(id)
    }

    override suspend fun resourceToDb() {
        saveResourceToDbRestaurant()
        saveResourceToDbMenu()
    }

    private suspend fun saveResourceToDbRestaurant() {
        val jsonArray = JSONObject(readJSONFromResource("restaurant.json")!!).getJSONArray("restaurants")

        for (a in 0 until jsonArray.length()) {
            val restaurant = jsonArray.getJSONObject(a)
            val id = restaurant.getInt("id")
            val name = restaurant.getString("name")
            val neighborhood = restaurant.getString("neighborhood")
            val photograph = restaurant.getString("photograph")
            val address = restaurant.getString("address")
            val cuisineType = restaurant.getString("cuisine_type")
            val restaurantId = restaurantLocalDataSource.saveRestaurant(
                Restaurant(
                    id,
                    name,
                    neighborhood,
                    photograph,
                    address,
                    cuisineType
                )
            )
            val latitudeLongitude = restaurant.getJSONObject("latlng")
            val latitude = latitudeLongitude.getString("lat")
            val longitude = latitudeLongitude.getString("lng")
            restaurantLocalDataSource.saveLatitudeLongitude(
                LatitudeLongitude(
                    null,
                    restaurantId,
                    latitude.toDouble(),
                    longitude.toDouble()
                )
            )
            val operatingHours = restaurant.getJSONObject("operating_hours")
            val sunday = operatingHours.getString("Sunday")
            val monday = operatingHours.getString("Monday")
            val tuesday = operatingHours.getString("Tuesday")
            val wednesday = operatingHours.getString("Wednesday")
            val thursday = operatingHours.getString("Thursday")
            val friday = operatingHours.getString("Friday")
            val saturday = operatingHours.getString("Saturday")
            restaurantLocalDataSource.saveOperatingHour(
                OperatingHours(
                    null,
                    restaurantId,
                    monday,
                    tuesday,
                    wednesday,
                    thursday,
                    friday,
                    saturday,
                    sunday
                )
            )
            val reviews = restaurant.getJSONArray("reviews")

            for (a in 0 until reviews.length()) {
                val review = reviews.getJSONObject(a)
                val reviewName = review.getString("name")
                val reviewDate = review.getString("date")
                val reviewRating = review.getInt("rating")
                val reviewComments = review.getString("comments")
                restaurantLocalDataSource.saveReview(
                    Review(
                        null,
                        restaurantId,
                        reviewName,
                        reviewDate,
                        reviewRating,
                        reviewComments
                    )
                )
            }
        }
    }

    private suspend fun saveResourceToDbMenu() {

        val jsonArray = JSONObject(readJSONFromResource("menus.json")!!).getJSONArray("menus")

        for (a in 0 until jsonArray.length()) {
            val menu = jsonArray.getJSONObject(a)
            val restaurantId = menu.getInt("restaurantId")
            val categories = menu.getJSONArray("categories")

            for (b in 0 until categories.length()) {
                val category = categories.getJSONObject(b)
                val name = category.getString("name")
                val menuItems = category.getJSONArray("menu-items")
                val categoryId =
                    restaurantLocalDataSource.saveCategory(Categories(null, restaurantId.toLong(), name))

                for (c in 0 until menuItems.length()) {
                    val menuItem = menuItems.getJSONObject(c)
                    val menuName = menuItem.getString("name")
                    val menuDescription = menuItem.getString("description")
                    val price = menuItem.getString("price")
                    val images = menuItem.getJSONArray("images")
                    var image = ""
                    if (images.length() > 0) {
                        image = images.get(0).toString()
                    }
                    restaurantLocalDataSource.saveMenuItem(
                        MenuItems(
                            null,
                            categoryId,
                            menuName,
                            menuDescription,
                            price.toFloat(),
                            image
                        )
                    )
                }
            }
        }

    }

    private fun readJSONFromResource(fileName: String): String? {
        var json: String? = null
        try {
            val inputStream = javaClass.classLoader!!.getResourceAsStream(fileName)
            json = inputStream.bufferedReader().use { it.readText() }
        } catch (ex: Exception) {
            ex.printStackTrace()
            return null
        }
        return json
    }
}