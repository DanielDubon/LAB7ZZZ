package com.example.lab7zzz.ui.theme.UI.meals.view



import androidx.lifecycle.ViewModel
import com.example.lab7zzz.ui.theme.UI.meals.repository.MealsRepository
import com.example.lab7zzz.ui.theme.networking.response.MealsCategoriesResponse


class MealsCategoriesViewModel (private val repository: MealsRepository = MealsRepository()): ViewModel() {
    fun getMeals(successCallback: (response: MealsCategoriesResponse?) -> Unit) {
        repository.getMeals { response ->
            successCallback(response)
        }
    }
}