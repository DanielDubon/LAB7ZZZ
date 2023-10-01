package com.example.lab7zzz.ui.theme.networking.response

import com.google.gson.annotations.SerializedName


data class MealsCategoriesResponse(val categories: List<MealResponse>)

data class MealResponse(
    @SerializedName("idCategory") val id: String,
    @SerializedName("strCategory") val name: String,
    @SerializedName("strMealThumb") val mealthumb: String,
    @SerializedName("strCategoryDescription") val description: String,
    @SerializedName("strCategoryThumb") val imageUrl: String
)