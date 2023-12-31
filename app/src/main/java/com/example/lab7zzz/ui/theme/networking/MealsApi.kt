package com.example.lab7zzz.ui.theme.networking



import com.example.lab7zzz.ui.theme.networking.response.CategoriesResponse
import com.example.lab7zzz.ui.theme.networking.response.MealDetailResponse
import com.example.lab7zzz.ui.theme.networking.response.MealsCategoriesResponse

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MealsApi {
    @GET("categories.php")
    fun getMeals(): Call<MealsCategoriesResponse>

    @GET("filter.php")
    fun getMealsInCategory(@Query("c") categoryId: String): Call<CategoriesResponse>

    @GET("lookup.php")
    suspend fun getMealDetail(@Query("i") mealId: String): MealDetailResponse?
}