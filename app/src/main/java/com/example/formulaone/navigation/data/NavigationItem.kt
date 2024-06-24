package com.example.formulaone.navigation.data

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController

data class NavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val navigationCallback: (NavHostController) -> Unit,
)
