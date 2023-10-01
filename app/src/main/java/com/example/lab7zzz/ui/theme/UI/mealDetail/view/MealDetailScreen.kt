package com.example.lab7zzz.ui.theme.UI.mealDetail.view



import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter


@Composable
fun MealDetailScreen(mealId: String, navController: NavController) {

    val viewModel: MealDetailViewModel = viewModel()

    LaunchedEffect(mealId) {
        viewModel.getMealDetail(mealId)
    }

    val mealDetail by viewModel.mealDetail.collectAsState(null)

    val currentMealId by rememberUpdatedState(mealId)


    Column(modifier = Modifier
        .fillMaxWidth()
        .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Button(modifier = Modifier.fillMaxWidth().padding(8.dp),
            onClick = { navController.navigate("Category/${mealDetail!!.meals?.first()?.strCategory}") }) {
            Text(text = "Back")
        }
        if (mealDetail != null) {

            Text(
                modifier = Modifier.padding(2.dp),
                style = MaterialTheme.typography.headlineLarge,
                color = Color.White,
                text = mealDetail!!.meals?.first()?.strMeal ?: "Trabajando....")

            Card( modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)) {
                Text(text = "Details")
                Text(text = ("Area: " + mealDetail!!.meals?.first()?.strArea) ?: "N/A")
                Text(text = ("Category: "+ mealDetail!!.meals?.first()?.strCategory) ?: "N/A")

            }



            Card( modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)) {


                
                Text(text = "Instructions: ")
                Text(text = mealDetail!!.meals?.first()?.strInstructions ?: "N/A")

                Image(

                    painter = rememberImagePainter( mealDetail!!.meals?.first()?.mealthumb),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
            }





        } else {
            Text("--Comida preparandose--")
        }

    }
}