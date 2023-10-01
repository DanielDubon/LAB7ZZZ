package com.example.lab7zzz.ui.theme.navigation


sealed class NavigationState(val route: String) {
    object Home: NavigationState("Home")
    object Category: NavigationState("Category/{categoryId}")
    object Events: NavigationState("Event")
    object Detail: NavigationState("Detail")
    object Profile: NavigationState("Profile")
    object Settings: NavigationState("Settings")
}