package com.petrovpavel.mealplanning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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
                    BottomNavView(navController)
                }
            }
        }
    }
}