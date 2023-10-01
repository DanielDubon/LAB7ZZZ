package com.example.lab7zzz.ui.theme.UI.mealsincategory.view

import androidx.lifecycle.ViewModel
import com.example.lab7zzz.ui.theme.UI.mealsincategory.repository.MealsInCategoryRepository
import com.example.lab7zzz.ui.theme.networking.response.CategoriesResponse


class MealsInCategoryViewModel(private val repository: MealsInCategoryRepository = MealsInCategoryRepository()): ViewModel() {
    fun getMealsInCategory(categoryId: String, successCallback: (response: CategoriesResponse?) -> Unit) {
        println("ViewModel getMealsInCategory Invoked with categoryId: $categoryId")

        repository.getMealsInCategory(categoryId) { response ->
            successCallback(response)
        }
    }
}