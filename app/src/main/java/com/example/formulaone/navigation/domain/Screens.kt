package com.example.formulaone.navigation.domain

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.formulaone.navigation.data.NavigationItem
import kotlinx.serialization.Serializable

@Serializable
object Home

@Serializable
object Drivers

@Serializable
object Constructors

@Serializable
object Circuits

@Composable
fun Home(modifier: Modifier = Modifier) {
    Text(
        text = "You are home",
        modifier = modifier
    )
}

val screens = listOf(
    NavigationItem(
        "Home",
        Icons.Filled.Home,
        Icons.Outlined.Home,
        navigationCallback = {
            it.navigate(Home)
        },
    ),
    NavigationItem(
        "Drivers",
        Icons.Filled.Person,
        Icons.Outlined.Person,
        navigationCallback = {
            it.navigate(Drivers)
        },
    ),
    NavigationItem(
        "Constructors",
        Icons.Filled.Build,
        Icons.Outlined.Build,
        navigationCallback = {
            it.navigate(Constructors)
        },
    ),
    NavigationItem(
        "Circuits",
        Icons.Filled.Place,
        Icons.Outlined.Place,
        navigationCallback = {
            it.navigate(Circuits)
        },
    ),
)
