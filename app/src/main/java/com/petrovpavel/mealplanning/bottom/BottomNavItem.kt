package com.petrovpavel.mealplanning.bottom

import com.petrovpavel.mealplanning.R

sealed class BottomNavItem(var title:String, var icon:Int, var screen_route:String){

    object Recipes : BottomNavItem("Recipes", R.drawable.outline_trending_up_24,"recipes")
    object MealPlan: BottomNavItem("Meal plan", R.drawable.outline_calendar_month_24,"meal_plan")
    object Cart: BottomNavItem("Cart", R.drawable.outline_shopping_cart_24,"cart")
    object Account: BottomNavItem("Account", R.drawable.outline_account_circle_24,"account")
}