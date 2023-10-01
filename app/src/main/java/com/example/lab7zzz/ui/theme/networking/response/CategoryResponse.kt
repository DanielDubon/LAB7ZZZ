package com.example.lab7zzz.ui.theme.networking.response



import com.google.gson.annotations.SerializedName

data class CategoriesResponse( @SerializedName("meals") val categories: List<CategoryResponse>)

data class CategoryResponse(
    @SerializedName("strMeal") val name: String,
    @SerializedName("strMealThumb") val mealthumb: String,
    @SerializedName("strCategoryThumb") val imageUrl: String,
    @SerializedName("idMeal") val idmeal: String
)