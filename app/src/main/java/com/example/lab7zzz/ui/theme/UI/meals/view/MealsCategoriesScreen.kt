package com.zezzi.eventzezziapp.ui.meals.view

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.lab7zzz.ui.theme.UI.meals.view.MealsCategoriesViewModel
import com.example.lab7zzz.ui.theme.networking.response.MealDetail
import com.example.lab7zzz.ui.theme.networking.response.MealResponse
import com.example.lab7zzz.ui.theme.networking.response.MealsCategoriesResponse


@Composable
fun MealsCategoriesScreen(navController: NavController) {
    val viewModel: MealsCategoriesViewModel = viewModel()
    val rememberedMeals: MutableState<List<MealResponse>> = remember { mutableStateOf(emptyList<MealResponse>()) }

    viewModel.getMeals { response: MealsCategoriesResponse? ->
        val mealsFromTheApi = response?.categories
        rememberedMeals.value = mealsFromTheApi.orEmpty()
    }

    Column( modifier = Modifier.fillMaxWidth().background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally) {


        Text(
            text = "Categorias de Comidas Deliciosas",
            modifier = Modifier.padding(2.dp),

            style = MaterialTheme.typography.headlineLarge,
            color = Color.White

        )

        LazyColumn {


            items(rememberedMeals.value) { meal ->
                CategoryMealCard(mealResponse = meal, navController)


            }
        }
    }

}


@Composable
fun CategoryMealCard(mealResponse: MealResponse, navController: NavController){

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {

                navController.navigate("Category/${mealResponse.name}")
            },
    ){

        Surface(  modifier = Modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(8.dp))
            .fillMaxWidth(0.5f)
            .aspectRatio(1f)
            )
        {

            Image(
                painter = rememberImagePainter(mealResponse.imageUrl),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Text(
                text = mealResponse.name,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                textAlign = TextAlign.Left,
                modifier = Modifier.padding(8.dp)
            )

        }
        }
            }

