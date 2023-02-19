package com.petrovpavel.mealplanning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.petrovpavel.mealplanning.ui.theme.MealPlanningTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealPlanningTheme {
                val navController = rememberNavController()
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.primary
                ) {
                    BottomNavigation(navController)
                }
            }
        }
    }
}

@Composable
fun BottomNavigation(navHostController: NavHostController) {
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf("Receipts", "Meal plan", "Cart", "Account")

    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Icon(Icons.Filled.Favorite, contentDescription = item) },
                label = { Text(item) },
                selected = selectedItem == index,
                onClick = { selectedItem = index }
            )
        }
    }
}