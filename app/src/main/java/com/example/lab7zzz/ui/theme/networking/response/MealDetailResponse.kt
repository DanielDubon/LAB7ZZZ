package com.example.lab7zzz.ui.theme.networking.response



import com.google.gson.annotations.SerializedName

data class MealDetailResponse(
    @SerializedName("meals") val meals: List<MealDetail>?
)

data class MealDetail(
    @SerializedName("idMeal") val idMeal: String,
    @SerializedName("strMeal") val strMeal: String,
    @SerializedName("strMealThumb") val mealthumb: String,
    @SerializedName("strCategoryThumb") val imageUrl: String,
    @SerializedName("strInstructions") val strInstructions: String,
    @SerializedName("strArea") val strArea: String,
    @SerializedName("strCategory") val strCategory: String

)