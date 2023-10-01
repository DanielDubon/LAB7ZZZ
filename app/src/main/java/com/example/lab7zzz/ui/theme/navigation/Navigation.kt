package com.example.lab7zzz.ui.theme.navigation



import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab7zzz.ui.theme.UI.mealDetail.view.MealDetailScreen
import com.example.lab7zzz.ui.theme.UI.mealsincategory.view.MealsInCategoryScreen
import com.zezzi.eventzezziapp.ui.meals.view.MealsCategoriesScreen


@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = NavigationState.Home.route,
        modifier = modifier) {
        composable(route = NavigationState.Home.route) {
            MealsCategoriesScreen(navController = navController)

        }

        composable(route = NavigationState.Category.route) {
                backStackEntry ->
            val categoryId = backStackEntry.arguments?.getString("categoryId")
            if (categoryId != null) {

                MealsInCategoryScreen(categoryId, navController)
            }

        }
        composable(route = "${NavigationState.Detail.route}/{mealId}") { backStackEntry ->
            val mealId = backStackEntry.arguments?.getString("mealId")
            if (mealId != null) {
                MealDetailScreen(mealId, navController)
            }

    }
}
}