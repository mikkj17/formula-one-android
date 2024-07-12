package com.example.formulaone.navigation.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.formulaone.circuit.presentation.CircuitListScreen
import com.example.formulaone.constructor.presentation.ConstructorListScreen
import com.example.formulaone.driver.presentation.DriverListScreen
import com.example.formulaone.home.presentation.HomeScreen
import com.example.formulaone.navigation.domain.Circuits
import com.example.formulaone.navigation.domain.Constructors
import com.example.formulaone.navigation.domain.Drivers
import com.example.formulaone.navigation.domain.Home
import com.example.formulaone.navigation.domain.screens
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation() {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    var selectedIndex by remember {
        mutableIntStateOf(0)
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Spacer(modifier = Modifier.height(16.dp))
                screens.forEachIndexed { index, navigationItem ->
                    val selected = index == selectedIndex
                    val icon =
                        if (selected)
                            navigationItem.selectedIcon
                        else
                            navigationItem.unselectedIcon

                    NavigationDrawerItem(
                        label = { Text(text = navigationItem.title) },
                        selected = selected,
                        onClick = {
                            navigationItem.navigationCallback(navController)
                            selectedIndex = index
                            coroutineScope.launch {
                                drawerState.close()
                            }
                        },
                        icon = {
                            Icon(
                                imageVector = icon,
                                contentDescription = navigationItem.title,
                            )
                        },
                        modifier = Modifier
                            .padding(NavigationDrawerItemDefaults.ItemPadding)
                    )
                }
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text("Formula One")
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            coroutineScope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Menu",
                            )
                        }
                    }
                )
            }
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(horizontal = 16.dp)
            ) {
                NavHost(
                    navController = navController,
                    startDestination = Home
                ) {
                    composable<Home> {
                        HomeScreen()
                    }
                    composable<Drivers> {
                        DriverListScreen()
                    }
                    composable<Constructors> {
                        ConstructorListScreen()
                    }
                    composable<Circuits> {
                        CircuitListScreen()
                    }
                }
            }
        }
    }
}
