package com.petrovpavel.mealplanning.bottom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

class BottomNavigationActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            BottomNavView(navController)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavView(navController: NavHostController) {

    Scaffold(
        bottomBar = {
            BottomNavigation(navController = navController)
        },
        content = {
                paddingValues: PaddingValues -> Column(Modifier.padding(paddingValues)) {
                    NavigationGraph(navController = navController)
                }
        }
    )
}

@Composable
fun BottomNavigation(navController: NavHostController) {
    val items = listOf(
        BottomNavItem.Recipes,
        BottomNavItem.MealPlan,
        BottomNavItem.Cart,
        BottomNavItem.Account
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    NavigationBar {
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = { Text(
                    text = item.title,
                    fontWeight = FontWeight.SemiBold
                )},
//                selectedContentColor = Color.Black,
//                unselectedContentColor = Color.Black.copy(0.4f),
//                alwaysShowLabel = false,
                selected = currentRoute == item.screen_route,
                onClick = {
                    navController.navigate(item.screen_route) {

                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomNavItem.Recipes.screen_route) {
        composable(BottomNavItem.Recipes.screen_route) {
            RecipesScreen()
        }
        composable(BottomNavItem.MealPlan.screen_route) {
            MealPlanScreen()
        }
        composable(BottomNavItem.Cart.screen_route) {
            CartScreen()
        }
        composable(BottomNavItem.Account.screen_route) {
            AccountScreen()
        }
    }
}