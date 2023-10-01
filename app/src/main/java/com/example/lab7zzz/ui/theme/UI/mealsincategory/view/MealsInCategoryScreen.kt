package com.example.lab7zzz.ui.theme.UI.mealsincategory.view



import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.Card
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
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.lab7zzz.ui.theme.navigation.NavigationState
import com.example.lab7zzz.ui.theme.networking.response.CategoryResponse
import com.example.lab7zzz.ui.theme.networking.response.MealResponse


@Composable
fun MealsInCategoryScreen(categoryId: String, navController: NavController) {
    val viewModel: MealsInCategoryViewModel = viewModel()
    val rememberedMeals: MutableState<List<CategoryResponse>> = remember { mutableStateOf(emptyList<CategoryResponse>()) }


    viewModel.getMealsInCategory(categoryId) { response ->


        if (response != null) {
            rememberedMeals.value = response.categories.orEmpty()


        }
    }


    Column( modifier = Modifier.fillMaxWidth().background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Button(
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            onClick = { navController.navigate("Home") }) {
            androidx.compose.material3.Text(text = "Back")

        }

        Text(
            text = "Categoria de $categoryId",
            modifier = Modifier.padding(2.dp),
            style = MaterialTheme.typography.headlineLarge,
            color = Color.White

        )


        LazyColumn {
            items(rememberedMeals.value) { meal ->

                MealsInCategoryCard(meal, navController)

            }
        }
    }
}

@Composable
fun MealsInCategoryCard( categoryResponse: CategoryResponse, navController: NavController){

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {

                navController.navigate("${NavigationState.Detail.route}/${categoryResponse.idmeal}")
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

                painter = rememberImagePainter(categoryResponse.mealthumb),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Text(
                text = categoryResponse.name,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                textAlign = TextAlign.Left,
                modifier = Modifier.padding(8.dp)
            )

        }
    }
}


